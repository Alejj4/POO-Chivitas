package Punto6;

import java.util.List;

public class Punto6Main {
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("                 SISTEMA DE GESTION DE CONSULTAS CLINICAS                       ");
        System.out.println("================================================================================\n");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> PRUEBA 1: Paciente con Varias Consultas Registradas");
        System.out.println("--------------------------------------------------------------------------------");

        // 1. Creacion del paciente (su historia clinica se crea automaticamente)
        Paciente paciente1 = new Paciente(
                "38450123",
                "Lucia Fernandez",
                "15/05/1995",
                "OSDE",
                "01/01/2026",
                1001,
                5
        );

        System.out.println("Paciente creado: " + paciente1.getNombreApellido() + " | DNI: " + paciente1.getNumeroIdentificacion());
        System.out.println("Obra Social: " + paciente1.getObraSocial());
        System.out.println("Historia Clinica N°: " + paciente1.getHistoriaClinica().getNumeroHistoria() + " (Fecha de Creacion: " + paciente1.getHistoriaClinica().getFechaCreacion() + ")");

        // 2. Consultar edad del paciente
        int anioActual = 2026;
        System.out.println("Edad del paciente en " + anioActual + ": " + paciente1.consultarEdadPaciente(anioActual) + " anios");
        System.out.println();

        // 3. Creacion de consultas
        Consulta consulta1 = new Consulta(
                "10/02/2026",
                "Fiebre y dolor de garganta",
                "Faringitis aguda",
                "Amoxicilina 500mg cada 8hs por 7 dias y reposo",
                15000.0,
                true
        );

        Consulta consulta2 = new Consulta(
                "15/03/2026",
                "Control de rutina anual",
                "Chequeo general sano",
                "Mantener dieta saludable y actividad fisica",
                10000.0,
                false
        );

        Consulta consulta3 = new Consulta(
                "10/02/2026",
                "Dolor lumbar persistente",
                "Contractura muscular",
                "Ibuprofeno 600mg y 5 sesiones de kinesiologia",
                25000.0,
                true
        );

        // 4. Metodos individuales de la clase Consulta
        System.out.println("--- Resumen individual de las consultas ---");
        consulta1.MostrarResumen();
        consulta2.MostrarResumen();
        consulta3.MostrarResumen();
        System.out.println("Costo base consulta 1: $" + consulta1.getCosto());
        System.out.println("Costo con descuento obra social (50%): $" + consulta1.costoFinal(true));
        System.out.println("Costo sin obra social: $" + consulta1.costoFinal(false));
        System.out.println();

        // 5. Registrar consultas en el paciente
        System.out.println("--- Registrando consultas en la historia clinica ---");
        paciente1.registrarConsulta(consulta1);
        paciente1.registrarConsulta(consulta2);
        paciente1.registrarConsulta(consulta3);
        System.out.println();

        // 6. Pruebas sobre la clase Paciente
        System.out.println("--- Pruebas en clase Paciente ---");
        System.out.println("Costo total a pagar por el paciente (con descuento OSDE 50%): $" + paciente1.obtenerCostoTotalConsultas());
        System.out.println("¿El paciente necesita seguimiento?: " + (paciente1.necesitaSeguimiento() ? "SI" : "NO"));
        System.out.println();

        // 7. Pruebas sobre la clase HistoriaClinica
        HistoriaClinica hc1 = paciente1.getHistoriaClinica();
        System.out.println("--- Pruebas en clase HistoriaClinica ---");
        System.out.println("Total de consultas registradas: " + hc1.getCantidadConsultas());
        System.out.println("Consultas que requieren seguimiento: " + hc1.ConsultasSeguimiento());
        System.out.println("Costo promedio de las consultas: $" + String.format("%.2f", hc1.calcularCostoPromedio()));

        Consulta mayorCosto = hc1.obtenerConsultaMayorCosto();
        System.out.println("Consulta de mayor costo: " + (mayorCosto != null ? "$" + mayorCosto.getCosto() + " (" + mayorCosto.getMotivo() + ")" : "Ninguna"));

        Consulta ultima = hc1.obtenerUltimaConsulta();
        System.out.println("Ultima consulta registrada: " + (ultima != null ? ultima.getFechaAtencion() + " - " + ultima.getDiagnostico() : "Ninguna"));

