package com.solidsystems.avlasov.frontend.entity;

/**
 * Created by Alex Vlasov on 24.10.15.
 */
public class StatisticsInfo {

    private String a = "stat1";
    private String b = "stat2";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "StatisticsInfo{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
