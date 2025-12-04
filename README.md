# Advent of Code 2025 - Day 2: Inventory Management System

This repository contains the solution for Day 2 of Advent of Code 2025. The challenge involves identifying "invalid" product IDs within specific ranges based on repeating digit patterns.

## Problem Description

The elves at the North Pole gift shop have accidentally added invalid product IDs to their database. We are provided with a list of ID ranges (e.g., `11-22`, `95-115`) and need to find the sum of all invalid IDs within these ranges.

### Part 1

An ID is considered **invalid** if it consists of a sequence of digits repeated exactly **twice**.

- Examples: `55` (5 repeated twice), `6464` (64 repeated twice).
- Non-examples: `101` (valid).

### Part 2

The definition of an invalid ID is expanded. An ID is now **invalid** if it consists of a sequence of digits repeated **at least twice**.

- Examples: `12341234` (1234 twice), `123123123` (123 three times), `1111111` (1 seven times).

## Project Structure

The project is a Java application organized using Maven. The solution is split into two packages for each part of the challenge:

- `src/main/java/software/aoc/day02/a`: Contains the solution for Part 1.
  - `Main.java`: Entry point, reads ranges and sums invalid IDs.
  - `Range.java`: Logic to generate numbers in a range and validate them (check if split in half they are equal).
  - `FileInstructionReader.java`: Helper to read the input file.
- `src/main/java/software/aoc/day02/b`: Contains the solution for Part 2.
  - `Main.java`: Entry point for Part 2.
  - `Range.java`: Logic to generate numbers and delegate validation.
  - `PatternValidator.java`: Logic to check if a number is formed by _any_ repeating sequence (not just split in half).

## Requirements

- Java 21 or higher (uses `record` types).
- Maven.

## How to Run

1.  **Input Data**: Ensure your puzzle input is located at `src/main/resources/ranges`. The file should contain comma-separated ranges (e.g., `11-22,95-115`).

2.  **Run Part 1**:
    You can run the `main` method in `software.aoc.day02.a.Main`.

3.  **Run Part 2**:
    You can run the `main` method in `software.aoc.day02.b.Main`.

## Implementation Details

### Part 1 Approach

For each number in the given ranges, we convert it to a string. We check if the string length is even. If so, we split it into two halves and check if they are identical.

### Part 2 Approach

For each number, we check if it can be formed by repeating a subsequence. We iterate through possible sequence lengths (from 1 up to half the number's length). If the total length is divisible by the sequence length, we repeat the subsequence to see if it reconstructs the original number.

## Author

Project created for the Software Engineering course (Ingeniería de Software).
