package enigma;

/**
 * 运行主程序
 *
 * @author luliuquan
 * @date 2021/11/19 11:33
 */
public class Main {
    private static final Enigma ENIGMA = new Enigma();

    public static void main(String[] args) {
        final char[] result = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
        print(result);
        ENIGMA.rotors.get(0).position = 1;
        ENIGMA.rotors.get(1).position = 0;
        ENIGMA.rotors.get(2).position = 0;
        encryptionAndPrint(ENIGMA, result);
        ENIGMA.rotors.get(0).position = 1;
        ENIGMA.rotors.get(1).position = 0;
        ENIGMA.rotors.get(2).position = 0;
        encryptionAndPrint(ENIGMA, result);
    }

    private static void print(char[] chars) {
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
    }


    private static void encryptionAndPrint(Enigma enigma, char[] chars) {
        encryption(enigma, chars);
        print(chars);
    }

    private static void encryption(Enigma enigma, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = enigma.trigger(chars[i]);
        }
    }
}
