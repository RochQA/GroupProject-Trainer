package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)

@SuiteClasses( { TrainerServiceTests.class, AccountEntityTests.class } )

public class SuiteTest {

}