package org.openstreetmap.josm.plugins.nl_dtb.io;

import java.util.List;

import org.openstreetmap.josm.plugins.nl_dtb.data.DtbGeometryHandler;
import org.openstreetmap.josm.shared.nl_ogc.data.OgcLayerManager;
import org.openstreetmap.josm.shared.nl_ogc.io.FeatureDownloader;
import org.openstreetmap.josm.shared.nl_ogc.io.MultiFeatureDownloader;

public class DtbMultiFeatureDownloader extends MultiFeatureDownloader {
    private static OgcLayerManager layerManager = new OgcLayerManager("NL_DTB", new DtbGeometryHandler());
    private static List<FeatureDownloader<?>> downloaders = List.of(
       new VlakkenDownloader(layerManager));
    private boolean cancelled = false;
    
    public DtbMultiFeatureDownloader() {
        super(layerManager, downloaders);
    }
}
