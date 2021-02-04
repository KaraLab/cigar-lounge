package org.karalab.cigarinventoryservice.repositories;

import org.karalab.cigarinventoryservice.domain.CigarInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CigarInventoryRepository extends JpaRepository<CigarInventory, UUID> {

    List<CigarInventory> findAllByCigarId(UUID cigarId);
}
