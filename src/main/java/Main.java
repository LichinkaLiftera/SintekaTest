import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> text;

        try(Stream<String> stream = Files.lines(Path.of(args[0]))){
            text = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TextAnalyzer textAnalyzer = new TextAnalyzer(text);

        try(FileWriter fileWriter = new FileWriter("Output.txt")) {
            for(String str : textAnalyzer.Comparison()){
                fileWriter.write(str.replaceAll("[,\\[\\]]", "") + "\r\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
