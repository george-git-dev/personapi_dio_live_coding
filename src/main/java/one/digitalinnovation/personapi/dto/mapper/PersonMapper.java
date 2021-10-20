package one.digitalinnovation.PersonAPI.dto.mapper;

import one.digitalinnovation.PersonAPI.dto.request.PersonDTO;
import one.digitalinnovation.PersonAPI.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
