package Handler;

import Objects.WorkspaceItem;
import Objects.Workspace;
import com.google.gson.*;
import statics.STATUS;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkspaceHandler {
    private static List<Workspace> workspaces = new ArrayList<Workspace>();
//    private Gson gson = new GsonBuilder().registerTypeAdapter(Object.class, new CustomDeserializer()).create();

    static { // Read list workspace from JSON
        try (InputStream input = ProgramHandler.class.getClassLoader().getResourceAsStream("workspace-templates.json")) {
            if (input == null) {
                System.err.println(STATUS.NO_WORKSPACE_NOW);
                System.exit(0);
            }

            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);
            JsonElement jsonElement = JsonParser.parseReader(bufferedReader);

            // Check if the root element is a JSON object
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                // Iterate through the entries in the JSON object
                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    String key = entry.getKey();
                    JsonArray jsonArray = entry.getValue().getAsJsonArray();
                    workspaces.add(new Workspace(key, jsonArray));
                }
            } else {
                System.err.println("The provided JSON is not an object.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init(){
        System.out.println("LOOSING WORKSPACES\n" +
                "Chọn 1 trong các Workspace sau để bắt đầu:");
        for (Workspace workspace : workspaces) {
            System.out.println(workspace.getName());
        }
        System.out.println("-------------------------------\n" +
                "designer init workspace : Tạo workspace ở thư mục hiện tại\n" +
                "designer init workspace url : Tạo workspace tại thư mục với đường dẫn url\n" +
                "designer init workspace --from url : Copy cấu trúc thư mục từ url đến thư mục đang đứng hiện tại\n" +
                "designer init workspace --from url --to url : Copy cấu trúc thư mục từ url đến thư mục cung cấp");
    }

    public void init(String workspaceName) {
        System.out.println("Initializing workspaces...");
        for (Workspace workspace : workspaces) {
            if (workspace.getName().equals(workspaceName)) {
                Gson gson = new Gson();
                WorkspaceItem[] directories = gson.fromJson(workspace.getDirectories(), WorkspaceItem[].class);
                for (WorkspaceItem directory : directories) {
                    createStructure(directory, "");
                }
                System.out.println(STATUS.CREATE_SUCCESS + " Workspace " + workspaceName);
                return;
            }
        }
        System.out.println(STATUS.WORKSPACE_NOT_FOUND + " " + workspaceName);
    }

    public void init(String workspaceName, String DesURL) {
        System.out.println("Initializing workspaces...");
        for (Workspace workspace : workspaces) {
            if (workspace.getName().equals(workspaceName)) {
                Gson gson = new Gson();
                WorkspaceItem[] directories = gson.fromJson(workspace.getDirectories(), WorkspaceItem[].class);
                for (WorkspaceItem directory : directories) {
                    createStructure(directory, DesURL);
                }
                System.out.println(STATUS.CREATE_SUCCESS + " Workspace " + workspaceName);
                return;
            }
        }
        System.out.println(STATUS.WORKSPACE_NOT_FOUND + " " + workspaceName);
    }

    private static void createStructure(WorkspaceItem workspaceItem, String parentPath) {
        try {
            Path currentPath = Paths.get(parentPath, workspaceItem.getName());
            if ("directory".equals(workspaceItem.getType())) {
                Files.createDirectories(currentPath);
                if (workspaceItem.getChildren() != null) {
                    for (WorkspaceItem child : workspaceItem.getChildren()) {
                        createStructure(child, currentPath.toString());
                    }
                }
            } else if ("file".equals(workspaceItem.getType())) {
                Files.createFile(currentPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
