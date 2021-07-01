package guru.springframework.hkgpetclinic.services;

import guru.springframework.hkgpetclinic.model.Owner;


import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

}
