package de.neuefische.java.nfjavaonl200825spring.characters;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsterixRepository extends MongoRepository<AsterixCharacter, String> {
}
