package org.karalab.cigarinventoryservice.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karalab.cigarinventoryservice.repositories.CigarInventoryRepository;
import org.karalab.cigarinventoryservice.web.mappers.CigarInventoryMapper;
import org.karalab.cigarinventoryservice.web.model.CigarInventoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CigarInventoryController {

    private final CigarInventoryRepository cigarInventoryRepository;
    private final CigarInventoryMapper cigarInventoryMapper;

    @GetMapping("api/v1/cigar/{cigarId}/inventory")
    List<CigarInventoryDto> listCigarById(@PathVariable UUID cigarId) {
        log.debug("Finding Inventory for cigarId: " + cigarId);

        return cigarInventoryRepository.findAllByCigarId(cigarId)
                .stream()
                .map(cigarInventoryMapper::cigarInventoryToCigarInventoryDto)
                .collect(Collectors.toList());
    }

}
