package de.neuefische.java.nfjavaonl200825spring.characters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AsterixService {

    private final AsterixRepository repo;
    private final IdService idService;

    public List<AsterixCharacter> findAllCharacters() {
        return repo.findAll();
    }

    public AsterixCharacter saveNewAsterixCharacter(AsterixCharacterCreationDto asterixCharacter) {
        AsterixCharacter newCharacter = new AsterixCharacter(
                idService.generateRandomId(),
                asterixCharacter.name(),
                asterixCharacter.age(),
                asterixCharacter.profession());
        return repo.save(newCharacter);
    }

    public AsterixCharacter updateCharacterById(String id, AsterixCharacterCreationDto asterixCharacter) {
        if (repo.existsById(id)) {
            AsterixCharacter newCharacter = new AsterixCharacter(
                    id,
                    asterixCharacter.name(),
                    asterixCharacter.age(),
                    asterixCharacter.profession());
            return repo.save(newCharacter);
        } else {
            throw new NoSuchElementException("No Character found with Id:" + id);
        }
    }

    public void deleteCharById(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new NoSuchElementException("No Character found with Id:" + id);
        }

    }

    public AsterixCharacter findCharacterById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Character with id: " + id + " not found!"));
    }
}
