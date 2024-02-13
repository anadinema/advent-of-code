package dev.anadinema.projects.advent.code.service

import dev.anadinema.projects.advent.code.model.PuzzleResponse
import org.springframework.http.ResponseEntity

interface SolutionService {

    fun getPuzzleOneOutput(requestBody: List<String>, onlyPartOne: Boolean): ResponseEntity<PuzzleResponse>

}