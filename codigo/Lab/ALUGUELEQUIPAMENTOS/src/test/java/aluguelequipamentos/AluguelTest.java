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

      //COMMIT GABRIEL
     
     @Test
     public void testConsultarReceitaMensal() {
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         try {
             Date data1 = dateFormat.parse("01/09/2023");
             Date data2 = dateFormat.parse("15/10/2023");
             Date data3 = dateFormat.parse("01/11/2023");
 
             // Registra aluguéis em setembro e outubro
             cliente.registrarAluguel(cliente, equipamento, data1, data1);
             cliente.registrarAluguel(cliente, equipamento, data1, data2);
             cliente.registrarAluguel(cliente, equipamento, data2, data3);
 
             // Consulta a receita para setembro (mês 9)
             double receitaSetembro = cliente.consultarReceitaMensal(9);
             assertEquals(4400.0, receitaSetembro, 0.01);
 
             // Consulta a receita para outubro (mês 10)
             double receitaOutubro = cliente.consultarReceitaMensal(10);
             assertEquals(1700.0, receitaOutubro, 0.01);
 
             // Consulta a receita para um mês sem aluguéis (mês 11)
             double receitaNovembro = cliente.consultarReceitaMensal(11);
             assertEquals(0.0, receitaNovembro, 0.01);
 
         } catch (ParseException e) {
             e.printStackTrace();
         }
     }
 }

