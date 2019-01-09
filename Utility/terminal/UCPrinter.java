package DoubleNumericIntegrate.Utility.terminal;

public class UCPrinter {
    public void sop(Object obj){
        System.out.print(obj);
    }
    public void sopln(Object obj){
        System.out.println(obj);
    }
    public void print1DArray(Object[] arrIn){
        for (Object anArrIn : arrIn) {
            sopln(anArrIn.toString());
        }
    }
    public void newLine(int num){
        for (int count = 0;count<num;count++){
            System.out.println();
        }
    }
    public void sop(Object obj,int times){
        for (int count = 0; count < times; count++) {
            sop(obj);
        }
    }
    public void sopln(Object obj,int times){
        for (int count = 0; count < times; count++) {
            sopln(obj);
        }
    }

    public void sop(Object object, UCPrinterStyle style){
        sop(style.constructFormattedStringFromOriginal(object.toString()));
    }

    public void sopln(Object object, UCPrinterStyle style){
        sopln(style.constructFormattedStringFromOriginal(object.toString()));
    }

    public void setTerminalFontStyle(UCPrinterStyle style){
        sop(style.getFormatterPreFix());
    }

    public void clearTerminalFontStyle(){
        sop(UCPrinterStyle.RESET_ALL_STYLE);
    }
}
