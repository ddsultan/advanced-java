Feature: Generic List

    In order to store different type of objects I would like to create a list

    Scenario: Untyped generic List
        Given there are following elements to store
            | 1         |
            | Some Name |
            | false     |
        When an element of type integer is added: 2
        Then the list should contain the new element

    Scenario: (Typed) generic List
        Given there are following names to store
            | Adam  |
            | Simon |
            | Ray   |
        When I try to add an element of type integer is added: 2
        Then I should get an compile time error
