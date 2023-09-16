package controller;

import common.Algorithm;
import view.Menu;
import view.Validate;


public class ChangeBaseNumberProgramming extends Menu<String> {

    static String[] mc = {"Convert From Binary", "Convert From Decimal", "Convert From Hexa"};
    protected Algorithm algorithm;

    public ChangeBaseNumberProgramming() {
        super("PROGRAMMING", mc, "Exit");

    }

    public void execute(int n) {
        switch (n) {
            case 1:
                String binary = Validate.checkInputBinary();
                binary(binary);
                break;
            case 2:
                String decimal = Validate.checkInputDecimal();
                decimal(decimal);
                break;
            case 3:
                String hexa = Validate.checkInputHexaDecimal();
                hexa(hexa);
                break;
            case 4:
                System.exit(0);
        }
    }

    public void binary(String binary) {
        final String[] mcBinary = {"Binary to decimal", "Binary to hexa"};
        class BinaryMenu extends Menu<String> {

            public BinaryMenu() {
                super("Binary Option", mcBinary, "back to main menu");
            }

            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.println("Decimal: "
                                + algorithm.convertBinaryToDecimal(binary)
                        );
                        break;
                    case 2:
                        System.out.println("Hexadecimal: "
                                + algorithm.convertBinaryToHexa(binary));
                        break;
                    case 3:
                    default:
                        return;

                }
            }
        }
        BinaryMenu bm = new BinaryMenu();
        bm.run();
    }

    public void decimal(String decimal) {
        final String[] mcDecimal = {"Decimal to binary", "Decimal to hexa"};
        class DecimalMenu extends Menu<String> {

            public DecimalMenu() {
                super("Decimal Option", mcDecimal, "back to main menu");
            }

            @Override
            public synchronized void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.println("Binary: "
                                + algorithm.convertDecimalToBinary(decimal)
                        );
                        break;
                    case 2:
                        System.out.println("Hexadecimal: "
                                + algorithm.convertDecimalToHexa(decimal));
                    case 3:
                    default:
                        return;
                }
            }
        }
        DecimalMenu dm = new DecimalMenu();
        dm.run();
    }

    public void hexa(String hexa) {
        final String[] mcHexa = {"Hexa to binary", "Hexa to decimal"};
        class HexaMenu extends Menu<String> {

            public HexaMenu() {
                super("Hexa Option", mcHexa, "back to main menu");
            }

            @Override
            public synchronized void execute(int n) {
                 switch (n) {
                    case 1:
                        System.out.println("Binary: "
                                + algorithm.convertHexaToBinary(hexa)
                        );
                        break;
                    case 2:
                        System.out.println("Decimal: "
                                + algorithm.convertHexaToDecimal(hexa));
                        break;
                    case 3:
                    default:
                        return;
                }
            }
        }
        HexaMenu hm = new HexaMenu();
        hm.run();
    }
}