import com.google.gson.JsonObject;
import com.tasha.lab5.container.ContainerImpl;
import com.tasha.lab5.data.Element;
import com.tasha.lab5.util.FileUtils;
import com.tasha.lab5.util.JSONUtils;
import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class ContainerImplTest {

    @Test
    public void checkImportObjectsFromFile() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input1_test.json").getFile());

        ContainerImpl container = new ContainerImpl();
        container.importData(file.getAbsolutePath());
        String firstLine = FileUtils.readLineFromFile(file.getAbsolutePath());

        assertEquals(
                "check import first object from file",
                firstLine,
                container.getDeque().getFirst().getValue().toString()
        );
    }

    @Test
    public void checkSaveObjectsToFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File fileInput = new File(classLoader.getResource("input1_test.json").getFile());
        File fileOutput = new File(classLoader.getResource("output1_test.json").getFile());

        ContainerImpl container = new ContainerImpl();
        container.importData(fileInput.getAbsolutePath());
        container.saveData(fileOutput.getAbsolutePath());

        assertEquals(
                "check save all objects to file",
                FileUtils.readAllLines(fileInput.getAbsolutePath()),
                FileUtils.readAllLines(fileOutput.getAbsolutePath())
        );
    }

    @Test
    public void checkDeleteFirstObject() {
        ClassLoader classLoader = getClass().getClassLoader();
        File fileInput = new File(classLoader.getResource("input1_test.json").getFile());

        ContainerImpl container = new ContainerImpl();
        container.importData(fileInput.getAbsolutePath());
        container.removeFirst();
        container.removeFirst();
        container.removeFirst();

        assertEquals(
                "check delete first object from container",
                0, container.getDeque().size()
        );
    }

    @Test
    public void checkDeleteGreaterThanObject() {
        ClassLoader classLoader = getClass().getClassLoader();
        File fileInput = new File(classLoader.getResource("input1_test.json").getFile());
        String firstLine = FileUtils.readLineFromFile(fileInput.getAbsolutePath());
        JsonObject jo = JSONUtils.createJSONFromString(firstLine);
        Element element = new Element(jo);

        ContainerImpl container = new ContainerImpl();
        container.importData(fileInput.getAbsolutePath());
        container.removeGreater(element);

        assertEquals(
                "check delete greater than object",
                firstLine, container.getDeque().getLast().getValue().toString()
        );
    }
}
