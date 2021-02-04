package org.karalab.cigarinventoryservice.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karalab.cigarinventoryservice.domain.CigarInventory;
import org.karalab.cigarinventoryservice.repositories.CigarInventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class CigarInventoryBootStrap implements CommandLineRunner {

    public static final String CIGAR_1_EAN = "0631234200036";
    public static final String CIGAR_2_EAN = "0631234300019";
    public static final String CIGAR_3_EAN = "0083783375213";
    public static final UUID CIGAR_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID CIGAR_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID CIGAR_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final CigarInventoryRepository cigarInventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if(cigarInventoryRepository.count() == 0){
            loadInitialInv();
        }
    }

    private void loadInitialInv() {
        cigarInventoryRepository.save(CigarInventory
                .builder()
                .cigarId(CIGAR_1_UUID)
                .ean(CIGAR_1_EAN)
                .quantityOnHand(50)
                .build());

        cigarInventoryRepository.save(CigarInventory
                .builder()
                .cigarId(CIGAR_2_UUID)
                .ean(CIGAR_2_EAN)
                .quantityOnHand(50)
                .build());

        cigarInventoryRepository.save(CigarInventory
                .builder()
                .cigarId(CIGAR_3_UUID)
                .ean(CIGAR_3_EAN)
                .quantityOnHand(50)
                .build());

        log.debug("Loaded Inventory. Record count: " + cigarInventoryRepository.count());
    }
}
