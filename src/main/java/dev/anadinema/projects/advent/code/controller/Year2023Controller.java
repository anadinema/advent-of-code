package dev.anadinema.projects.advent.code.controller;

import dev.anadinema.projects.advent.code.model.PuzzleResponse;
import dev.anadinema.projects.advent.code.service.SolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Year2023Controller implements dev.anadinema.projects.advent.code.controller.Year2023Api {

    private final SolverService solverService;

    @Autowired
    public Year2023Controller(@Qualifier(value = "solverService2023") SolverService solverService2023) {
        this.solverService = solverService2023;
    }

    @Override
    public ResponseEntity<PuzzleResponse> getPuzzleSolution(List<String> puzzleInput, Boolean onlyPartOne) {
        return solverService.getPuzzleOneResult(puzzleInput, onlyPartOne);
    }

}
