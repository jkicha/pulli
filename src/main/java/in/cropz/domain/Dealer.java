package in.cropz.domain;

import org.springframework.stereotype.Component;

/**
 * Created by jsl-srv1 on 5/7/2015.
 */
@Component
public class Dealer {

    public long getDealerId() {
        return dealerId;
    }

    public void setDealerId(long dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerCity() {
        return dealerCity;
    }

    public void setDealerCity(String dealerCity) {
        this.dealerCity = dealerCity;
    }

    private long dealerId;       // achead
    private String dealerName;  // acname
    private String dealerCity;  // address3


}
