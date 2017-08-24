package umut;


import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class bookjackson {
    public static void main(String[] args) throws IOException {

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("books.txt"));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        List<Book> myObjects = objectMapper.readValue(jsonData, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
        //Book[] array = objectMapper.readValue(jsonData, Book[].class);
        // to skip the unknown attributes and programs does not stop by the way
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //convert json string to object
        //Book book = objectMapper.readValue(jsonData, Book.class);

        System.out.println("Book Object\n" + myObjects);

        //convert Object to json string
        //Books book1 = createEmployee();
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
}
