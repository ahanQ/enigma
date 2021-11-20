package enigma;

import java.util.Arrays;
import java.util.Random;

/**
 * 运行主程序
 *
 * @author luliuquan
 * @date 2021/11/19 11:33
 */
public class Main {
    private static Random random = new Random(17);
    private static final Enigma enigma;

    static {
        // 初始化恩尼格玛机
        final Reflector reflector = new Reflector();
        final Rotor rotor1 = new Rotor();
        // 默认第一个转子设置
        {
            final int[] front = rotor1.front;
            final int[] back = rotor1.back;
            int count = 0;
            while (count < 26) {
                int r = (random.nextInt(26) + count) % 26;
                if (front[count] == -1 && back[r] == -1) {
                    front[count] = r;
                    back[r] = count;
                    count++;
                }
            }
        }
        final Rotor rotor2 = new Rotor();
        // 默认第二个转子设置
        {
            final int[] front = rotor2.front;
            final int[] back = rotor2.back;
            int count = 0;
            while (count < 26) {
                int r = (random.nextInt(26) + count) % 26;
                if (front[count] == -1 && back[r] == -1) {
                    front[count] = r;
                    back[r] = count;
                    count++;
                }
            }
        }
        final Rotor rotor3 = new Rotor();
        // 默认第二个转子设置
        {
            final int[] front = rotor3.front;
            final int[] back = rotor3.back;
            int count = 0;
            while (count < 26) {
                int r = (random.nextInt(26) + count) % 26;
                if (front[count] == -1 && back[r] == -1) {
                    front[count] = r;
                    back[r] = count;
                    count++;
                }
            }
        }
        enigma = new Enigma(reflector, Arrays.asList(rotor1, rotor2, rotor3));
    }

    public static void main(String[] args) {
        final char[] result = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
        enigma.rotors.get(0).position = 1;
        enigma.rotors.get(1).position = 0;
        enigma.rotors.get(2).position = 0;
        Run.encryption(enigma, result);
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
        enigma.rotors.get(0).position = 1;
        enigma.rotors.get(1).position = 0;
        enigma.rotors.get(2).position = 0;
        Run.encryption(enigma, result);
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
    }
}
