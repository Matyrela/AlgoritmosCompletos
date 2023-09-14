package me.mati;

import me.mati.ArbolAVL.*;
import me.mati.Util.*;

public class Main {
    public static void main(String[] args) {
        TreePrinter formatter = new TreePrinter();
        System.out.println("<<< ---------------------- [ INSERCIONES ] ---------------------- >>>");

        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/main/java/me/mati/Etc/CargarArbol.txt");

        TArbolAVL arbol = new TArbolAVL();
        int total = 0;
        for (String clave : claves) {
            int nClave = Integer.parseInt(clave);
            TElementoAVL elementoAVL = new TElementoAVL(nClave, nClave);
            if(arbol.insertar(elementoAVL) == true){
                System.out.println("INSERTADO: " + nClave);
                total++;
            }

            System.out.println(formatter.print(arbol.getRaiz()));
        }

        System.out.println("TOTAL INSERTADOS: " + total + "/" + claves.length);

        System.out.println(arbol.getRaiz().obtenerBalance());

        System.out.println("<<< ---------------------- [ CONSULTAS ] ---------------------- >>>");

        String[] consulta = ManejadorArchivosGenerico.leerArchivo("src/main/java/me/mati/Etc/PedirArbol.txt");
        String[] archivoResultado = new String[consulta.length];

        for (int i = 0; i < consulta.length; i++){
            TElementoAVL search = arbol.buscar(Integer.parseInt(consulta[i]));

            if(search != null){
                archivoResultado[i] = ("ENCONTRADO: " + search.getEtiqueta().toString());
                System.out.println("ENCONTRADO: " + consulta[i]);
            }else {
                archivoResultado[i] = ("NO ENCONTRADO: " + consulta[i]);
                System.out.println("NO ENCONTRADO: " + consulta[i]);
            }

        }

        //ManejadorArchivosGenerico.escribirArchivo("src/resultado.txt", archivoResultado);

        System.out.println("<<< ---------------------- [ RECORRIDOS ] ---------------------- >>>");

        System.out.println("PostOrden: " + arbol.postOrden());
        System.out.println("PreOrden: " + arbol.preOrden());
        System.out.println("InOrden: " + arbol.inOrden());

        System.out.println("<<< ---------------------- [ PROPIEDADES ] ---------------------- >>>");

        System.out.println("Altura: " + arbol.obtenerAltura());
        System.out.println("Tamaño: " + arbol.obtenerTamaño());

        System.out.println("<<< ---------------------- [ ARBOL ] ---------------------- >>>");

        System.out.println(formatter.print(arbol.getRaiz()));

        System.out.println("<<< ------------------------- [ FIN ] -------------------------- >>>");
    }
}
