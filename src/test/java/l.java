import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class l {
    @Test
    public void e() {
        Path path = Paths.get(".github", "workflows");
        assertTrue(Files.isDirectory(path));
    }
}
