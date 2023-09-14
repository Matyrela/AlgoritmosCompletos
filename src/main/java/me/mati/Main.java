package me.mati;

import me.mati.ArbolAVL.*;
import me.mati.ArbolBB.TElementoAB;
import me.mati.LinkedList.TLinkedList;
import me.mati.Util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("<<< ---------------------- [ INSERCIONES ] ---------------------- >>>");

        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/main/java/me/mati/Etc/CargarArbol.txt");

        TArbolAVL arbol = new TArbolAVL();
        int total = 0;
        for (String clave : claves) {
            int nClave = Integer.parseInt(clave);
            TElementoAVL elementoAVL = new TElementoAVL(nClave, nClave);

            if(arbol.insertar(elementoAVL)){
                System.out.println("INSERTADO: " + nClave);
                total++;
            }
        }

        System.out.println("TOTAL INSERTADOS: " + total + "/" + claves.length);

        if(ManejadorArchivosGenerico.existeArchivoOContenido("src/main/java/me/mati/Etc/PedirArbol.txt")){
            System.out.println("<<< ---------------------- [ CONSULTAS ] ---------------------- >>>");

            String[] consulta = ManejadorArchivosGenerico.leerArchivo("src/main/java/me/mati/Etc/PedirArbol.txt");
            String[] archivoResultado = new String[consulta.length];

            for (int i = 0; i < consulta.length; i++){
                TElementoAB search = arbol.buscar(Integer.parseInt(consulta[i]));

                if(search != null){
                    archivoResultado[i] = ("ENCONTRADO: " + search.getEtiqueta().toString());
                    System.out.println("ENCONTRADO: " + consulta[i]);
                }else {
                    archivoResultado[i] = ("NO ENCONTRADO: " + consulta[i]);
                    System.out.println("NO ENCONTRADO: " + consulta[i]);
                }
            }
        }

        System.out.println("<<< ---------------------- [ RECORRIDOS ] ---------------------- >>>");

        System.out.println("PostOrden: " + arbol.postOrden());
        System.out.println("PreOrden: " + arbol.preOrden());
        System.out.println("InOrden: " + arbol.inOrden());

        System.out.println("<<< ---------------------- [ PROPIEDADES ] ---------------------- >>>");

        System.out.println("Balance: " + ((arbol.getRaiz().obtenerBalance() >= -1 && arbol.getRaiz().obtenerBalance() <= 1) ? "Balanceado" : "No Balanceado"));
        System.out.println("Altura: " + arbol.obtenerAltura());
        System.out.println("Tamaño: " + arbol.obtenerTamaño());

        System.out.println("<<< ---------------------- [ ARBOL ] ---------------------- >>>");

        System.out.println(TreePrinter.print(arbol.getRaiz()));

        System.out.println("<<< ------------------------- [ FIN ] -------------------------- >>>");

        TLinkedList<Integer> ll = new TLinkedList<Integer>();
        ll.insertar(11, null);
        ll.insertar(12, null);
        ll.insertar(13, null);
        ll.insertar(14, null);
        ll.insertar(15, null);
        ll.insertar(16, null);
        ll.insertar(17, null);

        System.out.println(ll.toString());

        System.out.println(ll.cantElementos());

        System.out.println(ll.toString());


    }
}
