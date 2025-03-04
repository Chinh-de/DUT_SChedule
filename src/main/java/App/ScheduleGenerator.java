//package App;
//import java.awt.*;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.List;
//
//class Subject {
//    String name;
//    String day;
//    int startPeriod;
//    int endPeriod;
//    String room;
//    String color;
//
//    public Subject(String name, String day, int startPeriod, int endPeriod, String room, String color) {
//        this.name = name;
//        this.day = day;
//        this.startPeriod = startPeriod;
//        this.endPeriod = endPeriod;
//        this.room = room;
//        this.color = color;
//    }
//}
//
//public class ScheduleGenerator {
//
//
//    public static void main(String[] args) {
//        // Danh sách các môn học (có môn kéo dài nhiều tiết)
//        List<Subject> subjects = Arrays.asList(
//                new Subject("Chương trình dịch", "thu3", 1, 2, "E303", "#FF5733"),
//                new Subject("Công nghệ Web", "thu6", 1, 2, "E112", "#FFCC00"),
//                new Subject("Điện toán đám mây", "thu4", 4, 5, "F406", "#66B3FF"),
//                new Subject("Kinh tế và quản lý doanh nghiệp", "thu5", 8, 10, "F208", "#F39C12"),
//                new Subject("Lập trình mạng", "thu5", 1, 2, "F403", "#2ECC71"),
//                new Subject("Lập trình C", "thu2", 2, 4, "E303", "#9B59B6") // Môn kéo dài nhiều tiết
//        );
//
//        // Tạo HTML (chưa có giá trị ô)
//        StringBuilder htmlContent = new StringBuilder();
//
//        htmlContent.append("<!DOCTYPE html>\n<html lang=\"vi\">\n<head>\n")
//                .append("<meta charset=\"UTF-8\">\n")
//                .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n")
//                .append("<title>Lịch Học</title>\n")
//                .append("<style>\n")
//                .append("table { width: 100%; border-collapse: collapse; }\n")
//                .append("th, td { padding: 10px; border: 1px solid #ddd; text-align: center; }\n")
//                .append("th { background-color: #4CAF50; color: white; }\n")
//                .append("td.empty { background-color: #f0f0f0; }\n")
//                .append(".subject { color: #fff; font-weight: bold; }\n")
//                .append(".lunch-break { background-color: #f39c12; color: white; font-weight: bold; }\n")
//                .append("body {\n" +
//                        "    font-family: Arial, sans-serif;\n" +
//                        "    background-color: #f4f4f9;\n" +
//                        "    margin: 0;\n" +
//                        "    color: #333;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".schedule-container {\n" +
//                        "    max-width: 1200px;\n" +
//                        "    margin: 0 auto;\n" +
//                        "    background: white;\n" +
//                        "    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\n" +
//                        "    border-radius: 10px;\n" +
//                        "    padding: 10px;\n" +
//                        "}\n" +
//                        "\n" +
//                        "h1 {\n" +
//                        "    text-align: center;\n" +
//                        "    color: #4CAF50;\n" +
//                        "    margin: 5px 0px 0px 0px;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".schedule-table {\n" +
//                        "    width: 100%;\n" +
//                        "    border-collapse: collapse;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".schedule-table thead th {\n" +
//                        "    background-color: #4CAF50;\n" +
//                        "    color: white;\n" +
//                        "    text-transform: uppercase;\n" +
//                        "    font-size: 14px;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".schedule-table tbody td {\n" +
//                        "    border: 1px solid #ddd;\n" +
//                        "    height: 40px;\n" +
//                        "    vertical-align: middle;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".schedule-table td.empty {\n" +
//                        "    background-color: #f9f9f9;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".schedule-table td.subject {\n" +
//                        "    font-weight: bold;\n" +
//                        "    color: white;\n" +
//                        "    border-radius: 5px;\n" +
//                        "    text-align: center;\n" +
//                        "}\n" +
//                        "\n" +
//                        ".lunch-break {\n" +
//                        "    background-color: #FFD700;\n" +
//                        "    color: black;\n" +
//                        "    font-style: italic;\n" +
//                        "    font-weight: bold;\n" +
//                        "}\n" +
//                        "\n" +
//                        "@media (max-width: 768px) {\n" +
//                        "    body {\n" +
//                        "        padding: 10px;\n" +
//                        "    }\n" +
//                        "    .schedule-container {\n" +
//                        "        padding: 10px;\n" +
//                        "    }\n" +
//                        "    .schedule-table thead th,\n" +
//                        "    .schedule-table tbody td {\n" +
//                        "        font-size: 12px;\n" +
//                        "    }\n" +
//                        "}\n")
//                .append("</style>\n</head>\n<body>\n")
//                .append("<div class=\"schedule-container\">\n")
//                .append("<h1>Thời khóa biểu Bách Khoa Đà Nẵng</h1>\n")
//                .append("<table class=\"schedule-table\">\n")
//                .append("<thead>\n<tr>\n")
//                .append("<th>Thời gian</th>\n")
//                .append("<th>Thứ 2</th>\n")
//                .append("<th>Thứ 3</th>\n")
//                .append("<th>Thứ 4</th>\n")
//                .append("<th>Thứ 5</th>\n")
//                .append("<th>Thứ 6</th>\n")
//                .append("<th>Thứ 7</th>\n")
//                .append("<th>Chủ nhật</th>\n")
//                .append("</tr>\n</thead>\n<tbody>\n");
//
//        // Mảng giờ học
//        String[] times = {
//                "7:00 - 7:50", "8:00 - 8:50", "9:00 - 9:50", "10:00 - 10:50",
//                "11:00 - 11:50", "12:30 - 13:20", "13:30 - 14:20",
//                "14:30 - 15:20", "15:30 - 16:20", "16:30 - 17:20"
//        };
//
//        // Duyệt qua các giờ học và tạo bảng
//        for (int i = 0; i < times.length; i++) {
//            htmlContent.append("<tr>\n")
//                    .append("<td>").append(times[i]).append("</td>\n");
//
//            // Mảng các ngày trong tuần
//            String[] days = {"thu2", "thu3", "thu4", "thu5", "thu6", "thu7", "chunhat"};
//            for (String day : days) {
//                String cellId = day + "-" + (i + 1);
//                htmlContent.append("<td id=\"" + cellId + "\" class=\"empty\"></td>\n");
//            }
//
//            htmlContent.append("</tr>\n");
//        }
//
//        htmlContent.append("</tbody>\n" +
//                        "<div style=\"font-size: 12px; color: gray; text-align: right;\">\n" +
//                        "\t© <a href=\"https://github.com/chinh-de\" target=\"_blank\" style=\"color: inherit; text-decoration: none; margin-bottom: 5px;\">chinhde</a>\n" +
//                        "</div></table>\n</div>\n")
//
//                // JavaScript script xử lý rowspan và colspan
//                .append("<script>\n")
//                .append("window.onload = function() {\n")
//                .append("  const scheduleData = [\n");
//
//        for(Subject subject : subjects){
//            htmlContent.append("    { name: '").append(subject.name).append("', day: '").append(subject.day)
//                    .append("', startPeriod: ").append(subject.startPeriod).append(", endPeriod: ").append(subject.endPeriod)
//                    .append(", room: '").append(subject.room).append("', color: '").append(subject.color).append("' },\n");
//        }
//
//        htmlContent.append("  ];\n")
//                .append("  scheduleData.forEach(function(schedule) {\n")
//                .append("    period = schedule.startPeriod;\n")
//                .append("      const cellId = schedule.day + '-' + period;\n")
//                .append("      const cell = document.getElementById(cellId);\n")
//                .append("      if (cell) {\n")
//                .append("        cell.innerHTML = schedule.name + '<br>' + schedule.room + '<br>' + 'Hồ Trần Thủy Tiên';\n")
//                .append("        cell.style.backgroundColor = schedule.color;\n")
//                .append("        // Set rowspan for the first cell of the subject\n")
//                .append("        if (period === schedule.startPeriod) {\n")
//                .append("          cell.setAttribute('rowspan', schedule.endPeriod - schedule.startPeriod + 1);\n")
//                .append("          for (let i = schedule.startPeriod + 1; i <= schedule.endPeriod; i++) {\n" +
//                        "            const nextCellId = schedule.day + '-' + i;\n" +
//                        "            const nextCell = document.getElementById(nextCellId);\n" +
//                        "            if (nextCell) {\n" +
//                        "            nextCell.style.display = 'none'; // Hide the subsequent cells\n" +
//                        "            }\n" +
//                        "        }     ")
//                .append("        }\n")
//                .append("      }\n")
//                .append("  });\n")
//                .append("};\n")
//                .append("</script>\n")
//                .append("</body>\n</html>");
//
//        // In ra mã HTML
//        System.out.println(htmlContent.toString());
//
//
//        try {
//            // Ghi nội dung vào file
//            Path filePath = Paths.get("lich_hoc.html");
//            Files.writeString(filePath, htmlContent);
//
//            // Mở file bằng trình duyệt mặc định
//            Desktop desktop = Desktop.getDesktop();
//            if (desktop.isSupported(Desktop.Action.BROWSE)) {
//                desktop.browse(filePath.toUri());
//            } else if (desktop.isSupported(Desktop.Action.OPEN)) {
//                desktop.open(filePath.toFile());
//            } else {
//                System.out.println("Không hỗ trợ mở trình duyệt trên hệ thống này.");
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi khi tạo hoặc mở file: " + e.getMessage());
//        }
//    }
//}
//
