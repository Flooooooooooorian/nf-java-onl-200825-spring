package de.neuefische.java.nfjavaonl200825spring.characters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {

    AsterixRepository asterixRepository = mock(AsterixRepository.class);
    IdService idService = mock(IdService.class);

    AsterixService asterixService = new AsterixService(asterixRepository, idService);

    @Test
    void findAllCharacters() {
        //GIVEN
        List<AsterixCharacter> expected = List.of(new AsterixCharacter("1", "test-name", 5, "test-profession"));
        when(asterixRepository.findAll()).thenReturn(expected);

        //WHEN
        List<AsterixCharacter> actual = asterixService.findAllCharacters();

        //THEN
        System.out.println(actual);
        verify(asterixRepository).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void deleteCharacter() {
        //GIVEN
        String id = "1";

        doNothing().when(asterixRepository).deleteById(id);
        when(asterixRepository.existsById(id)).thenReturn(true);

        //WHEN
        asterixService.deleteCharById(id);

        //THEN
        verify(asterixRepository).deleteById(id);
    }
}
