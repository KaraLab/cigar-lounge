package org.karalab.cigarservice.web.mappers;

import org.karalab.cigarservice.domain.Cigar;
import org.karalab.cigarservice.web.model.CigarDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CigarMapper {

    CigarDto cigarToCigarDto(Cigar cigar);

    Cigar cigarDtoToCigar(CigarDto cigarDto);
}
