package com.webbdealer.catalog.repositories;

import com.webbdealer.catalog.entities.Make;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest // Configures H2 in-mem db
public class MakeRepositoryIntegrationTest {

//    @Mock
//    private MakeRepository makeRepository;
//

    @Autowired
    private MakeRepository makeRepository;


//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Before
//    public void initTest() {
//
//    }

    @Test
    public void whenFindByName_thenReturnMake() {

        Make mazda = new Make("Mazda");
        makeRepository.save(mazda);

        Optional<Make> optionalMake = makeRepository.findByName(mazda.getName());


        if(optionalMake.isPresent()) {
            Make make = optionalMake.get();
            assertThat(make.getName()).isEqualTo("Mazda");
        }



    }
}
