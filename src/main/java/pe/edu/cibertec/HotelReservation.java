package pe.edu.cibertec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelReservation {
    private String numeroCuarto;
    private String nombreCliente;
    private Date fechaReserva;

    public HotelReservation(String numeroCuarto, String nombreCliente, String fechaReserva) throws ParseException {
        this.numeroCuarto = validarNumeroCuarto(numeroCuarto);
        this.nombreCliente = validarNumeroCliente(nombreCliente);
        this.fechaReserva = validateReservationDate(fechaReserva);
    }

    private String validarNumeroCuarto(String numeroCuarto) {
        if (numeroCuarto.matches("[123]\\d{2}")) {
            return numeroCuarto;
        } else {
            throw new IllegalArgumentException("Ingrese una habitación válida");
        }
    }

    private String validarNumeroCliente(String nombreCliente) {
        if (nombreCliente.matches("[a-zA-Z]{4,}")) {
            return nombreCliente;
        } else {
            throw new IllegalArgumentException("Recuerde que el nombre del cliente debe contener al menos 4 caracteres");
        }
    }

    /*private Date validateReservationDate(String fechaReserva) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Date inputDate = sdf.parse(fechaReserva);

        if (inputDate.after(currentDate)) {
            return inputDate;
        } else {
            throw new IllegalArgumentException("Debe ingresar una fecha válida");
        }
    }*/

    private Date validateReservationDate(String fechaReserva) throws ParseException {
        if (fechaReserva.isBlank()) {
            throw new IllegalArgumentException("Debe ingresar una fecha válida");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Date inputDate = sdf.parse(fechaReserva);

        if (inputDate.after(currentDate)) {
            return inputDate;
        } else {
            throw new IllegalArgumentException("Debe ingresar una fecha válida");
        }
    }


    public String makeReservation() {
        return "El registro ha sido exitoso";
    }

}
