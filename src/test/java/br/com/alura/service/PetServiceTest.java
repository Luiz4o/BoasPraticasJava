package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import com.sun.jdi.ByteType;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private PetService petService = new PetService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);

    @Test
    public void deveVerificarSeDispararRequisicaoPostSeraChamado() throws IOException, InterruptedException {
        String userInput = String.format("Teste%spets.csv", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
//        System.setIn(bais);


        when(client.dispararRequisicaoPost(anyString(), any())).thenReturn(response);

        System.setProperty("env", "test");

        petService.importarPetsDoAbrigo();

        verify(client.dispararRequisicaoPost(anyString(), anyString()), atLeast(1));
//        verify(client, atLeast(1)).dispararRequisicaoPost(anyString(), any());
    }
}
