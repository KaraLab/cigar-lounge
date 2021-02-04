package org.karalab.cigarinventoryservice.web.mappers;

import org.karalab.cigarinventoryservice.domain.CigarInventory;
import org.karalab.cigarinventoryservice.web.model.CigarInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CigarInventoryMapper {

    CigarInventory cigarInventoryDtoToCigarInventory(CigarInventoryDto cigarInventoryDto);

    CigarInventoryDto cigarInventoryToCigarInventoryDto(CigarInventory cigarInventory);
}
