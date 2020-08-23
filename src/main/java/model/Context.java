package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Context {
    @JacksonXmlProperty(localName = "operation-name", isAttribute = true)
    private String operationName;

    @JacksonXmlProperty(localName = "operation-type", isAttribute = true)
    private String operationType;

    @JacksonXmlProperty(localName = "fields-include")
    private List<String> fields;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }
}
