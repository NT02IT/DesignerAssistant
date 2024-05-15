package Handler;

import Objects.Workspace;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkspaceHandler {
    private static List<Workspace> workspaces = new ArrayList<Workspace>();

    static { // Read list workspace from JSON
        String jsonFilePath = "D:\\Workspace\\Develop\\Maven\\DesignerAssistant\\src\\main\\resources\\workspace-templates.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));
            createDirectories(rootNode);
            System.out.println("Directories created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (JSONObject rootJsonWS : rootJsonWSs) {
//            workspaces.add(new Workspace(rootJsonWS.get("name").toString(), rootJsonWS));
//            System.out.println(rootJsonWS.get("name").toString());
////            createStructure(workspace.getJSONObject(i), new File("."));
//        }
    }

    private static void createDirectories(JsonNode rootNode) throws IOException {
        Iterator<String> fieldNames = rootNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode directoryNode = rootNode.get(fieldName);
            createDirectory(fieldName, directoryNode);
        }
    }

    private static void createDirectory(String parentPath, JsonNode directoryNode) throws IOException {
        for (JsonNode itemNode : directoryNode) {
            String itemName = itemNode.get("name").asText();
            String itemType = itemNode.get("type").asText();

            Path itemPath = Path.of(parentPath, itemName);
            if (itemType.equals("directory")) {
                try {
                    Files.createDirectories(itemPath);
                } catch (FileAlreadyExistsException e) {
                    System.out.println("Directory " + itemName + " already exists.");
                }
                JsonNode childrenNode = itemNode.get("children");
                if (childrenNode != null) {
                    createDirectory(itemPath.toString(), childrenNode);
                }
            } else if (itemType.equals("file")) {
                try {
                    Files.createFile(itemPath);
                } catch (FileAlreadyExistsException e) {
                    System.out.println("File " + itemName + " already exists.");
                }
            }
        }
    }
}
