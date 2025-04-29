package Aegro.testeMiniApp;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteMiniAppApplication implements CommandLineRunner{
	@Autowired
    private Aegro.testeMiniApp.Domain.Service.GeminiService geminiService;

	@Autowired
	private Aegro.testeMiniApp.InterfaceAdapter.Gemini.GeminiAPI geminiAPI;

	public static void main(String[] args) {
		SpringApplication.run(TesteMiniAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
        String imagePath = "src/test/java/Aegro/testeMiniApp/milho.jpeg";

        String response = geminiService.encodeImageToBase64(imagePath);

        System.out.println("Response: " + response);
    }
}
