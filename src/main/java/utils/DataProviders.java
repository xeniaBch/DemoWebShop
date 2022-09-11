package utils;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataProviders {

    @DataProvider
    public Iterator<Object[]> RegistrationWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setName(split[0])
                    .setLastname(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}