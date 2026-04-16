package UnitTests;

import edu.coolschool.utilities.PersonInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonInfoUnitTest {

    @Test
    @DisplayName("Verify Builder returns same instance for method chaining in PersonInfo")
    public void testBuilderMethodChainingIdentity() {
        PersonInfo.Builder builder = new PersonInfo.Builder();

        assertSame(builder, builder.setFirstName("John"),
                "Builder should return own instance for chaining");
    }
}