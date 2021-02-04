package org.karalab.cigarinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CigarInventory extends BaseEntity {

    private UUID cigarId;
    private String ean;
    private int quantityOnHand = 0;

    @Builder
    public CigarInventory(UUID id, long version, Timestamp createdDate, Timestamp lastModifiedDate,
                          UUID cigarId, String ean, int quantityOnHand) {
        super(id, version, createdDate, lastModifiedDate);
        this.cigarId = cigarId;
        this.ean = ean;
        this.quantityOnHand = quantityOnHand;
    }
}
