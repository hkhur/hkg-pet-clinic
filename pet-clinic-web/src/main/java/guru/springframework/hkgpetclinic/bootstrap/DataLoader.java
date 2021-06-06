package guru.springframework.hkgpetclinic.bootstrap;

import guru.springframework.hkgpetclinic.model.Owner;
import guru.springframework.hkgpetclinic.model.Pet;
import guru.springframework.hkgpetclinic.model.PetType;
import guru.springframework.hkgpetclinic.model.Vet;
import guru.springframework.hkgpetclinic.services.OwnerService;
import guru.springframework.hkgpetclinic.services.PetTypeService;
import guru.springframework.hkgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);

        PetType python = new PetType();
        dog.setName("python");

        PetType savedPythonPetType = petTypeService.save(python);
        
        Owner owner1 = new Owner();
        owner1.setFirstName("Steve");
        owner1.setLastName("Jerman");
        owner1.setAddress("Sunnyvale USA");
        owner1.setCity("Boise");
        owner1.setTelephone("+9112345677");

        Pet stevesPet = new Pet();
        stevesPet.setPetType(savedPythonPetType);
        stevesPet.setOwner(owner1);
        stevesPet.setBirthDate(LocalDate.now());
        stevesPet.setName("Titanoboa");
        owner1.getPets().add(stevesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gururaj R");
        owner2.setLastName("Setty");
        owner2.setAddress("Bellandur");
        owner2.setCity("Bangalore");
        owner2.setTelephone("+9198845567");

        Pet gururajsPet = new Pet();
        gururajsPet.setPetType(savedDogPetType);
        gururajsPet.setOwner(owner2);
        gururajsPet.setBirthDate(LocalDate.now());
        gururajsPet.setName("Charlie");
        owner2.getPets().add(gururajsPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Neetu");
        owner3.setLastName("Goyal");
        owner3.setAddress("Whitefield ITPL Road");
        owner3.setCity("Bangalore");
        owner3.setTelephone("+91993459989");

        Pet neetusPet = new Pet();
        neetusPet.setPetType(savedCatPetType);
        neetusPet.setOwner(owner3);
        neetusPet.setBirthDate(LocalDate.now());
        neetusPet.setName("Neety");
        owner3.getPets().add(neetusPet);

        ownerService.save(owner3);

        System.out.println("OWNERS DATA LOADED***********");
        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Thompson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tim");
        vet2.setLastName("Buchalka");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("James");
        vet3.setLastName("Gosling");

        vetService.save(vet3);

        System.out.println("VETS DATA LOADED***************");

    }
}
