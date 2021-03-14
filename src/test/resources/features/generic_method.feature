Feature: Generic Method

    To make a method strictly flexible I want create a generic method

    @bad
    Scenario: Generic method with Object type (Lost type safety)

        Given I have a method that converts Array of objects to a List of objects
        And I have following arrays to convert to
            | chars    | h, e, l, l, o                  |
            | integers | 1, 2, 3, 4, 5                  |
            | booleans | true, true, false, false, true |
        When I convert each of the arrays to a list other than the array type
        Then I should not get any error (nor compile-time neither runtime)
        But accessing an element from the list will throw a class cast exception