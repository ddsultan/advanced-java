package steps;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypedGenericListSteps {
    private ArrayList<String> elements = new ArrayList();
    private Integer newElement;

    @Given("there are following names to store")
    public void thereAreFollowingNamesToStore(List elements) {
        assertTrue(elements.size() > 0);

        this.elements.addAll(elements);
    }

    @When("I try to add an element of type integer is added: {int}")
    public void iTryToAddAnElementOfTypeIntegerIsAdded(Integer number) {
        this.newElement = number;
        this.elements.add("" + number); // NOTE: MUST be converted to String
    }

    @Then("I should get an compile time error")
    public void iShouldGetAnCompileTimeError() {
        this.elements.add("" + this.newElement); // NOTE: Uncomment to get a compile time since Java d
    }
}
