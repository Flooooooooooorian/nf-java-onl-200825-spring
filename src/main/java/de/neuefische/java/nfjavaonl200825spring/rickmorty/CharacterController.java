package de.neuefische.java.nfjavaonl200825spring.rickmorty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rickmorty/characters")
public class CharacterController {

    private final RickAndMortyApiService rickAndMortyApiService;

    public CharacterController(RickAndMortyApiService rickAndMortyApiService) {
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping
    public List<RickAndMortyCharacter> getAllCharacters() {
        return rickAndMortyApiService.loadAllCharacters();
    }
}
