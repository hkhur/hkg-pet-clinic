package guru.springframework.hkgpetclinic.bootstrap;

import guru.springframework.hkgpetclinic.model.*;
import guru.springframework.hkgpetclinic.services.OwnerService;
import guru.springframework.hkgpetclinic.services.PetTypeService;
import guru.springframework.hkgpetclinic.services.SpecialtyService;
import guru.springframework.hkgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        System.out.println("*****Specialty radiology Loaded");

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        System.out.println("*****Specialty surgery Loaded");

        Specialty dentistry = new Specialty();
        surgery.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("*****Specialty dentistry Loaded");

        PetType dog = new PetType();
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println("******PetType dog Loaded ");

        PetType cat = new PetType();
        dog.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("******PetType cat Loaded ");

        PetType python = new PetType();
        dog.setName("python");

        PetType savedPythonPetType = petTypeService.save(python);

        System.out.println("******PetType python Loaded ");

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
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tim");
        vet2.setLastName("Buchalka");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("James");
        vet3.setLastName("Gosling");
        vet3.getSpecialities().add(savedRadiology);

        vetService.save(vet3);

        System.out.println("VETS DATA LOADED***************");
    }
}
