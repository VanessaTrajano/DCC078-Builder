import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteBuilderTest {

    @Test
    void deveRetornarExcecaoParaPacienteSemCpf() {
        try {
            PacienteBuilder pacienteBuilder = new PacienteBuilder();
            Paciente paciente = pacienteBuilder
                    .setNome("Paciente 1")
                    .setEmail("paciente1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CPF inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPacienteSemNome() {
        try {
            PacienteBuilder pacienteBuilder = new PacienteBuilder();
            Paciente paciente = pacienteBuilder
                    .setCpf("123.456.789-00")
                    .setEmail("paciente1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPacienteValido() {
        PacienteBuilder pacienteBuilder = new PacienteBuilder();
        Paciente paciente = pacienteBuilder
                .setCpf("123.456.789-00")
                .setNome("Paciente 1")
                .setEmail("paciente1@email.com")
                .build();

        assertNotNull(paciente);
    }
}