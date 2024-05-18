package Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DesignSoftware {
    private String name;
    private String[] URLs;

    public DesignSoftware(String name) {
        this.name = name;
    }
    public DesignSoftware(String name, String URLstr) {
        this.name = name;
        this.URLs = URLstr.split("; ");
    }
}
