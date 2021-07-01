package guru.springframework.hkgpetclinic.services.map;

import guru.springframework.hkgpetclinic.model.Pet;
import guru.springframework.hkgpetclinic.services.PetService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
     super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
     super.delete(object );
    }
}
