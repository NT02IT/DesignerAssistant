package Handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
public class MarkdownFileHandler {
    private Objects.MarkdownFile markdownFile;

    public void print(){
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(markdownFile.getFilePath()))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
