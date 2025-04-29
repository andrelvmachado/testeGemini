package Aegro.testeMiniApp.Domain.Service;

import Aegro.testeMiniApp.InterfaceAdapter.Gemini.GeminiAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    @Autowired
    private GeminiAPI geminiAPI;


    public String processImage(byte[] imageBytes) {
        String base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
        return geminiAPI.analyzeImage(base64Image);
    }
    public String encodeImageToBase64(String imagePath) throws IOException{
        byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
        return processImage(imageBytes);
    }
}
