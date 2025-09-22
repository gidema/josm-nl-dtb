package org.openstreetmap.josm.plugins.nl_dtb.features;

import org.csv4pojoparser.annotation.FieldType;
import org.csv4pojoparser.annotation.Type;

public class FeatureDto {
    @FieldType(dataType = Type.STRING, csvColumnName = "feature")
    private String feature;
    @FieldType(dataType = Type.STRING, csvColumnName = "thema")
    private String thema;
    @FieldType(dataType = Type.STRING, csvColumnName = "themaB")
    private String themaB;
    @FieldType(dataType = Type.STRING, csvColumnName = "key")
    private String key;
    @FieldType(dataType = Type.STRING, csvColumnName = "value")
    private String value;

    public FeatureDto() {
        super();
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getThemaB() {
        return themaB;
    }

    public void setThemaB(String themaB) {
        this.themaB = themaB;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
