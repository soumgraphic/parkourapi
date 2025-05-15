package com.globalopencampus.parkourapi.controller;

import com.globalopencampus.parkourapi.dto.model.ParkourSpotSuggestionDto;
import com.globalopencampus.parkourapi.service.MistralAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AI services", description = "Related to Mistral AI suggestions and chat")
@RestController
@RequestMapping("/ai")
public class AiController {
    MistralAiService mistralAiService;

    public AiController(MistralAiService mistralAiService){
        this.mistralAiService = mistralAiService;
    }

    @Operation(
            summary = "To get parkour spot suggestions from AI",
            description = "To get parkour spot suggestions from AI matched the criteria like country, city..."

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The AI suggests new parkour spots",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request body") })
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
    @PostMapping("/spot-suggestions")
    String getParkourSpotSuggestionFromAI(@RequestBody ParkourSpotSuggestionDto spotSuggestionDto){
        StringBuilder prompt = new StringBuilder();
        prompt
                .append("I need parkour exercices suggestions following this criteria: ")
                .append("Country: " + spotSuggestionDto.country())
                .append("City: " + spotSuggestionDto.city())
                .append(spotSuggestionDto.isIndoor() ? " and Indoor" : "and Outdoor");

        return mistralAiService.call(prompt.toString());
    }

    @Operation(
            summary = "To talk with AI via Chat",
            description = "This service provide Mistral chat features"

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The AI reply user prompt",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid prompt") })
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
    @PostMapping("/chat")
    String chat(@RequestBody String prompt){
        return mistralAiService.call(prompt);
    }


}
