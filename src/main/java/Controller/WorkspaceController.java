package Controller;

import Handler.WorkspaceHandler;

public class WorkspaceController {
    public WorkspaceHandler workspaceHandler = new WorkspaceHandler();

    public void init(){
        workspaceHandler.init();
    }
    public void init(String workspace){
        workspaceHandler.init(workspace);
    }
    public void init(String workspace, String DesURL){
        workspaceHandler.init(workspace, DesURL);
    }
}
