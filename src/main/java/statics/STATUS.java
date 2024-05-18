package statics;

public class STATUS {
    public static final String ACTION_NOT_FOUND = "ACTION_NOT_FOUND\n" +
            "designer init [...] : Khởi tạo cấu trúc dự án [...]\n" +
            "designer open [...] : *Mở phần mềm [...]\n" +
            "designer ask [...] : **Hỏi đáp về [...]\n" +
            "designer conn [URL] : ***Kết nối với kho lưu trữ [URL] online\n" +
            "designer migrate [URL] : Đồng bộ hóa với kho lưu trữ GG Drive\n" +
            "designer clone [URL] : ***Clone nội dung từ kho lưu trữ [URL] online\n" +
            "designer push : ****Đẩy nội dung lên kho lưu trữ online\n" +
            "designer pull : ****Tải nội dung từ kho lưu trữ online về\n" +
            "-------------------------------\n" +
            "*Cần config link phần mềm\n" +
            "**Cần config GPT API\n" +
            "***Cần config tài khoản Gmail\n" +
            "****Cần connect kho lưu trữ";
    public static final String OPTION_NOT_FOUND = "OPTION_NOT_FOUND\n" +
            "--all : Hành động với tất cả từ thư mục gốc kho lưu trữ\n" +
            "--here : Hành động tại vị trí thư mục đang đứng\n" +
            "--latest : Hành động với tệp vừa chỉnh sửa";
    public static final String URL_INVALID = "URL_INVALID\n" +
            "designer chỉ làm việc với https://github.com/ và https://drive.google.com/";
    public static final String URL_NOT_FOUND = "URL_NOTFOUND\n" +
            "Không tìm thấy URL đã chỉ định";
    public static final String OPEN_SUCCESS = "OPEN_SUCCESS\n" +
            "Đã mở phần mềm thành công";
    public static final String OPEN_ERROR = "OPEN_ERROR\n" +
            "Không thể mở phần mềm bạn yêu cầu";
    public static final String NO_SOFTWARE_NOW = "NO_SOFTWARE_NOW\n" +
            "Bạn chưa thêm các phần mềm vào file softwares.properties";
    public static final String NO_WORKSPACE_NOW = "NO_WORKSPACE_NOW\n" +
            "Bạn chưa thêm các Workspace Template vào workspace-templates.json";
    public static final String WORKSPACE_NOT_FOUND = "WORKSPACE_NOTFOUND\n" +
            "Không tìm thấy Workspace";
    public static final String CREATE_SUCCESS = "CREATE_SUCCESS\n" +
            "Tạo thành công";
    public static final String PROPERTIES_NOT_FOUND = "PROPERTIES_NOT_FOUND\n" +
            "Không tìm thấy tên tệp .properties";
}
