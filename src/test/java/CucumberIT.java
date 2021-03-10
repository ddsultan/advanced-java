//package cuke.jacoco.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"summary", "html:build/target/cucumber-report.html"}, features = "src/test/resources", snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CucumberIT  {
}