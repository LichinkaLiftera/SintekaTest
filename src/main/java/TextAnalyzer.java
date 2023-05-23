import java.util.ArrayList;
import java.util.List;
public class TextAnalyzer {
    private List<String> text;


    public TextAnalyzer(List<String> text){
        this.text = text;
    }
    
    public List<String> Comparison(){

        List<String> result = new ArrayList<>();

        List<List<String>> mainList = new ArrayList<>();
        for (String str1 : text.subList(1, Integer.parseInt(text.get(0)) + 1)) {
            mainList.add(new ArrayList<>(List.of(str1.split(" "))));
        }

        List<List<String>> subList = new ArrayList<>();
        for (String str2 : text.subList(Integer.parseInt(text.get(0)) + 2, text.size())) {
            subList.add(new ArrayList<>(List.of(str2.split(" "))));
        }

        for (int i = 0; i < mainList.size(); i++) {
            result.add(i, mainList.get(i) + ":?");
            for (List<String> list2 : subList) {
                int max = 0;
                List<String> temp2 = new ArrayList<>(list2);
                temp2.retainAll(mainList.get(i));
                if (temp2.size() > max) {
                    result.set(i, mainList.get(i) + ":" + list2);
                    max = temp2.size();
                }
            }
        }
        return result;
    }
}
