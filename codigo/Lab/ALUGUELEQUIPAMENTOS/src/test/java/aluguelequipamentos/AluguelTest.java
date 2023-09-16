package aluguelequipamentos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AluguelTest {

    private Cliente cliente;
    private Equipamento equipamento;

    @BeforeAll
    public void setUp() {
        cliente = new Cliente("Pedro");
        equipamento = new Equipamento(1, "Escavadeira", 100.0);
        new Aluguel(cliente, equipamento, new Date(), new Date());
    }

    //COMMIT PEDRO

    @Test
    public void testRegistrarAluguelEConsultarValorTotal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataInicio = dateFormat.parse("01/09/2023");
            Date dataFim = dateFormat.parse("10/09/2023");

            Aluguel aluguel = cliente.registrarAluguel(cliente, equipamento, dataInicio, dataFim);

            //double valorEsperado = 100 * 10; // 100 reais por dia, 10 dias de aluguel
            double valorCalculado = aluguel.calcularValorTotal();

            assertEquals(900, valorCalculado, 0.01);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
