package com.romanccoder.challenge.bus.loader;

import com.romanccoder.challenge.bus.exception.FileRouteDataException;
import com.romanccoder.challenge.bus.model.RouteData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// For the simplicity I don't add any caching features etc
public class FileRouteDataLoader implements RouteDataLoader {

    private String fileName;

    public FileRouteDataLoader(String fileName) {
        this.fileName = fileName;
    }

    public List<RouteData> load() {

        ArrayList<RouteData> data = new ArrayList<>();

        try(
                InputStream inputStream = new FileInputStream(fileName);
                Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())
        )
        {

            int i = 0;
            int totalRoutes = -1;

            while (fileScanner.hasNextLine()) {

                if (i == 0) {
                    totalRoutes = fileScanner.nextInt();
                    fileScanner.nextLine();
                    data.ensureCapacity(totalRoutes);

                    i++;
                    continue;
                }

                String line = fileScanner.nextLine();
                int[] parts = parseIds(line);

                data.add(new RouteData(parts[0], Arrays.copyOfRange(parts, 1, parts.length)));

                i++;
            }

            if (i != totalRoutes + 1) {
                throw new FileRouteDataException(fileName, "Route data file is broken");
            }
        }
        catch (FileNotFoundException e) {
            throw new FileRouteDataException(fileName, "File doesn't exist", e);
        }
        catch (IOException e) {
            throw new FileRouteDataException(fileName, "Unexpected file error", e);
        }

        return data;
    }

    private int[] parseIds(String routeData) {
        return Arrays.stream(routeData.split("\\s")).mapToInt(Integer::valueOf).toArray();
    }

}
