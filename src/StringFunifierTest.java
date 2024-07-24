/*import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringFunifierTest {
    @Test
    void getFunnyStringtest() {

        String inputString = "ccchHJKkklmlmmml";
        List<Integer> startIndexes = Arrays.asList(1, 5, 7, 11, 13);
        List<Integer> endIndexes = Arrays.asList(3, 5, 10, 12, 14);
        List<main.Interface.StringOperations> operations = new ArrayList<>(List.of(
                new main.Operations.LowerCaseOperation(new main.Operations.ReverseOperation(new main.CompressionOperation(new main.NothingOperation()))),
                new main.Operations.UpperCaseOperation(new main.NothingOperation()),
                new main.Operations.SortOperation(new main.Operations.UpperCaseOperation(new main.CompressionOperation(new main.NothingOperation()))),
                new main.CompressionOperation(new main.NothingOperation()),
                new main.Operations.ReverseOperation(new main.Operations.UpperCaseOperation(new main.CompressionOperation(new main.NothingOperation())))));


        String expected = "c(1h2c)H(J)K(112KLM)(l1m1)(2M)l";

        String result = funifier.getFunnyString();

        assertEquals(expected, result);
    }
}
*/