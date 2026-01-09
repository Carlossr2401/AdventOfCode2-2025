package software.aoc.day02;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        // Ejemplo de uso: Seleccionar Parte A o Parte B
        Solver solverA = SolverFactory.createSolver(SolverFactory.SolverType.PART_A, "src/main/resources/ranges");
        System.out.println("Suma total de IDs inválidos (Parte 1): " + solverA.solve());

        Solver solverB = SolverFactory.createSolver(SolverFactory.SolverType.PART_B, "src/main/resources/ranges");
        System.out.println("Suma total de IDs inválidos (Parte 2): " + solverB.solve());
    }
}
