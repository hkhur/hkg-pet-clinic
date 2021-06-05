package guru.springframework.hkgpetclinic.bootstrap;

import guru.springframework.hkgpetclinic.model.Owner;
import guru.springframework.hkgpetclinic.model.Vet;
import guru.springframework.hkgpetclinic.services.OwnerService;
import guru.springframework.hkgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Steve");
        owner1.setLastName("Jerman");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gururaj R");
        owner2.setLastName("Setty");

        ownerService.save(owner2);

        System.out.println("OWNERS DATA LOADED***********");
        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Thompson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tim");
        vet2.setLastName("Buchalka");

        vetService.save(vet2);

        System.out.println("VETS DATA LOADED***************");

    }
}
