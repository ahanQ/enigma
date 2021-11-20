package enigma;

import java.util.List;

/**
 * 恩尼格玛机运行逻辑
 *
 * @author luliuquan
 * @date 2021/11/19 16:29
 */
public class Run {

    /**
     * 输入序列，输出加密后的序列
     *
     * @param input 输入
     * @return 输出
     */
    public static char[] encryption(Enigma enigma, char[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = encryption(enigma, input[i]);
        }
        return input;
    }

    /**
     * 输入一个字符，输出加密后的字符
     *
     * @param input 输入
     * @return 输出
     */
    public static char encryption(Enigma enigma, char input) {
        int s = input - 97;
        final List<Rotor> rotors = enigma.rotors;
        // 正面进入转子
        for (final Rotor rotor : rotors) {
            s = rotorInput(rotor, s);
        }
        // 通过反射板
        s = triggerReflector(enigma.reflector, s);
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

    private static int triggerReflector(Reflector reflector, int input) {
        return reflector.lines.get(input);
    }

    private static int rotorInput(Rotor rotor, int input) {
        return (rotor.front[(input + rotor.position) % 26] + 26 - rotor.position) % 26;
    }

    private static int rotorOutput(Rotor rotor, int input) {
        return (rotor.back[(input + rotor.position) % 26] + 26 - rotor.position) % 26;
    }

}
