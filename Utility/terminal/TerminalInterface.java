package DoubleNumericIntegrate.Utility.terminal;

import java.text.NumberFormat;
import java.util.Scanner;


public class TerminalInterface {
    private static final UCPrinter printer = new UCPrinter();
    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    private static final int DIVIDER_LENGTH = 60;


    public static void print(Object object){
        printer.sop(object);
    }
    public static void print(Object object, UCPrinterStyle style){
        printer.sop(object,style);
    }
    public static void print(Object object,int times){
        printer.sop(object,times);
    }
    public static void printAsCurrency(double value){
        printer.sop(currencyFormatter.format(value));
    }
    public static void printLine(Object object){
        printer.sopln(object);
    }
    public static void printLine(Object object, UCPrinterStyle style){
        printer.sopln(object,style);
    }
    public static void printLine(Object object,int times){
        printer.sopln(object,times);
    }
    public static void printBlankLines(int times){
        printer.newLine(times);
    }

    public static void printDivider(){
        printer.sop("=",DIVIDER_LENGTH);
        printBlankLines(1);
    }

    public static void printDivider(int length){
        printer.sop("=",length);
        printBlankLines(1);
    }
    private static String getDividerWith(char body,String message){
        StringBuilder stringBuilder = new StringBuilder();
        if (message.length()>DIVIDER_LENGTH-10){
            stringBuilder.append(concatRepeatString(String.valueOf(body),5));
            stringBuilder.append(message);
            stringBuilder.append(concatRepeatString(String.valueOf(body),5));
        } else {
            int dividerCount = DIVIDER_LENGTH-message.length();
            int leftLength = dividerCount%2==0? dividerCount/2:(int)(Math.floor((double)dividerCount/2)+1);
            int rightLength = dividerCount%2==0? dividerCount/2:(int)(Math.floor((double)dividerCount/2));
            stringBuilder.append(concatRepeatString(String.valueOf(body),leftLength));
            stringBuilder.append(message);
            stringBuilder.append(concatRepeatString(String.valueOf(body),rightLength));
        }
        return stringBuilder.toString();
    }
    private static String concatRepeatString(String phase,int times){
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < times; count++) {
            stringBuilder.append(phase);
        }
        return stringBuilder.toString();
    }

    public static void printDivider(char dividerBody,String message){//WARNING: ALL Inner Msg is UPPER CASE.
        message = message.toUpperCase();
        printLine(getDividerWith(dividerBody,message));
    }

    public static void printDivider(String message){
        printDivider('=',message);
    }

    public static void printDivider(char body){
        printDivider(body,"");
    }

    public static void printErrorInf(Exception exception){
        UCPrinterStyle ERROR_STYLE = new UCPrinterStyle(UCPrinterSupportedColor.YELLOW,UCPrinterSupportedColor.RED);
        ERROR_STYLE.addAdditionalAttributes(UCPrinterSupportedFontAttributes.BOLD);
        printer.setTerminalFontStyle(ERROR_STYLE);
        printDivider("ERROR");
        printLine(exception.getMessage());
        printDivider('-');
        printer.print1DArray(exception.getStackTrace());
        printDivider('=');
        printer.clearTerminalFontStyle();
    }
    public static void printErrorInf(Exception exception,String additionalNote){
        UCPrinterStyle ERROR_STYLE = new UCPrinterStyle(UCPrinterSupportedColor.YELLOW,UCPrinterSupportedColor.RED);
        ERROR_STYLE.addAdditionalAttributes(UCPrinterSupportedFontAttributes.BOLD);
        printer.setTerminalFontStyle(ERROR_STYLE);
        printDivider("ERROR");
        printLine(exception.getMessage());
        printDivider('-');
        printer.print1DArray(exception.getStackTrace());
        printDivider('-',"ADDITIONAL NOTE FROM TOP LYR");
        printLine(additionalNote);
        printDivider('=');
        printer.clearTerminalFontStyle();
    }
    public static String readLine(){
        return scanner.nextLine();
    }
    public static int readInt(){
        int result = Integer.parseInt(readLine());
        return result;
    }
    public static void pressEnterToContinue(){
        String tmp = readLine();
    }

    public static String askForStringInputWith(String question){
        printLine(question);
        return UCKeyboard.nextLine();
    }
    public static int askForIntegerInputWith(String question){
        printLine(question);
        return UCKeyboard.nextInt();
    }
}
