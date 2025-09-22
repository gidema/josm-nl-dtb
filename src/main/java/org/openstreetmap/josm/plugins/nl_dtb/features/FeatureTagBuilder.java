package org.openstreetmap.josm.plugins.nl_dtb.features;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.openstreetmap.josm.data.osm.OsmPrimitive;
import org.openstreetmap.josm.plugins.nl_dtb.io.DtbFeatureTags;
import org.openstreetmap.josm.tools.Logging;

public class FeatureTagBuilder {
    private final String feature;
    private final Map<DtbFeatureTags, Map<String,String>> tagMaps;
    private final Set<DtbFeatureTags> unknownFeatureTypes = new HashSet<>();
    
    public FeatureTagBuilder(String feature, Map<DtbFeatureTags, Map<String, String>> tagMaps) {
        super();
        this.feature = feature;
        this.tagMaps = tagMaps;
    }

    public void buildTags(OsmPrimitive primitive, DtbFeatureTags featureTags) {
        var tagMap = tagMaps.get(featureTags);
        if (tagMap != null) {
            tagMap.forEach(primitive::put);
        }
        else {
            if (unknownFeatureTypes.add(featureTags)) {
                try {
                    Logging.info("Unknown type: {0}:{1}:{2}", feature,
                            Objects.requireNonNullElse(featureTags.getThema(), ""), 
                            Objects.requireNonNullElse(featureTags.getThemaB(), ""));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
