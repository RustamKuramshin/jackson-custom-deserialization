package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "mapping-config")
public class MappingConfigModel {
    @JacksonXmlProperty(localName = "dto-list")
    private List<DtoItem> dtoItems;

    public List<DtoItem> getDtoItems() {
        return dtoItems;
    }

    public void setDtoItems(List<DtoItem> dtoItems) {
        this.dtoItems = dtoItems;
    }
}
