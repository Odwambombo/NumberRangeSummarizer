import org.junit.Test;

import java.util.Collection;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class NumberRangeSummarizerTest {
    @Test
    public void testForDuplicatesInCollectionMethod() {
        String InputValues = "1,1,2,2,3,6,7,8,8,9";
        NumberRangeSummarizerLauncher numbers = new NumberRangeSummarizerLauncher();

        Collection<Integer> ExpectedResults = new TreeSet<Integer>();
        ExpectedResults.add(1);
        ExpectedResults.add(2);
        ExpectedResults.add(3);
        ExpectedResults.add(6);
        ExpectedResults.add(7);
        ExpectedResults.add(8);
        ExpectedResults.add(9);

        assertEquals(numbers.collect(InputValues), ExpectedResults);
    }
    @org.junit.Test
    public void testForSortingInCollectionMethod() {
        String InputValues = "9,2,5,4,1,6,7,10,3";
        NumberRangeSummarizerLauncher numbers = new NumberRangeSummarizerLauncher();

        Collection<Integer> ExpectedResults = new TreeSet<Integer>();
        ExpectedResults.add(1);
        ExpectedResults.add(2);
        ExpectedResults.add(3);
        ExpectedResults.add(4);
        ExpectedResults.add(5);
        ExpectedResults.add(6);
        ExpectedResults.add(7);
        ExpectedResults.add(9);
        ExpectedResults.add(10);

        assertEquals(numbers.collect(InputValues), ExpectedResults);
    }
    @org.junit.Test(expected = NumberFormatException.class)
    public void testForWrongCharacterValueInsertion() {
        String InputValues = "1,2,c,v,r,5,#,";
        NumberRangeSummarizerLauncher numbers = new NumberRangeSummarizerLauncher();

        Collection<Integer> collect = numbers.collect(InputValues);
        assertEquals(collect, NumberFormatException.class);
    }
    @org.junit.Test(expected = NumberFormatException.class)
    public void testForSpaceInBetweenValuesInsertion() {
        String InputValues = "1,2,3,4,6, 5";
        NumberRangeSummarizerLauncher numbers = new NumberRangeSummarizerLauncher();
        Collection<Integer> collect = numbers.collect(InputValues);

        assertEquals(collect, NumberFormatException.class);
    }
    @org.junit.Test
    public void testIfSummarizeCollectionValuesAreGrouped() {
        String InputValues = "1,2,4,5,6,18,19,30,31,40";
        String expectedResult = "1-2, 4-6, 18-19, 30-31, 40";
        NumberRangeSummarizerLauncher numbers = new NumberRangeSummarizerLauncher();

        assertEquals(numbers.summarizeCollection(numbers.collect(InputValues)), expectedResult);
    }
    @org.junit.Test
    public void testIfUserInsertCommaAtTheEnd() {
        String InputValues = "1,2,3,5,6,7,8,";
        String expectedResults = "1-3, 5-8";
        NumberRangeSummarizerLauncher numbers = new NumberRangeSummarizerLauncher();

        String value = numbers.summarizeCollection(numbers.collect(InputValues));
        assertEquals(value, expectedResults);
    }
}
