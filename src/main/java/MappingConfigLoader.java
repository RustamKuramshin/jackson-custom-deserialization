import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.MappingConfigModel;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;


public class MappingConfigLoader {

    private static final XmlMapper mapper;

    static {
        mapper = new XmlMapper();
    }

    public String loadConfigAsString(String configPath) {
        String result = null;
        ClassLoader cl = getClass().getClassLoader();
        try (InputStream inputStream = cl.getResourceAsStream(configPath)) {
            assert inputStream != null;
            result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public MappingConfigModel configUnmarshal(String configPath) throws JsonProcessingException {
        return mapper.readValue(loadConfigAsString(configPath), MappingConfigModel.class);
    }

    public MappingConfig convertToConfigMap(MappingConfigModel mc) {

        MappingConfig mappingConfig = new MappingConfig();

        mc.getDtoItems().forEach((dtoItem) -> {
            HashMap<String, HashSet<String>> contexts = new HashMap<>();
            dtoItem.getContexts().forEach((context) -> {
                HashSet<String> fields = new HashSet<>(context.getFields());
                contexts.put(String.format("%s:%s", context.getOperationName(), context.getOperationType()), fields);
            });

            mappingConfig.put(dtoItem.getFullClassName(), contexts);
        });

        return mappingConfig;
    }
}
