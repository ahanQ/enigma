package enigma;

import java.util.List;

/**
 * 恩格尼玛机
 *
 * @author luliuquan
 * @date 2021/11/19 11:33
 */
public class Enigma {
    public final List<Rotor> rotors;
    public final Reflector reflector;

    public Enigma(Reflector reflector, List<Rotor> rotors) {
        this.reflector = reflector;
        this.rotors = rotors;
    }
}
