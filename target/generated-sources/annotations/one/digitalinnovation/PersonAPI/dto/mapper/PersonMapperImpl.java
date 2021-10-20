package one.digitalinnovation.PersonAPI.dto.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import one.digitalinnovation.PersonAPI.dto.request.PersonDTO;
import one.digitalinnovation.PersonAPI.dto.request.PersonDTO.PersonDTOBuilder;
import one.digitalinnovation.PersonAPI.dto.request.PhoneDTO;
import one.digitalinnovation.PersonAPI.dto.request.PhoneDTO.PhoneDTOBuilder;
import one.digitalinnovation.PersonAPI.entity.Person;
import one.digitalinnovation.PersonAPI.entity.Phone;
import one.digitalinnovation.PersonAPI.entity.Phone.PhoneBuilder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T12:56:42-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Azul Systems, Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        if ( personDTO.getBirthDate() != null ) {
            person.setBirthDate( LocalDate.parse( personDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.setId( personDTO.getId() );
        person.setFirstName( personDTO.getFirstName() );
        person.setLastName( personDTO.getLastName() );
        person.setCpf( personDTO.getCpf() );
        person.setPhones( phoneDTOListToPhoneList( personDTO.getPhones() ) );

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.id( person.getId() );
        personDTO.firstName( person.getFirstName() );
        personDTO.lastName( person.getLastName() );
        personDTO.cpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDTO.phones( phoneListToPhoneDTOList( person.getPhones() ) );

        return personDTO.build();
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.type( phoneDTO.getType() );
        phone.number( phoneDTO.getNumber() );

        return phone.build();
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.type( phone.getType() );
        phoneDTO.number( phone.getNumber() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
