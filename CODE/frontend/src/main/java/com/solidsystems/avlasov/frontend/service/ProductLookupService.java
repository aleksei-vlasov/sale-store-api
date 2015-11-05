package com.solidsystems.avlasov.frontend.service;

import com.solidsystems.avlasov.frontend.entity.Product;
import com.sun.jndi.toolkit.url.UrlUtil;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import sun.net.util.URLUtil;

import java.net.URI;
import java.net.URL;

/**
 * Created by Alex Vlasov on 04.11.15.
 */
public class ProductLookupService {

    private Logger log = Logger.getLogger(ProductLookupService.class);

    public static final String CONTEXT_ROOT = "http://localhost:8080/salestoreapi-backend-1.0/salestoreapi/product";
    public static final String LIST = "/list";
    public static final String SAVE = "/save/%s&%s&%s";

    public Product[] list() throws InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Product[] p = null;
        try {
            p = mapper.readValue(new URL(CONTEXT_ROOT + LIST), Product[].class);
        } catch (Exception e) {
            new RuntimeException(e);
        }
        return p;
    }

    public Long save(Product p) throws InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Long id = null;
        try {
            String params = String.format(SAVE, new Object[]{p.getId() == null ? "" : p.getId() , p.getName(), p.getPrice()});
            log.debug(params);
            URL url = new URL(CONTEXT_ROOT + params);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            id = mapper.readValue(uri.toURL(), Long.class);
        } catch (Exception e) {
            log.error(e);
        }
        return id;
    }


}
