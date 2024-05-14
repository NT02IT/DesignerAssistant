package Handler;

import Objects.DesignSoftware;
import statics.STATUS;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class ProgramHandler {
    private static List<DesignSoftware> designSoftwares = new ArrayList<DesignSoftware>();

    static{
        Properties properties = new Properties();
        try (InputStream input = ProgramHandler.class.getClassLoader().getResourceAsStream("softwares.properties")) {
            if (input == null) {
                System.err.println(STATUS.NO_SOFTWARE_NOW);
                System.exit(0);
            }

            properties.load(input);
            Set<String> softwareNames = properties.stringPropertyNames();

            DesignSoftware ds;
            for (String key : softwareNames) {
                ds = new DesignSoftware(key, properties.getProperty(key));
                designSoftwares.add(ds);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void open (String programName){
        for (DesignSoftware ds : designSoftwares) {
            if (ds.getName().equals(programName)) {
                try {
                    Runtime.getRuntime().exec(ds.getURL());
                    System.out.println(STATUS.OPEN_SUCCESS);
                    System.exit(0);
                } catch (IOException e) {
                    CommandExceptionHanlder e2 = new CommandExceptionHanlder(STATUS.OPEN_ERROR);
                    System.err.println(e2.getMessage());
                    System.exit(0);
                }
            }
        }
        System.err.println(STATUS.OPEN_ERROR);
    }
}
