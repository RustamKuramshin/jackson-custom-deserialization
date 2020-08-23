import com.fasterxml.jackson.core.JsonProcessingException;
import model.MappingConfigModel;
import org.junit.Test;

public class MappingConfigModelLoaderTest {
    @Test
    public void configUnmarshal() throws JsonProcessingException {

        MappingConfigLoader mappingConfigLoader = new MappingConfigLoader();

        MappingConfigModel res = mappingConfigLoader.configUnmarshal("config/dto-mapping-config.xml");

        MappingConfig mc = mappingConfigLoader.convertToConfigMap(res);

        System.out.println(mc);
    }
}