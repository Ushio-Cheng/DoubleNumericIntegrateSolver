package DoubleNumericIntegrate.Utility.terminal;

import DoubleNumericIntegrate.Utility.UCMutableArray;

public class UCPrinterStyle {
    private UCPrinterSupportedColor fontColor;
    private UCPrinterSupportedColor backgroundColor;
    private UCMutableArray additionalAttributes;//Contains UCPSFA
    public static final String RESET_ALL_STYLE = "\033[0m";

    public UCPrinterStyle(UCPrinterSupportedColor fontColor, UCPrinterSupportedColor backgroundColor) {
        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
        this.additionalAttributes = new UCMutableArray();
    }

    public void addAdditionalAttributes(UCPrinterSupportedFontAttributes newAttribute) {
        additionalAttributes.appendObject(newAttribute);
    }

    public String constructFormattedStringFromOriginal(String originalString) {
        StringBuilder result = new StringBuilder(getFormatterPreFix());
        result.append(originalString);
        result.append(RESET_ALL_STYLE);
        return result.toString();
    }

    public String getFormatterPreFix(){
        StringBuilder result = new StringBuilder("\033[");
        UCMutableArray attributesCodeList = new UCMutableArray();
        if (additionalAttributes.contains(UCPrinterSupportedFontAttributes.MILD_FG)) {
            attributesCodeList.appendObject(foregroundColorCode() + 60);
        } else {
            attributesCodeList.appendObject(foregroundColorCode());
        }
        if (additionalAttributes.contains(UCPrinterSupportedFontAttributes.MILD_BG)) {
            attributesCodeList.appendObject(backgroundColorCode() + 60);
        } else {
            attributesCodeList.appendObject(backgroundColorCode());
        }
        if (additionalAttributes.contains(UCPrinterSupportedFontAttributes.BOLD)){
            attributesCodeList.appendObject(1);
        }
        if (additionalAttributes.contains(UCPrinterSupportedFontAttributes.ITALIC)){
            attributesCodeList.appendObject(3);
        }
        if (additionalAttributes.contains(UCPrinterSupportedFontAttributes.UNDERLINE)){
            attributesCodeList.appendObject(4);
        }
        try {
            result.append(attributesCodeList.getObjectAtPointer(0));
        } catch (Exception exception){
            TerminalInterface.printErrorInf(exception,"FATAL: unexpected Exception");
        }
        for (int pointer = 1; pointer < attributesCodeList.length(); pointer++) {
            try{
                result.append(";");
                result.append(attributesCodeList.getObjectAtPointer(pointer));
            } catch (Exception exception){
                TerminalInterface.printErrorInf(exception,"FATAL: unexpected Exception");
            }
        }
        result.append("m");
        return result.toString();
    }

    private int foregroundColorCode() {
        if (fontColor.equals(UCPrinterSupportedColor.BLACK)) {
            return 30;
        }
        if (fontColor.equals(UCPrinterSupportedColor.RED)) {
            return 31;
        }
        if (fontColor.equals(UCPrinterSupportedColor.GREEN)) {
            return 32;
        }
        if (fontColor.equals(UCPrinterSupportedColor.YELLOW)) {
            return 33;
        }
        if (fontColor.equals(UCPrinterSupportedColor.BLUE)) {
            return 34;
        }
        if (fontColor.equals(UCPrinterSupportedColor.PURPLE)) {
            return 35;
        }
        if (fontColor.equals(UCPrinterSupportedColor.CYAN)) {
            return 36;
        }
        if (fontColor.equals(UCPrinterSupportedColor.WHITE)) {
            return 37;
        } else {
            return 30;
        }
    }

    private int backgroundColorCode() {
        if (backgroundColor.equals(UCPrinterSupportedColor.BLACK)) {
            return 40;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.RED)) {
            return 41;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.GREEN)) {
            return 42;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.YELLOW)) {
            return 43;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.BLUE)) {
            return 44;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.PURPLE)) {
            return 45;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.CYAN)) {
            return 46;
        }
        if (backgroundColor.equals(UCPrinterSupportedColor.WHITE)) {
            return 47;
        } else {
            return 47;
        }
    }
}
