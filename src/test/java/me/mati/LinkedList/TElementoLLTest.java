package me.mati.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TElementoLLTest {
    @Test
    void getDato() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        assertEquals(1, elemento.getDato());

        elemento.setDato(2);
        assertEquals(2, elemento.getDato());

        elemento.setDato(null);
        assertNull(elemento.getDato());
    }

    @Test
    void setDato() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        assertEquals(1, elemento.getDato());

        elemento.setDato(2);
        assertEquals(2, elemento.getDato());

        elemento.setDato(null);
        assertNull(elemento.getDato());
    }

    @Test
    void testEquals() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        TElementoLL<Integer> elemento2 = new TElementoLL<>(1, 1);
        TElementoLL<Integer> elemento3 = new TElementoLL<>(2, 2);

        assertTrue(elemento.equals(elemento2));
        assertFalse(elemento.equals(elemento3));
    }

    @Test
    void getSiguiente() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        TElementoLL<Integer> elemento2 = new TElementoLL<>(2, 2);

        assertNull(elemento.getSiguiente());
        elemento.setSiguiente(elemento2);
        assertEquals(elemento2, elemento.getSiguiente());

        elemento.setSiguiente(null);
        assertNull(elemento.getSiguiente());

        elemento.setSiguiente(elemento);
        assertEquals(elemento, elemento.getSiguiente());
    }

    @Test
    void setSiguiente() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        TElementoLL<Integer> elemento2 = new TElementoLL<>(2, 2);

        assertNull(elemento.getSiguiente());
        elemento.setSiguiente(elemento2);
        assertEquals(elemento2, elemento.getSiguiente());

        elemento.setSiguiente(null);
        assertNull(elemento.getSiguiente());

        elemento.setSiguiente(elemento);
        assertEquals(elemento, elemento.getSiguiente());
    }

    @Test
    void getEtiqueta() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        assertEquals(1, elemento.getEtiqueta());

        elemento.setEtiqueta(2);
        assertEquals(2, elemento.getEtiqueta());

        elemento.setEtiqueta(null);
        assertNotNull(elemento.getEtiqueta());
    }

    @Test
    void compareTo() {
        TElementoLL<Integer> elemento = new TElementoLL<>(1, 1);
        TElementoLL<Integer> elemento2 = new TElementoLL<>(2, 2);
        TElementoLL<Integer> elemento3 = new TElementoLL<>(3, 3);

        assertEquals(0, elemento.compareTo(1));
        assertEquals(1, elemento2.compareTo(1));
        assertNotEquals(-1, elemento3.compareTo(1));
    }
}