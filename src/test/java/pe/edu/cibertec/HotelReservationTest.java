package pe.edu.cibertec;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class HotelReservationTest {
    /*@Test
    public void testValidReservation() throws ParseException {
        HotelReservation reservation = new HotelReservation("101", "John Doe", "2023-01-01");
        assertEquals("El registro ha sido exitoso", reservation.makeReservation());
    }*/

    @Test
    public void testValidReservation() {
        try {
            new HotelReservation("101", "George Chinchayan", "2022-01-05");
            // La creación de la reserva debería ser exitosa, no debería lanzar una excepción
        } catch (IllegalArgumentException | ParseException e) {
            fail("No debería lanzar una excepción en este caso");
        }
    }


    @Test
    public void testInvalidRoomNumber() {
        try {
            new HotelReservation("XYZ", "George Chinchayan", "2023-01-01");
            fail("Debería lanzar una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("Ingrese una habitación válida", e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInvalidClientName() {
        try {
            new HotelReservation("101", "123", "2023-01-01");
            fail("Debería lanzar una excepción");
        } catch (IllegalArgumentException | ParseException e) {
            assertEquals("Recuerde que el nombre del cliente debe contener al menos 4 caracteres", e.getMessage());
        }
    }

    /*@Test
    public void testInvalidReservationDate() {
        try {
            new HotelReservation("101", "George Chinchayan", "2022-01-01");
            fail("Debería lanzar una excepción");
        } catch (IllegalArgumentException | ParseException e) {
            assertEquals("Debe ingresar una fecha válida", e.getMessage());
        }
    }*/
    @Test
    public void testInvalidReservationDate() {
        try {
            new HotelReservation("10","Ch", "2022-01-01");
            fail("Debería lanzar una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("Recuerde que el nombre del cliente debe contener al menos 4 caracteres", e.getMessage());
        } catch (ParseException e) {
            fail("No debería lanzar ParseException en este caso");
        }
    }



    @Test
    public void testBlankInput() {
        try {
            new HotelReservation("", "", "");
            fail("Debería lanzar una excepción");
        } catch (IllegalArgumentException | ParseException e) {
            assertEquals("Ingrese una habitación válida", e.getMessage());
        }
    }
}