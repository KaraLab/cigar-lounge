package org.karalab.cigarservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.karalab.cigarservice.services.CigarService;
import org.karalab.cigarservice.web.model.CigarDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/cigar")
@RestController
public class CigarController {

    private final CigarService cigarService;

    @GetMapping("/{cigarId}")
    public ResponseEntity<CigarDto> getCigarById(@PathVariable("cigarId") UUID cigarId) {
        return new ResponseEntity<>(cigarService.getById(cigarId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewCigar(@RequestBody @Validated CigarDto cigarDto) {
        return new ResponseEntity(cigarService.saveNewCigar(cigarDto), HttpStatus.CREATED);
    }

    @PutMapping("/{cigarId}")
    public ResponseEntity updateCigarById(@PathVariable("cigarId") UUID cigarId, @RequestBody @Validated CigarDto cigarDto) {
        return new ResponseEntity(cigarService.updateCigar(cigarId, cigarDto), HttpStatus.NO_CONTENT);
    }
}
