package me.mati.Util;

import me.mati.ArbolAVL.TElementoAVL;
import me.mati.ArbolBB.*;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter {
    static int padding = 2;

    private static int indent(List<String> lines, int margin) {
        if (margin >= 0) return margin;
        String spaces = " ".repeat(-margin);
        int i = 0;
        for (var line : lines) {
            lines.set(i++, spaces + line);
        }
        return 0;
    }

    private static List<String> merge(List<String> left, List<String> right) {
        int minSize = Math.min(left.size(), right.size());
        int offset = 0;
        for (int i = 0; i < minSize; i++) {
            offset = Math.max(offset, left.get(i).length() + padding - right.get(i).replaceAll("\\S.*", "").length());
        }
        indent(right, -indent(left, offset));
        for (int i = 0; i < minSize; i++) {
            left.set(i, left.get(i) + right.get(i).substring(left.get(i).length()));
        }
        if (right.size() > minSize) {
            left.addAll(right.subList(minSize, right.size()));
        }
        return left;
    }

    private static TElementoAB Root = null;

    private static List<String> buildLines(TElementoAB node, int level) {
        if (node == null) return new ArrayList<>();
        List<String> lines = merge(buildLines(node.getHijoIzq(), level + 1), buildLines(node.getHijoDer(), level + 1));
        int half = String.valueOf(node.getEtiqueta()).length() / 2;
        int i = half;
        if (lines.size() > 0) {
            String line;
            i = lines.get(0).indexOf("*");
            if (node.getHijoDer() == null) {
                line = " ".repeat(i) + "┌─┘";
                i += 2;
            } else if (node.getHijoIzq() == null) {
                line = " ".repeat(i = indent(lines, i - 2)) + "└─┐";
            } else {
                int dist = lines.get(0).length() - 1 - i;
                line = String.format("%s┌%s┴%s┐", " ".repeat(i), "─".repeat(dist / 2 - 1), "─".repeat((dist - 1) / 2));
                i += dist / 2;
            }
            lines.set(0, line);
        }
        lines.add(0, " ".repeat(indent(lines, i - half - 3)) + level + ": (" + node.getEtiqueta() + ")");
        lines.add(0, " ".repeat(i + Math.max(0, half - i + 3)) + "*"); // Add a marker for caller
        return lines;
    }

    public static String print(TElementoAB root) {
        List<String> lines = buildLines(root, 0);
        return String.join("\n", lines.subList(1, lines.size()));
    }
}
