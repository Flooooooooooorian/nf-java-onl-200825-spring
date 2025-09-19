package de.neuefische.java.nfjavaonl200825spring.rickmorty;

import java.util.List;

public record RickAndMortyApiResponse(
        List<RickAndMortyCharacter> results
) {
}
