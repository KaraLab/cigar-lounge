package org.karalab.cigarservice.respositories;

import org.karalab.cigarservice.domain.Cigar;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CigarRepository extends PagingAndSortingRepository<Cigar, UUID> {
}
