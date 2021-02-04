package org.karalab.cigarservice.bootstrap;

import org.karalab.cigarservice.domain.Cigar;
import org.karalab.cigarservice.respositories.CigarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

//@Component
public class CigarLoader implements CommandLineRunner {

    public static final String CIGAR_1_EAN = "0631234200036";
    public static final String CIGAR_2_EAN = "0631234300019";
    public static final String CIGAR_3_EAN = "0083783375213";
    public static final UUID CIGAR_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID CIGAR_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID CIGAR_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final CigarRepository cigarRepository;

    public CigarLoader(CigarRepository cigarRepository) {
        this.cigarRepository = cigarRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(cigarRepository.count() == 0){

            cigarRepository.save(Cigar.builder()
                    .cigarName("Cohiba")
                    .cigarStyle("ROBUSTO")
                    .quantityToRoll(200)
                    .minOnHand(12)
                    .ean(CIGAR_1_EAN)
                    .price(new BigDecimal("12.95"))
                    .build());

            cigarRepository.save(Cigar.builder()
                    .cigarName("Padron Series 1926 No. 6")
                    .cigarStyle("CORONA")
                    .quantityToRoll(200)
                    .minOnHand(12)
                    .ean(CIGAR_2_EAN)
                    .price(new BigDecimal("11.95"))
                    .build());

            cigarRepository.save(Cigar.builder()
                    .cigarName("Balmoral Anejo")
                    .cigarStyle("ROTHSCHILD")
                    .quantityToRoll(200)
                    .minOnHand(12)
                    .ean(CIGAR_3_EAN)
                    .price(new BigDecimal("11.95"))
                    .build());
        }
    }
}
