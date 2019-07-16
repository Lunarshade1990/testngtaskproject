import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTestNG {

    String index;
    String value;
    private TestNG runner;

    public void initializeXml(String index, String value) {

        XmlSuite suite = new XmlSuite();
        XmlTest firstTest = new XmlTest(suite, 0);
        XmlClass changeMethodTestXmlClass = new XmlClass("ChangeMethodTestClass", 0);
        XmlClass getMethodXmlTestClass = new XmlClass("GetMethodTestClass", 1);

        Map<String, String> changeClassParameters = new HashMap<>();
        List<XmlSuite> suites = new ArrayList<>();
        List<XmlClass> firstTestClasses = new ArrayList<>();

        List tests = new ArrayList();
        changeClassParameters.put("index", index);
        changeClassParameters.put("value", value);
        changeMethodTestXmlClass.setParameters(changeClassParameters);
        firstTestClasses.add(changeMethodTestXmlClass);
        firstTestClasses.add(getMethodXmlTestClass);

        firstTest.setName("first-test");
        firstTest.setClasses(firstTestClasses);
        tests.add("first-test");

        suite.setName("suite1");
        suite.setVerbose(1);
        suites.add(suite);

        runner = new TestNG();
        runner.setXmlSuites(suites);
    }

    public void runTestByName(String name) {
        List<String> names = new ArrayList<>();
        names.add(name);
        runner.setTestNames(names);
        runner.run();
    }



}
