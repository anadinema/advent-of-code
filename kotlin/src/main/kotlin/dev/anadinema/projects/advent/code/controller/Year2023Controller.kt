package dev.anadinema.projects.advent.code.controller

import dev.anadinema.projects.advent.code.api.Year2023Api
import dev.anadinema.projects.advent.code.model.PuzzleResponse
import dev.anadinema.projects.advent.code.service.SolutionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class Year2023Controller(@Autowired @Qualifier("solutionService2023Impl") val service: SolutionService): Year2023Api {

    override fun getPuzzleSolution(requestBody: List<String>, onlyPartOne: Boolean): ResponseEntity<PuzzleResponse> {
        return service.getPuzzleOneOutput(requestBody, onlyPartOne)
    }

}