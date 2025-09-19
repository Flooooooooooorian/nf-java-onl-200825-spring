package de.neuefische.java.nfjavaonl200825spring.rickmorty;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyApiService {

    private final RestClient restClient;

    public RickAndMortyApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<RickAndMortyCharacter> loadAllCharacters() {
        RickAndMortyApiResponse body = restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickAndMortyApiResponse.class);

        return body.results();
    }
}
