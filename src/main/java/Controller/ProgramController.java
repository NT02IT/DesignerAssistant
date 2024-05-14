package Controller;

import Handler.ProgramHandler;
import Objects.DesignSoftware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import statics.STATUS;

@Getter
@Setter
public class ProgramController {
    public void open(String programName) {
        ProgramHandler.open(programName);
    }
}
