import com.solidsystems.avlasov.frontend.entity.Product;
import org.codehaus.jackson.map.ObjectMapper;

import java.net.URL;

/**
 * Created by Alex Vlasov on 05.11.15.
 */

public class test {

    static String getProductsListUrl = "http://localhost:8080/salestoreapi-backend-1.0/salestoreapi/product/getObjectList";

    public static void main(String[] args) {
        try {
            Product[] ps = getObjectList();
            for(Product p: ps){
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Product[] getObjectList() throws InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Product[] p = null;
        try {
            p = mapper.readValue(new URL(getProductsListUrl), Product[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }


}
