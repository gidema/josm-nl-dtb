package org.openstreetmap.josm.plugins.nl_dtb.io;

import java.util.Objects;

public class DtbFeatureTags {
    private final String thema;
    private final String themaB;

    public DtbFeatureTags(String thema, String themaB) {
        super();
        this.thema = thema;
        this.themaB = themaB;
    }

    public String getThema() {
        return thema;
    }

    public String getThemaB() {
        return themaB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(thema, themaB);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DtbFeatureTags other = (DtbFeatureTags) obj;
        return Objects.equals(thema, other.thema) && Objects.equals(themaB, other.themaB);
    }
}
