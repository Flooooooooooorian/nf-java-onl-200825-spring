package de.neuefische.java.nfjavaonl200825spring.characters;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService service;

    @GetMapping("/characters")
    public List<AsterixCharacter> getAllCharacter(){
        return service.findAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public AsterixCharacter getCharacterById(@PathVariable String id){
        return service.findCharacterById(id);
    }

    @PostMapping
    public AsterixCharacter saveNewAsterixCharacter(@RequestBody AsterixCharacterCreationDto asterixCharacter){
        return service.saveNewAsterixCharacter(asterixCharacter);
    }

    @PutMapping("/{id}")
    public AsterixCharacter updateAsterixCharacter (@PathVariable String id,
                                                    @RequestBody AsterixCharacterCreationDto asterixCharacter){
        return service.updateCharacterById(id, asterixCharacter);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id){
        service.deleteCharById(id);
    }
}
