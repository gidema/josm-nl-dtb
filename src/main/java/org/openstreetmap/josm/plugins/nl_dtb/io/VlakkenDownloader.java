package org.openstreetmap.josm.plugins.nl_dtb.io;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.plugins.nl_dtb.DtbClient;
import org.openstreetmap.josm.plugins.nl_dtb.data.PrimitiveFactory;

import nl.pdok.ogc.dtb.ApiException;
import nl.pdok.ogc.dtb.model.FeatureGeoJSONVlakken;

public class VlakkenDownloader extends AbstractFeatureDownloader<FeatureGeoJSONVlakken> {

    public VlakkenDownloader() {
        super(FeatureGeoJSONVlakken.class);
    }

    @Override
    public TaskStatus call() {
        var client = new DtbClient();
        var bbox = getBoundary().toBigDecimalList();
        try {
            var features = client.getVlakken(bbox);
            features.getFeatures().forEach(feature -> {
                // TODO filter obsolete features with the feature request. Not here. 
                if (getFeatureIdCache().add(feature.getId().getString())) {
                    addToOsm(feature);
                }
            });
            MainApplication.getMainPanel().repaint();
        } catch (ApiException e) {
            return TaskStatus.exception(e);
        }
        return TaskStatus.ok;
    }

    @Override
    public void addToOsm(FeatureGeoJSONVlakken feature) {
        var geometry = feature.getGeometry().getActualInstance();
        var osmPrimitive = PrimitiveFactory.createPrimitive(geometry, getDataSet());
        osmPrimitive.put("source", "NL:DTB");
        osmPrimitive.put("ref:NL:DTB", feature.getProperties().getDtbId().toString());
        var thema = feature.getProperties().getThema();
        var themaB = feature.getProperties().getThemb();
        var featureTags = new DtbFeatureTags(thema, "".equals(themaB) ? null : themaB);
        getTagBuilder().buildTags(osmPrimitive, featureTags);
    }
}
