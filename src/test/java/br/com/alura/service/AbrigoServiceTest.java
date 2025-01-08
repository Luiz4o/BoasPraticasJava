package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AbrigoServiceTest {

    //Mock serve para simular comportamentos de objetos que a unidade de codigo depende, neste caso a api
    //mas poderia ser o banco de dados ou outros serviços
    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private AbrigoService abrigoService = new AbrigoService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("Teste", "61981880392", "abrigo_alura@gmail.com");

    @Test
    public void deveVerificarQuandoHaAbrigo() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Teste";

        // Cria um ByteArrayOutputStream que irá capturar os dados que seriam enviados ao console em um array de bytes.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Cria um PrintStream que irá escrever os dados no ByteArrayOutputStream,
        // permitindo capturar a saída que seria enviada para o console.
        PrintStream printStream = new PrintStream(baos);

        // Redireciona a saída padrão do console para o PrintStream,
// fazendo com que a saída gerada seja capturada no ByteArrayOutputStream.
        System.setOut(printStream);

        // Configurando o mock de response.body() para retornar um JSON representando o objeto abrigo
        // quando for chamado. O toString() logo que o toString foi sobre escrito para representar este Json
        when(response.body()).thenReturn("[{"+abrigo.toString()+"}]");

        // Configurando o mock do client para retornar o mock de response quando o método dispararRequisicaoGet()
        // for chamado com qualquer string como argumento.
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

    @Test
    public void deveVerificarQuandoNaoHaAbrigo() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expected = "Não há abrigos cadastrados";

        // Cria um ByteArrayOutputStream que irá capturar os dados que seriam enviados ao console em um array de bytes.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Cria um PrintStream que irá escrever os dados no ByteArrayOutputStream,
        // permitindo capturar a saída que seria enviada para o console.
        PrintStream printStream = new PrintStream(baos);

        // Redireciona a saída padrão do console para o PrintStream,
    // fazendo com que a saída gerada seja capturada no ByteArrayOutputStream.
        System.setOut(printStream);

        // Configurando o mock de response.body() para retornar um JSON representando o objeto abrigo
        // quando for chamado. O toString() logo que o toString foi sobre escrito para representar este Json
        when(response.body()).thenReturn("[]");

        // Configurando o mock do client para retornar o mock de response quando o método dispararRequisicaoGet()
        // for chamado com qualquer string como argumento.
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[0];

        Assertions.assertEquals(expected, actual);
    }



}
