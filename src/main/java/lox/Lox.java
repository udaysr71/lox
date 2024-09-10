package lox;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Scanner;
import java.util.stream.Stream;

public class Lox {
    static boolean hadError = false;
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runPrompt() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            System.out.print(">");
            String line = bufferedReader.readLine();
            if (line == null) break;
            run(line);
            hadError = false;
        }
    }

    private static void runFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        run(new String(bytes, Charset.defaultCharset()));
        if(hadError){
            //Here we are following the BSD error codes : https://www.freebsd.org/cgi/man.cgi?query=sysexits&apropos=0&sektion=0&manpath=FreeBSD+4.3-RELEASE&format=html
            /*
               EX_DATAERR (65)	   The input data was incorrect in some way.  This
			   should only be used for user's data and not system
			   files.
             */
            System.exit(65);
        }

    }

    private static void run(String contents) {
        //Let's print the tokens in this chapter

        Scanner scanner = new Scanner(contents);
        Stream<String> tokens = scanner.tokens();
        tokens.forEach(System.out::println);
    }

    //not used for now, to be used in further steps
    static void error(int line, String message) {
        report(line, "", message);
    }
    private static void report(int line, String where,
                               String message) {
        System.err.println(
                "[line " + line + "] Error" + where + ": " + message);
        hadError = true;
    }
}
