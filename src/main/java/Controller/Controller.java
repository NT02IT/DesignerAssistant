package Controller;

import Handler.CommandExceptionHanlder;
import Handler.StaticHandler;
import statics.ACTIONS;
import statics.STATUS;

import java.util.Arrays;

public class Controller {
    private String action;
    private String option; //optional start with "--"
    private String[] parameters;

    public Controller(String[] args){
        if (args.length == 0) {
            CommandExceptionHanlder e = new CommandExceptionHanlder(STATUS.ACTION_NOT_FOUND);
            System.err.println(e.getMessage());

//            throw e;
            System.exit(0);
        } else {
            try{
                if (args[0] != null && !args[0].isEmpty()) {
                    action = args[0];
                }
            } catch (Exception e){
                CommandExceptionHanlder e2 = new CommandExceptionHanlder(STATUS.ACTION_NOT_FOUND);
                System.err.println(e.getMessage());
//                throw e2;
                System.exit(0);
            }

            try{
                if (args[1] != null && !args[1].isEmpty()) {
                    if (args[1].startsWith("--")) {
                        option = args[1].substring(1);
                        try {
                            if (args[2] != null && !args[2].isEmpty()) {
                                parameters = Arrays.copyOfRange(args, 2, args.length);
                            }
                        } catch (Exception e){}
                    } else {
                        parameters = Arrays.copyOfRange(args, 1, args.length);
                    }
                }
            } catch (Exception e){}


        }

        // Xu ly dieu huong
        String result = StaticHandler.find(action, ACTIONS.class);
        if (result != null) {
            // Action init
            if (result.equals(ACTIONS.init.toString())) {
                WorkspaceController workspaceController = new WorkspaceController();

                // Kiểm tra có tên workspace không
                if(parameters != null && parameters.length > 0){
                    // Kiểm tra xem có đính kèm URL đích không
                    boolean flag = true;
                    try{
                        if (parameters[1] != null && !parameters[1].isEmpty()) {
                            workspaceController.init(parameters[0], parameters[1]);
                            flag = false;
                        }
                    } catch(Exception e){}
                    if (flag) {
                        workspaceController.init(parameters[0]);
                    }
                } else {
                    workspaceController.init();
                }
            }

            // Action open
            if (result.equals(ACTIONS.open.toString())) {
                ProgramController programController = new ProgramController();

                // Kiểm tra xem có tên phầm mềm không
                if(parameters != null && parameters.length > 0){
                    programController.open(parameters[0]);
                } else {
                    System.err.println(STATUS.OPEN_ERROR);
                }
            }
        } else { // Không có action thích hợp
            CommandExceptionHanlder e = new CommandExceptionHanlder(STATUS.ACTION_NOT_FOUND);
            System.err.println(e.getMessage());
//            throw e;
            System.exit(0);
        }
    }
}
