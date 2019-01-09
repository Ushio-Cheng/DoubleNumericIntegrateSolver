#Double NIntegrate Solver
##Math Function
`Integrate[Integrate[f[x,y],{x,a,b}],{y,c,d}]`
##remarks
1. Layer1 -> inner layer  
2. Layer2 -> outer layer  
3. Only edit `DoubleNumericIntegralFunctionAndConfig` class
##Parameters
1. LAYER_1_LOWER_BOUND:a  
2. LAYER_1_UPPER_BOUND:b  
3. LAYER_2_LOWER_BOUND:c  
4. LAYER_2_UPPER_BOUND:d  
5. LAYER_1_INCRIMENT:inner layer incriment  
6. LAYER_2_INCRIMENT:outer layer incriment  
7. INTEGRATE_POSITION
    >0 for left-point  
    50 for mid-point  
    100 for right-point  
     \*any number between 0 and 100 is position  
    \>100 for trapezoid  
    \*\* any number lower than 0 is not accepted  
##Function
*Functions goes into method*  
`DoubleNumericIntegralFunctionAndConfig:function(double x, double y)`