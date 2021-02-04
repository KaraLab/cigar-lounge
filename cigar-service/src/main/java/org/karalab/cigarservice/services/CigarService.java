package org.karalab.cigarservice.services;

import org.karalab.cigarservice.web.model.CigarDto;

import java.util.UUID;

public interface CigarService {

    CigarDto getById(UUID cigarId);

    CigarDto saveNewCigar(CigarDto cigarDto);

    CigarDto updateCigar(UUID cigarId, CigarDto cigarDto);
}
