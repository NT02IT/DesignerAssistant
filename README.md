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
- Thêm đường dẫn các phần mềm thiết kế tại file resources _design_software.properties_ để sử dụng `designer open`
- Chạy chương trình bằng cách `designer parameters`

## Tips sử dụng hiệu quả
- Sử dụng chung với PowerToys Run bằng cách vào mục Shell tick chọn _"Include in global result"_ và _"Keep shell open"_