package me.mati.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TLinkedListTest {

    TLinkedList<Integer> lista = new TLinkedList<>();

    @Test
    void insertarElemento() {
        lista.insertar(null);
        assertTrue(lista.esVacia());

        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        lista.insertar(elemento);

        assertFalse(lista.esVacia());
        assertEquals(1, lista.cantElementos());
        assertEquals("1", lista.imprimir());

        TElementoLL<Integer> elemento2 = new TElementoLL<>(2, 2);
        lista.insertar(elemento2);

        assertEquals(2, lista.cantElementos());
        assertEquals("1 -> 2", lista.imprimir());
    }

    @Test
    void insertarEtiqueta() {

        lista.insertar(null,null);
        assertTrue(lista.esVacia());

        lista.insertar(1, null);

        assertFalse(lista.esVacia());
        assertEquals(1, lista.cantElementos());
        assertEquals("1", lista.imprimir());

        lista.insertar(2, null);

        assertEquals(2, lista.cantElementos());
        assertEquals("1 -> 2", lista.imprimir());
    }

    @Test
    void buscar() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertEquals("3", lista.buscar(3).getEtiqueta().toString());
        assertEquals("2", lista.buscar(2).getEtiqueta().toString());

        assertNull(lista.buscar(4));
        assertNull(lista.buscar(null));
    }

    @Test
    void eliminar() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertTrue(lista.eliminar(2));
        assertEquals("1 -> 3", lista.imprimir());

        assertFalse(lista.eliminar(4));
        assertFalse(lista.eliminar(null));
    }

    @Test
    void imprimir() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertEquals("1 -> 2 -> 3", lista.imprimir());
    }

    @Test
    void testImprimir() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertEquals("1 y 2 y 3", lista.imprimir(" y "));

        assertEquals("1 -> 2 -> 3", lista.imprimir());

        assertEquals("1 -> 2 -> 3", lista.imprimir(null));
    }

    @Test
    void cantElementos() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertEquals(3, lista.cantElementos());

        lista.eliminar(2);
        assertEquals(2, lista.cantElementos());

        lista.eliminar(1);
        assertEquals(1, lista.cantElementos());

        lista.eliminar(null);
        assertEquals(1, lista.cantElementos());

        lista.eliminar(3);
        assertEquals(0, lista.cantElementos());

        lista.eliminar(3);
        assertEquals(0, lista.cantElementos());

        lista.insertar(null);
        assertEquals(0, lista.cantElementos());
    }

    @Test
    void cantElementosON() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertEquals(3, lista.cantElementosON());

        lista.eliminar(2);
        assertEquals(2, lista.cantElementosON());

        lista.eliminar(1);
        assertEquals(1, lista.cantElementosON());

        lista.eliminar(null);
        assertEquals(1, lista.cantElementosON());

        lista.eliminar(3);
        assertEquals(0, lista.cantElementosON());

        lista.eliminar(3);
        assertEquals(0, lista.cantElementosON());

        lista.insertar(null);
        assertEquals(0, lista.cantElementosON());
    }

    @Test
    void esVacia() {
        assertTrue(lista.esVacia());

        lista.insertar(1, null);
        assertFalse(lista.esVacia());

        lista.eliminar(1);
        assertTrue(lista.esVacia());

        lista.insertar(null);
        assertTrue(lista.esVacia());
    }

    @Test
    void setPrimero() {
        lista.insertar(1, null);
        lista.insertar(2, null);

        assertEquals("1 -> 2", lista.imprimir());

        lista.setPrimero(new TElementoLL<>(3, 3));

        assertEquals("3 -> 1 -> 2", lista.imprimir());

        lista.setPrimero(null);

        assertEquals("3 -> 1 -> 2", lista.imprimir());
    }

    @Test
    void testToString() {
        lista.insertar(1, null);
        lista.insertar(2, null);
        lista.insertar(3, null);

        assertEquals("1 -> 2 -> 3", lista.toString());
    }
}