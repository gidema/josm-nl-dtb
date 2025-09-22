package org.openstreetmap.josm.plugins.nl_dtb;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import nl.pdok.ogc.dtb.ApiClient;
import nl.pdok.ogc.dtb.ApiException;
import nl.pdok.ogc.dtb.api.FeaturesApi;
import nl.pdok.ogc.dtb.model.FeatureCollectionGeoJSONVlakken;

public class DtbClient {
    private URI crs;
    private final ApiClient apiClient = new ApiClient();

    public DtbClient() {
        super();
        try {
            crs = new URI("http://www.opengis.net/def/crs/OGC/1.3/CRS84");
//            bboxCrs = new URI("http://www.opengis.net/def/crs/EPSG/0/28992");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        apiClient.setBasePath("https://api.pdok.nl/rws/digitaal-topografisch-bestand/ogc/v1");
    }
    
    public FeatureCollectionGeoJSONVlakken getVlakken(List<BigDecimal> bbox) throws ApiException {
        var api = new FeaturesApi(apiClient);
        return api.vlakkenGetFeatures("json", 1000, crs, bbox, crs, null, null, null, null, null, null, null);
    }
}
