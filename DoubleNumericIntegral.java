package DoubleNumericIntegrate;

import DoubleNumericIntegrate.Utility.terminal.TerminalInterface;

public class DoubleNumericIntegral {

    public static void main(String[] args) {
        final double LAYER_1_LOWER_BOUND = DoubleNumericIntegralFunctionAndConfig.LAYER_1_LOWER_BOUND;
        final double LAYER_1_UPPER_BOUND = DoubleNumericIntegralFunctionAndConfig.LAYER_1_UPPER_BOUND;
        final double LAYER_2_LOWER_BOUND = DoubleNumericIntegralFunctionAndConfig.LAYER_2_LOWER_BOUND;
        final double LAYER_2_UPPER_BOUND = DoubleNumericIntegralFunctionAndConfig.LAYER_2_UPPER_BOUND;
        final double LAYER_1_INCRIMENT = DoubleNumericIntegralFunctionAndConfig.LAYER_1_INCRIMENT;
        final double LAYER_2_INCRIMENT = DoubleNumericIntegralFunctionAndConfig.LAYER_2_INCRIMENT;
        final int INTEGRATE_POSITION = DoubleNumericIntegralFunctionAndConfig.INTEGRATE_POSITION;
        if (INTEGRATE_POSITION < 0) {
            TerminalInterface.printErrorInf(new Exception("input not valid"));
        } else {
            double result;
            if (INTEGRATE_POSITION <= 100) {
                try {
                    result = DoubleNumericIntegralSolver.rectangularNumericDoubleIntegrateWithPosition(INTEGRATE_POSITION, LAYER_1_LOWER_BOUND, LAYER_1_UPPER_BOUND, LAYER_2_LOWER_BOUND, LAYER_2_UPPER_BOUND, LAYER_1_INCRIMENT, LAYER_2_INCRIMENT);
                } catch (Exception e) {
                    TerminalInterface.printErrorInf(e);
                    result = 0;
                }
            } else {
                try {
                    result = DoubleNumericIntegralSolver.trapezoidNumericDoubleIntegrate(LAYER_1_LOWER_BOUND, LAYER_1_UPPER_BOUND, LAYER_2_LOWER_BOUND, LAYER_2_UPPER_BOUND, LAYER_1_INCRIMENT, LAYER_2_INCRIMENT);
                } catch (Exception e) {
                    TerminalInterface.printErrorInf(e);
                    result = 0;
                }
            }
            TerminalInterface.print("Result = " + result);
        }
    }
}
