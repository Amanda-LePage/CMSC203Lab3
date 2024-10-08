package gradebook;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradebookTester {
    private GradeBook g1;
    private GradeBook g2;

    @BeforeEach    public void setUp() {
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);
        g1.addScore(50.0);
        g1.addScore(75.0);
        g2.addScore(85.0);
        g2.addScore(100.0);
    }

    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    // Test methods will go here
    @Test
    public void testAddScore() {
        // Fill up g1 to its capacity
        g1.addScore(10.0);
        g1.addScore(20.0); // g1 now has 4 scores, 1 spot remaining

        assertTrue(g1.addScore(30.0)); // This should return true as it's the 5th score (filling the capacity)

        // Print the actual output for verification (optional)
        System.out.println(g1.toString());

        // Now that g1 is at full capacity, attempt to add another score
        assertFalse(g1.addScore(40.0)); // This should return false as it exceeds the capacity

        // Verify that the string representation is as expected with exactly 5 scores
        assertEquals("50.0 75.0 10.0 20.0 30.0 ", g1.toString());
    }

    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.001); // g1 has scores 50 and 75
        assertEquals(185.0, g2.sum(), 0.001); // g2 has scores 85 and 100
    }
    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.001); // The minimum in g1 should be 50
        assertEquals(85.0, g2.minimum(), 0.001); // The minimum in g2 should be 85
    }
    @Test
    public void testFinalScore() {
        assertEquals(75.0, g1.finalScore(), 0.001); // Drops 50, leaving only 75
        assertEquals(100.0, g2.finalScore(), 0.001); // Drops 85, leaving only 100
    }

}
