package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class DtoItem {
    @JacksonXmlProperty(localName = "full-class-name", isAttribute = true)
    private String fullClassName;

    @JacksonXmlProperty(localName = "contexts")
    private List<Context> contexts;

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }
}
