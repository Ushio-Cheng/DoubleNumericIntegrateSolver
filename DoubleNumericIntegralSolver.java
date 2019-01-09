package DoubleNumericIntegrate;

import DoubleNumericIntegrate.Utility.UCMutableArray;

public class DoubleNumericIntegralSolver {
    public static double rectangularNumericDoubleIntegrateWithPosition(int position, double layer1_lower, double layer1_upper, double layer2_lower, double layer2_upper, double layer1_incriment, double layer2_incriment) throws Exception {
        UCMutableArray layer1_xPositionAndRange = getxPositionAndRangeArray(position, layer1_lower, layer1_upper, layer1_incriment);
        UCMutableArray layer2_yPositionAndRange = getxPositionAndRangeArray(position, layer2_lower, layer2_upper, layer2_incriment);
        double totalSum = 0;
        for (int pointer1 = 0; pointer1 < layer2_yPositionAndRange.length() / 2; pointer1++) {
            double layer2_positionAtPointer = (Double) layer2_yPositionAndRange.getObjectAtPointer(pointer1 * 2);
            double layer2_rangeAtPointer = (Double) layer2_yPositionAndRange.getObjectAtPointer(pointer1 * 2 + 1);
            for (int pointer2 = 0; pointer2 < layer1_xPositionAndRange.length() / 2; pointer2++) {
                double layer1_positionAtPointer = (Double) layer1_xPositionAndRange.getObjectAtPointer(pointer2 * 2);
                double layer1_rangeAtPointer = (Double) layer1_xPositionAndRange.getObjectAtPointer(pointer2 * 2 + 1);
                totalSum += DoubleNumericIntegralFunctionAndConfig.function(layer1_positionAtPointer, layer2_positionAtPointer) * layer1_rangeAtPointer * layer2_rangeAtPointer;
            }
        }
        return totalSum;
    }

    private static UCMutableArray getxPositionAndRangeArray(int position, double lower, double upper, double incriment) throws Exception {
        double range = upper - lower;
        double appoxBlockCount = range * (range < 0 ? -1 : 1) / incriment;
        if (appoxBlockCount < 2) {
            throw new Exception("incriment not valid");
        }
        double positionIndex = lower + position * incriment / 100;
        UCMutableArray xPositionsAndRanges = new UCMutableArray();
        while (true) {
            if ((range < 0 && positionIndex < upper) || (range > 0 && positionIndex > upper)) {
                xPositionsAndRanges.appendObject(upper - (positionIndex - position * incriment / 100));
                break;
            } else {
                xPositionsAndRanges.appendObject(incriment);
            }
            xPositionsAndRanges.appendObject(positionIndex);
            positionIndex += incriment;
        }
        xPositionsAndRanges.dropObjectAtPointer(0);//DELETE first Object(extra incriment)
        return xPositionsAndRanges;
    }

    public static double trapezoidNumericDoubleIntegrate(double layer1_lower, double layer1_upper, double layer2_lower, double layer2_upper, double layer1_incriment, double layer2_incriment) throws Exception {
        return ((rectangularNumericDoubleIntegrateWithPosition(0, layer1_lower, layer2_upper, layer2_lower, layer2_upper, layer1_incriment, layer2_incriment) + rectangularNumericDoubleIntegrateWithPosition(100, layer1_lower, layer2_upper, layer2_lower, layer2_upper, layer1_incriment, layer2_incriment)) / 2.0);
    }
}
