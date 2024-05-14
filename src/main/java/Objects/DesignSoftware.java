package Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesignSoftware {
    private String name;
    private String URL;

    public DesignSoftware(String name) {
        this.name = name;
    }
}
