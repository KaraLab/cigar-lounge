package org.karalab.cigarservice.services;

import lombok.RequiredArgsConstructor;
import org.karalab.cigarservice.domain.Cigar;
import org.karalab.cigarservice.respositories.CigarRepository;
import org.karalab.cigarservice.web.controller.NotFoundException;
import org.karalab.cigarservice.web.mappers.CigarMapper;
import org.karalab.cigarservice.web.model.CigarDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CigarServiceImpl implements CigarService{

    private final CigarRepository cigarRepository;
    private final CigarMapper cigarMapper;

    @Override
    public CigarDto getById(UUID cigarId) {
        return cigarMapper.cigarToCigarDto(
                cigarRepository.findById(cigarId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public CigarDto saveNewCigar(CigarDto cigarDto) {
        return cigarMapper.cigarToCigarDto(cigarRepository.save(cigarMapper.cigarDtoToCigar(cigarDto)));
    }

    @Override
    public CigarDto updateCigar(UUID cigarId, CigarDto cigarDto) {
        Cigar cigar = cigarRepository.findById(cigarId).orElseThrow(NotFoundException::new);

        cigar.setCigarName(cigarDto.getCigarName());
        cigar.setCigarStyle(cigarDto.getCigarStyle().name());
        cigar.setPrice(cigarDto.getPrice());
        cigar.setEan(cigarDto.getEan());

        return cigarMapper.cigarToCigarDto(cigarRepository.save(cigar));
    }
}
