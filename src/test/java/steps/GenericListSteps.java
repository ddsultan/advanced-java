package steps;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericListSteps {
    private ArrayList elements = new ArrayList();
    private Integer newElement;

    @Given("there are following elements to store")
    public void thereAreFollowingElementsToStore(List elements) {
        assertTrue(elements.size() > 0);

        this.elements.addAll(elements);
    }

    @When("an element of type integer is added: {int}")
    public void anElementOfTypeIntegerIsAdded(Integer number) {
        this.newElement = number;
        this.elements.add(number);
    }

    @Then("the list should contain the new element")
    public void theListShouldContainTheNewElement() {
        assertTrue(this.elements.contains(this.newElement));
    }
}
