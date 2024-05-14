##Cấu hình yêu cầu:
- **Cài đặt Java 21**
- **Cấu hình Java Runtime Env:**
  - Window+S gõ env chọn "Edit System Environment Variables"
  - Chọn Environment Variables
  - Tìm đến Variable "path" click chọn và thêm giá trị "C:\Program Files\Java\jdk-21\bin" (Đường dẫn đến thư mục bin của Java 21)
  - Đưa giá trị vừa thêm lên cao nhất sau đó lưu lại
  - Kiểm tra xem Window đã cập nhật Java Environment Runtime chưa bằng cách vào cmd gõ "java -version"

##Chạy chương trình
- Thêm đường dẫn thư mục chứa file designer.bat vào PATH (Như cấu hình Java Runtime Env)
- Thêm đường dẫn các phần mềm thiết kế tại file resources design_software.properties để sử dụng "designer open"
- Chạy chương trình bằng cách designer parameters

##Tips sử dụng hiệu quả
- Sử dụng chung với PowerToys Run bằng cách vào mục Shell tick chọn "Include in global result" và "Keep shell open"