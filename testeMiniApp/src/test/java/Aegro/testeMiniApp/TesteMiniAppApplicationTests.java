package Aegro.testeMiniApp;

import Aegro.testeMiniApp.Domain.Service.GeminiService;
import Aegro.testeMiniApp.InterfaceAdapter.Gemini.GeminiAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class TesteMiniAppApplicationTests {

    @Autowired
    private GeminiService geminiService;

    @MockBean
    private GeminiAPI geminiAPI;



	@BeforeEach
	public void setUp() {
		// Configura o comportamento do mock GeminiAPI
		Mockito.when(geminiAPI.analyzeImage(anyString()))
			   .thenReturn("{ \"result\": \"image analyzed\" }");
	}
	
	@Test
	public void testEncodeImageToBase64() throws IOException {
		// Simula o caminho para uma imagem fictícia
		String imagePath = "src/test/java/Aegro/testeMiniApp/milho.jpeg";
	
		// Certifique-se de que o arquivo existe
		Path path = Path.of(imagePath);
		if (!Files.exists(path)) {
			Files.write(path, "simulated image content".getBytes()); // Cria um arquivo fictício
		}
	
		// Chama o método encodeImageToBase64
		String response = geminiService.encodeImageToBase64(imagePath);
	
		// Verifica se a resposta é a esperada
		System.out.println(response);
		assertEquals("{ \"result\": \"image analyzed\" }", response);
	}
}

