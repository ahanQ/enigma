package enigma;

import java.util.*;

/**
 * 恩格尼玛机
 *
 * @author luliuquan
 * @date 2021/11/19 11:33
 */
public class Enigma {
    private static final Random RANDOM = new Random(17);
    public final Reflector reflector = new Reflector();
    public static final Rotor ROTOR_1 = new Rotor();
    public static final Rotor ROTOR_2 = new Rotor();
    public static final Rotor ROTOR_3 = new Rotor();
    public final List<Rotor> rotors;

    public Enigma() {
        // 初始化恩尼格玛机
        // 默认第一个转子设置
        {
            final int[] front = ROTOR_1.front;
            final int[] back = ROTOR_1.back;
            int count = 0;
            while (count < 26) {
                int r = (RANDOM.nextInt(26) + count) % 26;
                if (front[count] == -1 && back[r] == -1) {
                    front[count] = r;
                    back[r] = count;
                    count++;
                }
            }
        }
        // 默认第二个转子设置
        {
            final int[] front = ROTOR_2.front;
            final int[] back = ROTOR_2.back;
            int count = 0;
            while (count < 26) {
                int r = (RANDOM.nextInt(26) + count) % 26;
                if (front[count] == -1 && back[r] == -1) {
                    front[count] = r;
                    back[r] = count;
                    count++;
                }
            }
        }
        // 默认第三个转子设置
        {
            final int[] front = ROTOR_3.front;
            final int[] back = ROTOR_3.back;
            int count = 0;
            while (count < 26) {
                int r = (RANDOM.nextInt(26) + count) % 26;
                if (front[count] == -1 && back[r] == -1) {
                    front[count] = r;
                    back[r] = count;
                    count++;
                }
            }
        }
        this.rotors = Arrays.asList(ROTOR_1, ROTOR_2, ROTOR_3);
    }

    /**
     * 输入一个字符，输出加密后的字符
     *
     * @param input 输入
     * @return 输出
     */
    public char trigger(char input) {
        int s = input - 97;
        final List<Rotor> rotors = this.rotors;
        // 正面进入转子
        for (final Rotor rotor : rotors) {
            s = rotorInput(rotor, s);
        }
        // 通过反射板
        s = triggerReflector(this.reflector, s);
        // 背面进入转子
        for (int i = rotors.size() - 1; i >= 0; i--) {
            final Rotor rotor = rotors.get(i);
            s = rotorOutput(rotor, s);
        }
        // 转子转动
        boolean isNext;
        int index = 0;
        do {
            isNext = false;
            final Rotor rotor = rotors.get(index++);
            rotor.position++;
            while (rotor.position >= 26) {
                rotor.position -= 26;
                isNext = true;
            }
        } while (isNext && index < rotors.size());
        // 返回结果
        return (char) (s + 97);
    }

    /**
     * 反射板的映射
     *
     * @param reflector 反射板
     * @param input     输入
     * @return 输出
     */
    private int triggerReflector(Reflector reflector, int input) {
        return reflector.lines.get(input);
    }

    /**
     * 入口端进入转子
     *
     * @param rotor 转子
     * @param input 输入
     * @return 输出
     */
    private int rotorInput(Rotor rotor, int input) {
        return (rotor.front[(input + rotor.position) % 26] + 26 - rotor.position) % 26;
    }

    /**
     * 返回端进入转子
     *
     * @param rotor 转子
     * @param input 输入
     * @return 输出
     */
    private int rotorOutput(Rotor rotor, int input) {
        return (rotor.back[(input + rotor.position) % 26] + 26 - rotor.position) % 26;
    }

    /**
     * 转子
     */
    public static class Rotor {
        public final int[] front = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public final int[] back = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public int position;
    }

    public static class Reflector {

        public final Map<Integer, Integer> lines = new LinkedHashMap<>();

        public Reflector() {
            // 默认反射反设置
            lines.put(0, 13);
            lines.put(1, 14);
            lines.put(2, 15);
            lines.put(3, 16);
            lines.put(4, 17);
            lines.put(5, 18);
            lines.put(6, 19);
            lines.put(7, 20);
            lines.put(8, 21);
            lines.put(9, 22);
            lines.put(10, 23);
            lines.put(11, 24);
            lines.put(12, 25);
            lines.put(13, 0);
            lines.put(14, 1);
            lines.put(15, 2);
            lines.put(16, 3);
            lines.put(17, 4);
            lines.put(18, 5);
            lines.put(19, 6);
            lines.put(20, 7);
            lines.put(21, 8);
            lines.put(22, 9);
            lines.put(23, 10);
            lines.put(24, 11);
            lines.put(25, 12);
        }
    }

}
