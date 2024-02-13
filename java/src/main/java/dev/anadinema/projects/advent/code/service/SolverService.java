package dev.anadinema.projects.advent.code.service;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface SolverService {
    ResponseEntity<dev.anadinema.projects.advent.code.model.PuzzleResponse> getPuzzleOneResult(List<String> puzzleInput, boolean onlyPartOne);
}
