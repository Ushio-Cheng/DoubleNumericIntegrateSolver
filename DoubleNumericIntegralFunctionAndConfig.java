package DoubleNumericIntegrate;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.sin;

public class DoubleNumericIntegralFunctionAndConfig {

    public static final double LAYER_1_LOWER_BOUND = 0;
    public static final double LAYER_1_UPPER_BOUND = 1;
    public static final double LAYER_2_LOWER_BOUND = 0;
    public static final double LAYER_2_UPPER_BOUND = 1;
    public static final double LAYER_1_INCRIMENT = 0.01;
    public static final double LAYER_2_INCRIMENT = 0.01;
    public static final int INTEGRATE_POSITION = 0;

    //// Integrate Position References
    // 0 for left-point
    // 50 for mid-point
    // 100 for right-point
    // * any number between 0 and 100 is position
    // >100 for trapezoid
    // ** any number lower than 0 is not accepted


    public static double function(double x, double y) {
        double value = sin(x) * cos(x) * exp(y);
        return value;
    }
}
