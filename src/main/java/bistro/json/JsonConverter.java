package bistro.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public abstract class JsonConverter<T> {
    private final String jsonFileName;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];


    public JsonConverter(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    /*
    Conversion from Object to JSON
     */

    public void convertToJson(final T element) {
        try {
            FileWriter fw = new FileWriter(jsonFileName);
            if (element == null) {
                throw new NullPointerException("ELEMENT IS NULL");
            }
            gson.toJson(element, fw);
            fw.close();
        } catch (FileNotFoundException e) {
            System.err.println("NO SUCH FILE");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /*
    Conversion from JSON to Object
     */

    public Optional<T> convertFromJson() {
        try {
            FileReader fr = new FileReader(jsonFileName);
            return Optional.of(gson.fromJson(fr, type));
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
        return Optional.empty();
    }
}