        // Busqueda por fecha
        String fechaABuscar = "10/02/2026";
        List<Consulta> porFecha = hc1.buscarPorFecha(fechaABuscar);
        System.out.println("Consultas encontradas para la fecha " + fechaABuscar + ": " + porFecha.size());
        for (Consulta c : porFecha) {
            System.out.println("  -> " + c.getMotivo() + " | Diagnostico: " + c.getDiagnostico() + " | Costo: $" + c.getCosto());
        }

        // Conteo por diagnostico
        String diagABuscar = "Faringitis aguda";
        System.out.println("Cantidad de consultas con diagnostico '" + diagABuscar + "': " + hc1.contarPorDiagnostico(diagABuscar));
        System.out.println("Cantidad de consultas con diagnostico 'Gastroenteritis' (inexistente): " + hc1.contarPorDiagnostico("Gastroenteritis"));
        System.out.println("\n");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> PRUEBA 2: Historia Clinica Vacia (Sin consultas)");
        System.out.println("--------------------------------------------------------------------------------");

        Paciente pacienteVacio = new Paciente(
                "42111222",
                "Carlos Gomez",
                "20/11/2000",
                null,
                "02/09/2026",
                1002,
                5
        );

        System.out.println("Paciente registrado: " + pacienteVacio.getNombreApellido() + " (Sin obra social)");
        System.out.println("Historia Clinica N°: " + pacienteVacio.getHistoriaClinica().getNumeroHistoria());

        HistoriaClinica hcVacia = pacienteVacio.getHistoriaClinica();
        System.out.println("Cantidad de consultas: " + hcVacia.getCantidadConsultas());
        System.out.println("Costo total consultas paciente: $" + pacienteVacio.obtenerCostoTotalConsultas());
        System.out.println("¿Necesita seguimiento?: " + (pacienteVacio.necesitaSeguimiento() ? "SI" : "NO"));
        System.out.println("Costo promedio: $" + hcVacia.calcularCostoPromedio());
        System.out.println("Consulta mayor costo: " + hcVacia.obtenerConsultaMayorCosto());
        System.out.println("Ultima consulta registrada: " + hcVacia.obtenerUltimaConsulta());
        System.out.println("Consultas que requieren seguimiento: " + hcVacia.ConsultasSeguimiento());
        System.out.println("Busqueda por fecha en historia vacia: " + hcVacia.buscarPorFecha("02/09/2026").size() + " encontradas");
        System.out.println("Conteo de diagnosticos en historia vacia: " + hcVacia.contarPorDiagnostico("Gripe"));
        System.out.println("\n");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> PRUEBA 3: Historia Clinica Completa (Verificacion de capacidad maxima)");
        System.out.println("--------------------------------------------------------------------------------");

        // Creamos un paciente con capacidad maxima limitada a 2 consultas
        int capacidadMaxima = 2;
        Paciente pacienteCompleto = new Paciente(
                "35999888",
                "Mariana Lopez",
                "05/08/1990",
                "Swiss Medical",
                "15/01/2026",
                1003,
                capacidadMaxima
        );

        System.out.println("Paciente creado: " + pacienteCompleto.getNombreApellido());
        System.out.println("Capacidad maxima de su historia: " + pacienteCompleto.getHistoriaClinica().getCapacidadMaxima() + " consultas");
        System.out.println();

        Consulta c1 = new Consulta("01/04/2026", "Jaqueca severa", "Migrania", "Analgesicos", 12000.0, false);
        Consulta c2 = new Consulta("05/04/2026", "Congestion nasal", "Rinitis alergica", "Antihistaminico", 14000.0, true);
        Consulta cExcedente = new Consulta("10/04/2026", "Revision general", "Sano", "Ninguno", 8000.0, false);

        System.out.println("-> Agregando consulta 1:");
        pacienteCompleto.registrarConsulta(c1);

        System.out.println("-> Agregando consulta 2:");
        pacienteCompleto.registrarConsulta(c2);

        System.out.println("Estado actual: " + pacienteCompleto.getHistoriaClinica().getCantidadConsultas() + " de " + pacienteCompleto.getHistoriaClinica().getCapacidadMaxima() + " consultas (HISTORIA COMPLETA)");
        System.out.println();

        System.out.println("-> Intentando agregar consulta 3 (excede la capacidad maxima):");
        pacienteCompleto.registrarConsulta(cExcedente);

        System.out.println("\nVerificacion final de la historia:");
        System.out.println("Cantidad final de consultas: " + pacienteCompleto.getHistoriaClinica().getCantidadConsultas());
        System.out.println("Ultima consulta registrada: " + pacienteCompleto.getHistoriaClinica().obtenerUltimaConsulta().getDiagnostico());
        System.out.println("================================================================================");
    }
}