# Ứng Dụng Xem Thời Khóa Biểu Cho Sinh Viên Đại Học Bách Khoa - Đại Học Đà Nẵng

## Mục Tiêu

Ứng dụng này được tạo ra nhằm hiển thị thời khóa biểu và thời gian học của sinh viên một cách trực quan và dễ nhìn.

## Hướng Dẫn Cài Đặt

### 1. Tải File JAR

* Truy cập vào phần [Releases](<https://github.com/Chinh-de/DUT_SChedule/releases/tag/v0.1>) của repository.
* Tải file `.jar` mới nhất.

### 2. Cài Đặt Java Runtime Environment (JRE):
* Kiểm tra Java VM qua console:

    * Trên Windows, Ubuntu, và macOS:
        Mở terminal (hoặc command prompt trên Windows) và chạy lệnh sau để kiểm tra xem Java đã được cài đặt chưa:

        ```bash
        java -version
        ```

        Nếu Java được cài đặt, bạn sẽ thấy thông tin phiên bản Java.
*Nếu chưa cài đặt cài đặt theo hướng dẫn dưới:
* Truy cập trang [Oracle Java Downloads](<https://www.java.com/download/>).
* Tải và cài đặt Java Runtime Environment (JRE): phiên bản mới nhất.
* Kiểm tra lại Java VM qua console:

    * Trên Windows, Ubuntu, và macOS:
        Mở terminal (hoặc command prompt trên Windows) và chạy lệnh sau để kiểm tra xem Java đã được cài đặt chưa:

        ```bash
        java -version
        ```

        Nếu Java được cài đặt, bạn sẽ thấy thông tin phiên bản Java.

### 3. Chạy Ứng Dụng

* Mở terminal hoặc command prompt.
* Điều hướng đến thư mục chứa file `.jar` đã tải.
* Chạy lệnh sau:

    ```bash
    java -jar your-app-name.jar
    ```

* Đăng nhập và chọn học kỳ để xem thời khóa biểu.

## Công Nghệ Sử Dụng

* **Java**: Sử dụng `HTTPRequest` để crawl dữ liệu từ hệ thống.
* **HTML**: Để hiển thị giao diện người dùng.
