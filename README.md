## Cấu hình yêu cầu:
- **Cài đặt Java 21**
- **Cấu hình Java Runtime Env:**
  - `Window+S` gõ `env` chọn _"Edit System Environment Variables"_
  - Chọn _"Environment Variables"_
  - Tìm đến Variable `PATH` click chọn và thêm giá trị _"C:\Program Files\Java\jdk-21\bin"_ (Đường dẫn đến thư mục bin của Java 21)
  - Đưa giá trị vừa thêm lên cao nhất sau đó lưu lại
  - Kiểm tra xem Window đã cập nhật Java Environment Runtime chưa bằng cách vào cmd gõ `java -version`

## Chạy chương trình
- Thêm đường dẫn thư mục chứa file _designer.bat_ vào `PATH` (Như cấu hình Java Runtime Env)
- Tạo cấu trúc thư mục của các dự án tại file _workspace-templates_
- Thêm đường dẫn các phần mềm thiết kế tại file resources _design_software.properties_ để sử dụng `designer open`
- Thêm các thông tin config như GEMINI_API, tài khoản Google Drive vào file designer.bat
- Rebuild chương trình để cập nhật các thông tin bạn vừa setup bên trên:
  - Di chuyển đến thư mục dự án
  - Gõ `cmd` trên thanh địa chỉ của File Explorer
  - Gõ lệnh sau `mvn clean install` để rebuild chương trình

## Tips sử dụng hiệu quả
- Sử dụng chung với PowerToys Run bằng cách vào mục Shell tick chọn _"Include in global result"_ và _"Keep shell open"_