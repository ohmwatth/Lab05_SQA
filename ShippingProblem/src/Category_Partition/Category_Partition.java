package Category_Partition;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.main.ShippingVehicle;

public class Category_Partition {
	
	@ParameterizedTest
    @CsvFileSource(resources = "/Category_Partition.csv", numLinesToSkip = 1)
    public void testCalculate(int large, int medium, int small,
                              int expected1, int expected2, int expected3) {
        
        ShippingVehicle ship = new ShippingVehicle();
        List<Integer> result = ship.calculate(small, medium, large);

        if (result.size() == 1 && result.get(0) == ShippingVehicle.CANNOT_SHIP_ITEM) {
            List<Integer> expected = Arrays.asList(-1);
            assertEquals(expected, result);
        } else {
            List<Integer> expected = Arrays.asList(expected1, expected2, expected3);
            assertEquals(expected, result);
        }
    }

}
