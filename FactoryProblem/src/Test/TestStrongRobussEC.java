package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvFileSources;

import sqa.main.Income;

class TestStrongRobussEC {

	@ParameterizedTest
    @CsvFileSource(resources = "/strongRBEC.csv", numLinesToSkip = 1)
	void testCalculateIncome(int impeller, int motor, int cover, String expected) {
        Income income = new Income();
        double actual = income.calculateIncome(impeller, motor, cover);
        if (expected.equalsIgnoreCase("Invalid")) {
            assertEquals(-1, actual, 0.01);
        } else {
            assertEquals(Double.parseDouble(expected), actual, 0.01);
        }
    }

}
