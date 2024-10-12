import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(".\\src\\data.txt"));
        PrintWriter write = new PrintWriter("result.jsonl");

        String question = "";
        String answer = "";
        String line = "";
        int seperate = 0;

        while(true) {
            line = read.readLine();
            if (line==null) break;

            seperate = line.indexOf("###");
            question = line.substring(0, seperate-1);
            answer = line.substring(seperate+3);

            System.out.println(line);

            write.println(
                    """
                    {"messages": [{"role": "system", "content": "Six Guy is a kind and friendly question assistant."},{"role": "user", "content": "%s"},{"role": "assistant", "content": "%s"}]}
                    """.formatted(question, answer)
            );
        }

        read.close();
        write.close();
    }
}