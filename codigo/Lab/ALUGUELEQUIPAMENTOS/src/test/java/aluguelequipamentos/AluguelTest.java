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
    }

    //COMMIT PEDRO
    
    @Test
    public void testRegistrarAluguelEConsultarValorTotal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataInicio = dateFormat.parse("01/09/2023");
            Date dataFim = dateFormat.parse("10/09/2023");

            cliente.registrarAluguel(equipamento, dataInicio, dataFim);

            // Consulta o aluguel registrado
            Aluguel aluguel = cliente.getAlugueis().get(0);

            // Verifica o valor total do aluguel
            double valorCalculado = aluguel.calcularValorTotal();
            assertEquals(900.0, valorCalculado, 0.01);
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
             cliente.registrarAluguel(equipamento, data1, data2);
             cliente.registrarAluguel(equipamento, data2, data3);
 
             // Consulta a receita para setembro (mês 9)
             double receitaSetembro = cliente.consultarReceitaMensal(9);
             assertEquals(5200.0, receitaSetembro, 0.01);
 
             // Consulta a receita para outubro (mês 10)
             double receitaOutubro = cliente.consultarReceitaMensal(10);
             assertEquals(0.0, receitaOutubro, 0.01);
 
             // Consulta a receita para um mês sem aluguéis (mês 11)
             double receitaNovembro = cliente.consultarReceitaMensal(11);
             assertEquals(0.0, receitaNovembro, 0.01);
 
         } catch (ParseException e) {
             e.printStackTrace();
         }
     }

    //COMMIT ARTHUR
    @Test
    public void testGerarRelatorioMensal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data1 = dateFormat.parse("01/09/2023");
            Date data2 = dateFormat.parse("15/09/2023");
            Date data3 = dateFormat.parse("01/10/2023");

            // Registra aluguéis em setembro e outubro
            cliente.registrarAluguel(equipamento, data1, data2);
            cliente.registrarAluguel(equipamento, data2, data3);

            // Gera relatório para setembro (mês 9)
            double faturamentoSetembro = cliente.gerarRelatorioMensal(9);
            assertEquals(8200.0, faturamentoSetembro, 0.01);

            // Gera relatório para outubro (mês 10)
            double faturamentoOutubro = cliente.gerarRelatorioMensal(10);
            assertEquals(0.0, faturamentoOutubro, 0.01);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    //COMMIT JULIA
    @Test
    public void testConsultarAlugueisPassadosEAtuais() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataAtual = new Date();
            Date dataPassada = dateFormat.parse("01/08/2023");
            Date dataFutura = dateFormat.parse("01/10/2023");

            // Registra aluguéis passados e atuais
            cliente.registrarAluguel(equipamento, dataPassada, dataAtual);
            cliente.registrarAluguel(equipamento, dataAtual, dataFutura);

            // Consulta aluguéis passados
            int totalAlugueisPassados = cliente.getAlugueisPassados().size();
            assertEquals(1, totalAlugueisPassados);

            // Consulta aluguéis atuais
            int totalAlugueisAtuais = cliente.getAlugueisAtuais().size();
            assertEquals(2, totalAlugueisAtuais);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

 }

