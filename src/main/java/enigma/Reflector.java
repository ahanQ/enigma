package enigma;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 反射板
 *
 * @author luliuquan
 * @date 2021/11/19 16:22
 */
public class Reflector {

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
