package dev.anadinema.projects.advent.code.service.impl;

import dev.anadinema.projects.advent.code.model.PuzzleData;
import dev.anadinema.projects.advent.code.model.PuzzleResponse;
import dev.anadinema.projects.advent.code.service.SolverService;
import static dev.anadinema.projects.advent.code.util.Commons.integerStringMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("solverService2023")
public class SolverService2023Impl implements SolverService {

    @Override
    public ResponseEntity<PuzzleResponse> getPuzzleOneResult(List<String> puzzleInput, boolean onlyPartOne) {

        int sum = puzzleInput.stream()
                .map(str -> this.removeAlphabets(str, onlyPartOne))
                .filter(str -> !str.isBlank())
                .mapToInt(this::getEndpointCombination)
                .sum();

        return new ResponseEntity<>(new PuzzleResponse()
                .day(1L).data(new PuzzleData().sum((long) sum)), HttpStatus.OK);

    }

    private String removeAlphabets(String inputStr, boolean onlyPartOne) {
        if (!onlyPartOne) {
            inputStr = this.replaceNumericalStrings(inputStr);
        }
        return inputStr.replaceAll("[A-Za-z]", "");
    }

    private String replaceNumericalStrings(String inputStr) {
        for (var entry : integerStringMap.entrySet()) {
            inputStr = inputStr.replaceAll(entry.getKey(), entry.getValue());
        }
        return inputStr;
    }

    private Integer getEndpointCombination(String inputStr) {
        return Integer.parseInt(new StringBuilder().append(inputStr.charAt(0))
                .append(inputStr.charAt(inputStr.length() - 1)).toString());
    }
}
