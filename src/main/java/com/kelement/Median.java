package com.kelement;

public class Median extends FindKElement {
    public double calculate(Integer []values){
        double v1 = super.select(values, values.length/2);
        if(values.length %2 == 0){
            double v2 = super.select(values, (values.length/2)-1);
            return (v1 + v2)/2.0;
        }
        return v1;
    }

}
