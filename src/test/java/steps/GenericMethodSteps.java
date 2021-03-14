package steps;

import generics.GenericMethod;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class GenericMethodSteps {

    Character[] chars = {};
    Integer[] integers = {};
    Boolean[] booleans = {};

    List<String> charsList;
    List<String> integersList;
    List<String> booleansList;

    @Given("I have a method that converts Array of objects to a List of objects")
    public void iHaveAMethodThatConvertsArrayOfObjectsToAListOfObjects() {
        // to overcome compile time error and check whether the method is there
        assertThrows(NullPointerException.class, () -> {
            GenericMethod.arrayToList(null, null);
        });
    }

    @Given("I have following arrays to convert to")
    public void iHaveFollowingArraysToConvertTo(Map<String, String> arrays) {
        this.chars =  Arrays.stream((arrays.get("chars")).split(", "))
                                   .map(character -> character.charAt(0))
                                   .toArray(Character[]::new);
        this.integers =  Arrays.stream((arrays.get("integers")).split(", "))
                                   .map(number -> Integer.parseInt(number))
                                   .toArray(Integer[]::new);
        this.booleans = Arrays.stream((arrays.get("booleans")).split(", "))
                                   .map(bool -> Boolean.valueOf(bool))
                                   .toArray(Boolean[]::new);
        
        System.out.println(chars[1]);
    }

    @When("I convert each of the arrays to a list other than the array type")
    public void iConvertEachOfTheArraysToAListOtherThanTheArrayType() {
        this.charsList = GenericMethod.arrayToList(this.chars, new ArrayList<>());
        this.integersList = GenericMethod.arrayToList(this.integers, new ArrayList<>());
        this.booleansList = GenericMethod.arrayToList(this.booleans, new ArrayList<>());

        assertEquals(booleansList.size(), this.chars.length);
    }

   
    // context: runtime - other than ClassCastException
    @Then("I should not get any error \\(nor compile-time neither runtime)") 
    public void iShouldNotGetAnyErrorNorCompileTimeNeitherRuntime() {
       assertTrue(this.booleansList.size() > 0);
    }

    @Then("accessing an element from the list will throw a class cast exception")
    public void accessingAnElementFromTheListWillGiveMeAClassCastException() {
        assertThrows(ClassCastException.class, () -> {
            String charOfTypeString = this.charsList.get(0);
        });
    }
}