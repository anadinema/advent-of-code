package dev.anadinema.projects.advent.code.service.impl

import dev.anadinema.projects.advent.code.model.PuzzleResponse
import dev.anadinema.projects.advent.code.service.SolutionService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
@Qualifier("solutionService2023Impl")
class SolutionService2023Impl: SolutionService {

    override fun getPuzzleOneOutput(requestBody: List<String>, onlyPartOne: Boolean): ResponseEntity<PuzzleResponse> {

        requestBody.stream()
            .filter(str -> {})
            .toString();
        TODO("Not yet implemented")
    }

}