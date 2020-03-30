package com.webbdealer.catalog.services;

import com.webbdealer.catalog.entities.Make;
import com.webbdealer.catalog.entities.YearModelTrim;
import com.webbdealer.catalog.repositories.MakeRepository;
import com.webbdealer.catalog.repositories.YearModelTrimRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@DataJpaTest
@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
public class CatalogServiceImplIntegrationTest {

//    @Mock
//    private YearModelTrimRepository ymtRepository;
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Autowired
    private YearModelTrimRepository yearModelTrimRepository;

    private CatalogService catalogService;

    @Before
    public void initTest() {
        catalogService = new CatalogServiceImpl(yearModelTrimRepository);
    }

    @Test
    public void createYearModeTrim_Test() {

//        when(yearModelTrimRepository.save(any(YearModelTrim.class))).then(returnsFirstArg());



        YearModelTrim savedYmt = catalogService.createYearMakeModelTrim("2008", "Mazda", "Mazda6", "i Sport");

        assertThat(savedYmt).isNotNull();
    }
}
