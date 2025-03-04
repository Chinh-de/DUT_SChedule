//package App;
//import org.jsoup.*;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URLEncoder;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        String loginURL = "http://sv.dut.udn.vn/PageDangNhap.aspx";
//        Scanner sc = new Scanner(System.in);
//
//
//        // region payload and header
//
//        //payload
//        String username = "?"; //_ctl0:MainContent:DN_txtAcc
//        String password = "?"; //_ctl0:MainContent:DN_txtPass
//        String __VIEWSTATE = "/wEPDwUKMTY2NjQ1OTEyNA8WAh4TVmFsaWRhdGVSZXF1ZXN0TW9kZQIBFgJmD2QWAgIDDxYCHglpbm5lcmh0bWwFsy48dWwgaWQ9J21lbnUnIHN0eWxlPSd3aWR0aDogMTI4MHB4OyBtYXJnaW46IDAgYXV0bzsgJz48bGk+PGEgSUQ9ICdsUGFIT01FJyBzdHlsZSA9J3dpZHRoOjY1cHgnIGhyZWY9J0RlZmF1bHQuYXNweCc+VHJhbmcgY2jhu6c8L2E+PGxpPjxhIElEPSAnbFBhQ1REVCcgc3R5bGUgPSd3aWR0aDo4NXB4JyBocmVmPScnPkNoxrDGoW5nIHRyw6xuaDwvYT48dWwgY2xhc3M9J3N1Ym1lbnUnPjxsaT48YSBJRCA9J2xDb0NURFRDMicgICBzdHlsZSA9J3dpZHRoOjE0MHB4JyBocmVmPSdHX0xpc3RDVERULmFzcHgnPkNoxrDGoW5nIHRyw6xuaCDEkcOgbyB04bqhbzwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0NURFRDMScgICBzdHlsZSA9J3dpZHRoOjE0MHB4JyBocmVmPSdHX0xpc3RIb2NQaGFuLmFzcHgnPkjhu41jIHBo4bqnbjwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0NURFRDMycgICBzdHlsZSA9J3dpZHRoOjIwMHB4JyBocmVmPSdHX0xpc3RDVERUQW5oLmFzcHgnPlByb2dyYW08L2E+PC9saT48L3VsPjwvbGk+PGxpPjxhIElEPSAnbFBhS0hEVCcgc3R5bGUgPSd3aWR0aDo2MHB4JyBocmVmPScnPkvhur8gaG/huqFjaDwvYT48dWwgY2xhc3M9J3N1Ym1lbnUnPjxsaT48YSBJRCA9J2xDb0tIRFRDMScgICBzdHlsZSA9J3dpZHRoOjIwMHB4JyBocmVmPSdodHRwOi8vZHV0LnVkbi52bi9UcmFuZ0Rhb3Rhby9HaW9pdGhpZXUvaWQvNzM5NSc+S+G6vyBob+G6oWNoIMSRw6BvIHThuqFvIG7Eg20gaOG7jWM8L2E+PC9saT48bGk+PGEgSUQgPSdsQ29LSERUQzInICAgc3R5bGUgPSd3aWR0aDoyMDBweCcgaHJlZj0naHR0cDovL2RrNC5kdXQudWRuLnZuJz7EkMSDbmcga8O9IGjhu41jPC9hPjwvbGk+PGxpPjxhIElEID0nbENvS0hEVEMzJyAgIHN0eWxlID0nd2lkdGg6MjAwcHgnIGhyZWY9J2h0dHA6Ly9kazQuZHV0LnVkbi52bi9HX0xvcEhvY1BoYW4uYXNweCc+TOG7m3AgaOG7jWMgcGjhuqduIC0gxJFhbmcgxJHEg25nIGvDvTwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0tIRFRDNCcgICBzdHlsZSA9J3dpZHRoOjIwMHB4JyBocmVmPSdHX0xvcEhvY1BoYW4uYXNweCc+TOG7m3AgaOG7jWMgcGjhuqduIC0gY2jDrW5oIHRo4bupYzwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0tIRFRDNScgICBzdHlsZSA9J3dpZHRoOjIwMHB4JyBocmVmPSdodHRwOi8vZGs0LmR1dC51ZG4udm4vR19ES3lOaHVDYXUuYXNweCc+S2jhuqNvIHPDoXQgbmh1IGPhuqd1IG3hu58gdGjDqm0gbOG7m3A8L2E+PC9saT48bGk+PGEgSUQgPSdsQ29LSERUQzYnICAgc3R5bGUgPSd3aWR0aDoyMDBweCcgaHJlZj0naHR0cDovL2NiLmR1dC51ZG4udm4vUGFnZUxpY2hUaGlLSC5hc3B4Jz5UaGkgY3Xhu5FpIGvhu7MgbOG7m3AgaOG7jWMgcGjhuqduPC9hPjwvbGk+PGxpPjxhIElEID0nbENvS0hEVEM3JyAgIHN0eWxlID0nd2lkdGg6MjAwcHgnIGhyZWY9J0dfREtUaGlOTi5hc3B4Jz5UaGkgVGnhur9uZyBBbmggxJHhu4tuaCBr4buzLCDEkeG6p3UgcmE8L2E+PC9saT48bGk+PGEgSUQgPSdsQ29LSERUQzgnICAgc3R5bGUgPSd3aWR0aDoyMDBweCcgaHJlZj0nR19MaXN0TGljaFNILmFzcHgnPlNpbmggaG/huqF0IGzhu5twIMSR4buLbmgga+G7szwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0tIRFRDOScgICBzdHlsZSA9J3dpZHRoOjIwMHB4JyBocmVmPSdodHRwOi8vZmIuZHV0LnVkbi52bic+S2jhuqNvIHPDoXQgw70ga2nhur9uIHNpbmggdmnDqm48L2E+PC9saT48bGk+PGEgSUQgPSdsQ29LSERUQzknICAgc3R5bGUgPSd3aWR0aDoyMDBweCcgaHJlZj0nR19ES1BWQ0QuYXNweCc+SG/huqF0IMSR4buZbmcgcGjhu6VjIHbhu6UgY+G7mW5nIMSR4buTbmc8L2E+PC9saT48L3VsPjwvbGk+PGxpPjxhIElEPSAnbFBhVFJBQ1VVJyBzdHlsZSA9J3dpZHRoOjcwcHgnIGhyZWY9Jyc+RGFuaCBzw6FjaDwvYT48dWwgY2xhc3M9J3N1Ym1lbnUnPjxsaT48YSBJRCA9J2xDb1RSQUNVVTAxJyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdE5ndW5nSG9jLmFzcHgnPlNpbmggdmnDqm4gbmfhu6tuZyBo4buNYzwvYT48L2xpPjxsaT48YSBJRCA9J2xDb1RSQUNVVTAzJyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdExvcC5hc3B4Jz5TaW5oIHZpw6puIMSRYW5nIGjhu41jIC0gbOG7m3A8L2E+PC9saT48bGk+PGEgSUQgPSdsQ29UUkFDVVUwNCcgICBzdHlsZSA9J3dpZHRoOjI0MHB4JyBocmVmPSdHX0xpc3RDQ0NOVFQuYXNweCc+U2luaCB2acOqbiBjw7MgY2jhu6luZyBjaOG7iSBDTlRUPC9hPjwvbGk+PGxpPjxhIElEID0nbENvVFJBQ1VVMDUnICAgc3R5bGUgPSd3aWR0aDoyNDBweCcgaHJlZj0nR19MaXN0Q0NOTi5hc3B4Jz5TaW5oIHZpw6puIGPDsyBjaOG7qW5nIGNo4buJIG5nb+G6oWkgbmfhu688L2E+PC9saT48bGk+PGEgSUQgPSdsQ29UUkFDVVUwNicgICBzdHlsZSA9J3dpZHRoOjI0MHB4JyBocmVmPSdodHRwOi8vZGFvdGFvLmR1dC51ZG4udm4vU1YvR19LUXVhQW5oVmFuLmFzcHgnPlNpbmggdmnDqm4gdGhpIFRp4bq/bmcgQW5oIMSR4buLbmgga+G7szwvYT48L2xpPjxsaT48YSBJRCA9J2xDb1RSQUNVVTA3JyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdERvQW5UTi5hc3B4Jz5TaW5oIHZpw6puIGzDoG0gxJDhu5Mgw6FuIHThu5F0IG5naGnhu4dwPC9hPjwvbGk+PGxpPjxhIElEID0nbENvVFJBQ1VVMDgnICAgc3R5bGUgPSd3aWR0aDoyNDBweCcgaHJlZj0nR19MaXN0SG9hbkhvY1BoaS5hc3B4Jz5TaW5oIHZpw6puIMSRxrDhu6NjIGhvw6NuIMSRw7NuZyBo4buNYyBwaMOtPC9hPjwvbGk+PGxpPjxhIElEID0nbENvVFJBQ1VVMTYnICAgc3R5bGUgPSd3aWR0aDoyNDBweCcgaHJlZj0nR19MaXN0SG9hbl9UaGlCUy5hc3B4Jz5TaW5oIHZpw6puIMSRxrDhu6NjIGhvw6NuIHRoaSwgdGhpIGLhu5Ugc3VuZzwvYT48L2xpPjxsaT48YSBJRCA9J2xDb1RSQUNVVTA5JyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdEhvY0xhaS5hc3B4Jz5TaW5oIHZpw6puIGThu7EgdHV54buDbiB2w6BvIGjhu41jIGzhuqFpPC9hPjwvbGk+PGxpPjxhIElEID0nbENvVFJBQ1VVMTAnICAgc3R5bGUgPSd3aWR0aDoyNDBweCcgaHJlZj0nR19MaXN0S3lMdWF0LmFzcHgnPlNpbmggdmnDqm4gYuG7iyBr4bu3IGx14bqtdDwvYT48L2xpPjxsaT48YSBJRCA9J2xDb1RSQUNVVTExJyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdEJpSHV5SFAuYXNweCc+U2luaCB2acOqbiBi4buLIGjhu6d5IGjhu41jIHBo4bqnbjwvYT48L2xpPjxsaT48YSBJRCA9J2xDb1RSQUNVVTEyJyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdExvY2tXZWIuYXNweCc+U2luaCB2acOqbiBi4buLIGtow7NhIHdlYnNpdGU8L2E+PC9saT48bGk+PGEgSUQgPSdsQ29UUkFDVVUxMycgICBzdHlsZSA9J3dpZHRoOjI0MHB4JyBocmVmPSdHX0xpc3RMb2NrV2ViVGFtLmFzcHgnPlNpbmggdmnDqm4gYuG7iyB04bqhbSBraMOzYSB3ZWJzaXRlPC9hPjwvbGk+PGxpPjxhIElEID0nbENvVFJBQ1VVMTQnICAgc3R5bGUgPSd3aWR0aDoyNDBweCcgaHJlZj0nR19MaXN0SGFuQ2hlVEMuYXNweCc+U2luaCB2acOqbiBi4buLIGjhuqFuIGNo4bq/IHTDrW4gY2jhu4kgxJHEg25nIGvDvTwvYT48L2xpPjxsaT48YSBJRCA9J2xDb1RSQUNVVTE1JyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfTGlzdENhbmhCYW9LUUhULmFzcHgnPlNpbmggdmnDqm4gYuG7iyBj4bqjbmggYsOhbyBr4bq/dCBxdeG6oyBo4buNYyB04bqtcDwvYT48L2xpPjwvdWw+PC9saT48bGk+PGEgSUQ9ICdsUGFDVVVTVicgc3R5bGUgPSd3aWR0aDo4OHB4JyBocmVmPScnPkPhu7F1IHNpbmggdmnDqm48L2E+PHVsIGNsYXNzPSdzdWJtZW51Jz48bGk+PGEgSUQgPSdsQ29DVVVTVjEnICAgc3R5bGUgPSd3aWR0aDoxMTBweCcgaHJlZj0nR19MaXN0VE5naGllcC5hc3B4Jz7EkMOjIHThu5F0IG5naGnhu4dwPC9hPjwvbGk+PGxpPjxhIElEID0nbENvQ1VVU1YyJyAgIHN0eWxlID0nd2lkdGg6MTEwcHgnIGhyZWY9J0dfTGlzdEtob25nVE4uYXNweCc+S2jDtG5nIHThu5F0IG5naGnhu4dwPC9hPjwvbGk+PC91bD48L2xpPjxsaT48YSBJRD0gJ2xQYUNTVkMnIHN0eWxlID0nd2lkdGg6MTQ1cHgnIGhyZWY9Jyc+UGjDsm5nIGjhu41jICYgSOG7hyB0aOG7kW5nPC9hPjx1bCBjbGFzcz0nc3VibWVudSc+PGxpPjxhIElEID0nbENvQ1NWQzAxJyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J2h0dHA6Ly9jYi5kdXQudWRuLnZuL1BhZ2VDTlBob25nSG9jLmFzcHgnPlTDrG5oIGjDrG5oIHPhu60gZOG7pW5nIHBow7JuZyBo4buNYzwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0NTVkMwMicgICBzdHlsZSA9J3dpZHRoOjI0MHB4JyBocmVmPSdHX0xpc3RUaEJpSG9uZy5hc3B4Jz5UaOG7kW5nIGvDqiBiw6FvIHRoaeG6v3QgYuG7iyBwaMOybmcgaOG7jWMgaOG7j25nPC9hPjwvbGk+PGxpPjxhIElEID0nbENvQ1NWQzA5JyAgIHN0eWxlID0nd2lkdGg6MjQwcHgnIGhyZWY9J0dfU3lzU3RhdHVzLmFzcHgnPlRy4bqhbmcgdGjDoWkgaOG7hyB0aOG7kW5nIHRow7RuZyB0aW4gc2luaCB2acOqbjwvYT48L2xpPjwvdWw+PC9saT48bGk+PGEgSUQ9ICdsUGFMSUVOS0VUJyBzdHlsZSA9J3dpZHRoOjUwcHgnIGhyZWY9Jyc+TGnDqm4ga+G6v3Q8L2E+PHVsIGNsYXNzPSdzdWJtZW51Jz48bGk+PGEgSUQgPSdsQ29MSUVOS0VUMScgICBzdHlsZSA9J3dpZHRoOjcwcHgnIGhyZWY9J2h0dHA6Ly9saWIuZHV0LnVkbi52bic+VGjGsCB2aeG7h248L2E+PC9saT48bGk+PGEgSUQgPSdsQ29MSUVOS0VUMicgICBzdHlsZSA9J3dpZHRoOjcwcHgnIGhyZWY9J2h0dHA6Ly9sbXMxLmR1dC51ZG4udm4nPkRVVC1MTVM8L2E+PC9saT48L3VsPjwvbGk+PGxpPjxhIElEPSAnbFBhSEVMUCcgc3R5bGUgPSd3aWR0aDo0NXB4JyBocmVmPScnPkjhu5cgdHLhu6M8L2E+PHVsIGNsYXNzPSdzdWJtZW51Jz48bGk+PGEgSUQgPSdsQ29IRUxQMScgICBzdHlsZSA9J3dpZHRoOjIxMHB4JyBocmVmPSdodHRwOi8vZnIuZHV0LnVkbi52bic+Q+G7lW5nIGjhu5cgdHLhu6MgdGjDtG5nIHRpbiB0cuG7sWMgdHV54bq/bjwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0hFTFAyJyAgIHN0eWxlID0nd2lkdGg6MjEwcHgnIGhyZWY9J2h0dHBzOi8vMWRydi5tcy91L3MhQXR3S2xEWjZWcWJ0cUVvRU9lNEROeHY1LWVRND9lVWJ4Sm5xJz5IxrDhu5tuZyBk4bqrbiDEkMSDbmcga8O9IGjhu41jPC9hPjwvbGk+PGxpPjxhIElEID0nbENvSEVMUDMnICAgc3R5bGUgPSd3aWR0aDoyMTBweCcgaHJlZj0naHR0cHM6Ly8xZHJ2Lm1zL3UvcyFBdHdLbERaNlZxYnRxRW9FT2U0RE54djUtZVE0P2VVYnhKbnEnPkjGsOG7m25nIGThuqtuIFPhu60gZOG7pW5nIEVtYWlsIERVVDwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0hFTFA3JyAgIHN0eWxlID0nd2lkdGg6MjEwcHgnIGhyZWY9J2h0dHBzOi8vMWRydi5tcy91L3MhQXR3S2xEWjZWcWJ0bzEwYmhIYzBLN3NleU5Hcj9lYUNUYjh4Jz5WxINuIGLhuqNuIFF1eSDEkeG7i25oIGPhu6dhIFRyxrDhu51uZzwvYT48L2xpPjxsaT48YSBJRCA9J2xDb0hFTFA4JyAgIHN0eWxlID0nd2lkdGg6MjEwcHgnIGhyZWY9J2h0dHBzOi8vZG9jcy5nb29nbGUuY29tL2RvY3VtZW50L2QvMVhFaC1jbGhhNnlueUdyaDVNQWpIZU4wWDIwRDVJWHp5L2VkaXQ/dXNwc2hhcmluZyZvdWlkMTA3MTI5OTI2NDYxOTQxNzgwOTY1JnJ0cG9mdHJ1ZSZzZHRydWUnPkJp4buDdSBt4bqrdSB0aMaw4budbmcgZMO5bmc8L2E+PC9saT48L3VsPjwvbGk+PGxpPjxhIGlkID0nbGlua0RhbmdOaGFwJyBocmVmPSdQYWdlRGFuZ05oYXAuYXNweCcgc3R5bGUgPSd3aWR0aDo4MHB4Oyc+IMSQxINuZyBuaOG6rXAgPC9hPjwvbGk+PGxpPjxkaXYgY2xhc3M9J0xvZ2luRnJhbWUnPjxkaXYgc3R5bGUgPSdtaW4td2lkdGg6IDEwMHB4Oyc+PC9kaXY+PC9kaXY+PC9saT48L3VsPmRkZ2G7p/OyRxunj/aUj5Xfzj1LPgwQL3iQNh+sZulKJtg=";
//        String __VIEWSTATEGENERATOR = "20CC0D2F";
//        String btnlogin = "Đăng nhập"; //_ctl0:MainContent:QLTH_btnLogin
//
//        String dataLogin = "__VIEWSTATE=" + URLEncoder.encode(__VIEWSTATE, StandardCharsets.UTF_8)
//                + "&__VIEWSTATEGENERATOR=" + URLEncoder.encode(__VIEWSTATEGENERATOR, StandardCharsets.UTF_8)
//                + "&_ctl0:MainContent:DN_txtAcc=" + URLEncoder.encode(username, StandardCharsets.UTF_8)
//                + "&_ctl0:MainContent:DN_txtPass=" + URLEncoder.encode(password, StandardCharsets.UTF_8)
//                + "&_ctl0:MainContent:QLTH_btnLogin=" + URLEncoder.encode(btnlogin, StandardCharsets.UTF_8);
//
//        //header
//        String userAgent= "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0";
//        String contentType = "application/x-www-form-urlencoded";
//        //endregion
//
//        // Tạo client
//        HttpClient client = HttpClient.newHttpClient();
//
//        // Tạo request
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI(loginURL))
//                .header("Content-Type", contentType)
//                .header("User-Agent", userAgent)
//                .POST(HttpRequest.BodyPublishers.ofString(dataLogin))
//                .build();
//
//        // Gửi request và nhận response
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Lấy cookie đã login
//        String cookie = response.headers().firstValue("Set-Cookie").orElse("");
//        System.out.println("Cookie: " + cookie);
//
//
//
//
//
//
//        //Lấy thời khóa biểu bằng cookie
//        HttpRequest scheduleRequest = HttpRequest.newBuilder()
//                .uri(new URI("http://sv.dut.udn.vn/PageLichTH.aspx"))
//                .header("Content-Type", contentType)
//                .header("User-Agent", userAgent)
//                .header("Cookie", cookie)
//                .GET()
//                .build();
//        HttpResponse<String> response2 = client.send(scheduleRequest, HttpResponse.BodyHandlers.ofString());
//
//        // In kết quả
//
//        System.out.println("Status Code: " + response2.statusCode());
//        //System.out.println("Response Body: " + response2.body());
//
//        String htmlSchedule = response2.body().toString();
//
//
//        Document doc = Jsoup.parse(htmlSchedule);
//        // Lấy tất cả các dòng trong bảng
//        //Elements rows = doc.select("table.tb-lop tbody tr");
//        Element allSubject = doc.getElementById("TTKB_GridInfo");
//        Elements subjects = allSubject.getElementsByClass("GridRow");
//        for (int sub = 0; sub < subjects.size()-1; sub++) {
//            Element subject = subjects.get(sub);
//            Elements cells = subject.getElementsByTag("td");
//            for (int i = 0; i < cells.size(); i++) {
//                switch (i){
//                    case 1:
//                        System.out.println("Mã: "+ cells.get(i).text());
//                        break;
//                    case 2:
//                        System.out.println("Tên: "+ cells.get(i).text());
//                        break;
//                    case 3:
//                        System.out.println("Tín: "+ cells.get(i).text());
//                        break;
//                    case 6:
//                        System.out.println("Giảng viên: "+ cells.get(i).text());
//                        break;
//                    case 7:
//                        String TKB = cells.get(i).text();
//                        String ClassSessions[] = cells.get(i).text().split(";");
//                        for (String ClassSession : ClassSessions) {
//                            String items[] = ClassSession.split(",");
//                            String thu = items[0];
//                            String tietbatdau =  items[1].split("-")[0];
//                            String tietketthuc =  items[1].split("-")[1];
//                            String phong = items[2];
//
//                            System.out.println("Thu: " + thu);
//                            System.out.println("Tietbatdau: " + tietbatdau);
//                            System.out.println("Tietketthuc: " + tietketthuc);
//                            System.out.println("Phong: " + phong);
//                        }
//
//                        System.out.println("TKB: "+ cells.get(i).text());
//                        break;
//                    case 8:
//                        System.out.println("Tuần: "+ cells.get(i).text());
//                        break;
//
//                }
//            }
//        }
//
//
//
//        String semesterCode = "2420";
//
//        // URL API
//        String url = "http://sv.dut.udn.vn/PageLichTH.aspx/WebAjax/evLopHP_Load.aspx?E=TTKBLoad&Code=" + semesterCode;
//
//        // Tạo yêu cầu POST
//        HttpRequest request3 = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type", contentType)
//                .header("User-Agent", userAgent)
//                .header("Cookie", cookie)
//                .POST(HttpRequest.BodyPublishers.noBody()) // Không gửi body, chỉ URL
//                .build();
//
//        // Gửi yêu cầu và nhận phản hồi
//        HttpResponse<String> response3 = client.send(request3, HttpResponse.BodyHandlers.ofString());
//
//        // In dữ liệu trả về
//        System.out.println(response3.body());
//
//
//        htmlSchedule = response3.body().toString();
//
//
//        doc = Jsoup.parse(htmlSchedule);
//        // Lấy tất cả các dòng trong bảng
//        //Elements rows = doc.select("table.tb-lop tbody tr");
//        allSubject = doc.getElementById("TTKB_GridInfo");
//        subjects = allSubject.getElementsByClass("GridRow");
//        for (int sub = 0; sub < subjects.size()-1; sub++) {
//            Element subject = subjects.get(sub);
//            Elements cells = subject.getElementsByTag("td");
//            for (int i = 0; i < cells.size(); i++) {
//                switch (i){
//                    case 1:
//                        System.out.println("Mã: "+ cells.get(i).text());
//                        break;
//                    case 2:
//                        System.out.println("Tên: "+ cells.get(i).text());
//                        break;
//                    case 3:
//                        System.out.println("Tín: "+ cells.get(i).text());
//                        break;
//                    case 6:
//
//                        System.out.println("Giảng viên: "+ cells.get(i).text());
//                        break;
//                    case 7:
//                        String TKB = cells.get(i).text();
//                        String ClassSessions[] = cells.get(i).text().split(";");
//                        for (String ClassSession : ClassSessions) {
//                            String items[] = ClassSession.split(",");
//                            String thu = items[0];
//                            String tietbatdau =  items[1].split("-")[0];
//                            String tietketthuc =  items[1].split("-")[1];
//                            String phong = items[2];
//
//                            System.out.println("Thu: " + thu);
//                            System.out.println("Tietbatdau: " + tietbatdau);
//                            System.out.println("Tietketthuc: " + tietketthuc);
//                            System.out.println("Phong: " + phong);
//                        }
//
//                        System.out.println("TKB: "+ cells.get(i).text());
//                        break;
//                    case 8:
//                        System.out.println("Tuần: "+ cells.get(i).text());
//                        break;
//
//                }
//            }
//        }
//
//    }
//
//
//
//
//
//}
