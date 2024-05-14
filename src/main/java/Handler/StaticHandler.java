package Handler;

import java.util.Objects;

public class StaticHandler {
    public static <E extends Enum<E>> String find (String pattern, Class<E> ENUM){
        String result = null;
        E[] enumValues = ENUM.getEnumConstants();
        for (E value : enumValues) {
            if (pattern.equals(value.toString())) {
                result = value.toString();
            }
        }
        return result;
    }
}
