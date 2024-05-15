package Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workspace {
    private String name;
//    private JSONObject directories;


//    public static void createStructure(JSONObject jsonObject, File parent) {
//        String name = jsonObject.getString("name");
//        String type = jsonObject.getString("type");
//
//        File newFile = new File(parent, name);
//
//        if (type.equals("directory")) {
//            if (!newFile.exists()) {
//                newFile.mkdir();
//            }
//            JSONArray children = jsonObject.optJSONArray("children");
//            if (children != null) {
//                for (int i = 0; i < children.length(); i++) {
//                    createStructure(children.getJSONObject(i), newFile);
//                }
//            }
//        } else if (type.equals("file")) {
//            try {
//                if (!newFile.exists()) {
//                    newFile.createNewFile();
//                }
//            } catch (IOException e) {
//                System.err.println("Error creating file: " + newFile.getPath());
//                e.printStackTrace();
//            }
//        }
//    }
}
