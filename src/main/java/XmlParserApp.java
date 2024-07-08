package main.java;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class XmlParserApp {
    public static void main(String[] args) {
        try {
            // Specify the input XML file
            File inputFile = new File("src/resources/input.xml");

            // Create a DocumentBuilderFactory and a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file and get the document
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get a list of all "employee" elements
            NodeList nodeList = doc.getElementsByTagName("employee");

            // Create a FileWriter to write the output file
            FileWriter writer = new FileWriter("src/resources/output.txt");

            // Loop through each "employee" element
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element employee = (Element) nodeList.item(i);

                // Extract the text content of "name", "age", and "role" elements
                String name = employee.getElementsByTagName("name").item(0).getTextContent();
                String age = employee.getElementsByTagName("age").item(0).getTextContent();
                String role = employee.getElementsByTagName("role").item(0).getTextContent();

                // Write the extracted data to the output file
                writer.write("Employee " + (i + 1) + ":\n");
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Role: " + role + "\n\n");
            }

            // Close the FileWriter
            writer.close();

            System.out.println("Output file created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
