package software.aoc.day02.a;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        InstructionReader reader = new FileInstructionReader("src/main/resources/ranges");
        Solver solver = new Solver(reader);
        long result = solver.solve();

        System.out.println("Suma total de IDs inválidos (Parte 1): " + result);
    }
}
