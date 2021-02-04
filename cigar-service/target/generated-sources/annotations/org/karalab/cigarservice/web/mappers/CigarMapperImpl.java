package org.karalab.cigarservice.web.mappers;

import javax.annotation.processing.Generated;
import org.karalab.cigarservice.domain.Cigar;
import org.karalab.cigarservice.web.model.CigarDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-04T13:53:57+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class CigarMapperImpl implements CigarMapper {

    @Override
    public CigarDto cigarToCigarDto(Cigar cigar) {
        if ( cigar == null ) {
            return null;
        }

        CigarDto cigarDto = new CigarDto();

        return cigarDto;
    }

    @Override
    public Cigar cigarDtoToCigar(CigarDto cigarDto) {
        if ( cigarDto == null ) {
            return null;
        }

        Cigar cigar = new Cigar();

        return cigar;
    }
}
