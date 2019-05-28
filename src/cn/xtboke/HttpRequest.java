package cn.xtboke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class HttpRequest {

	static String sendGet(String url) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		URL realUrl = new URL(url);
		URLConnection con = realUrl.openConnection();
		con.setRequestProperty("accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		con.setRequestProperty("connection", "Keep-Alive");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate");
		con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
		con.setRequestProperty("Cache-Control", "max-age=0");
		con.setRequestProperty("Cookie",
				"UM_distinctid=16a0063695e395-0b79fe38edc1f7-7a1437-1fa400-16a0063695f386; Hm_lvt_3c5ef0d4b3098aba138e8ff4e86f1329=1554784677; __utma=230417408.1327665378.1554784677.1554784677.1554784677.1; __utmc=230417408; __utmz=230417408.1554784677.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); MIUI_2132_saltkey=K34JTtTt; MIUI_2132_lastvisit=1554781077; CNZZDATA30049650=cnzz_eid%3D1467917469-1554782691-http%253A%252F%252Fwww.miui.com%252F%26ntime%3D1554782691; MIUI_2132_ulastactivity=600dGN6lorlhyltQx3sXggs34jfT8GSUE6zQaf1hx3mfqk4lyO06NuE; MIUI_2132_auth=b510hzQk0DfKIgm7G%2FMzi1NVplWoSnJO7AC7n2g2rqH1V8LcL3%2FFjR4; lastLoginTime=f005olw1f8Av3AEcVxZpnpEa%2FW4%2FauPve7StrPcwyPvtsAIdvX8A; MIUI_2132_visitedfid=519D399D49D37; MIUI_2132_smile=3D1; MIUI_2132_home_diymode=1; MIUI_2132_forum_lastvisit=D_49_1554784739D_399_1554784767D_519_1554785169; MIUI_2132_viewid=tid_2104011; CNZZDATA2441309=cnzz_eid%3D272252395-1554782468-%26ntime%3D1554783588; __utmt=1; MIUI_2132_checkpm=1; MIUI_2132_sendmail=1; MIUI_2132_lastact=1554787062%09forum.php%09; __utmb=230417408.86.10.1554784677; Hm_lpvt_3c5ef0d4b3098aba138e8ff4e86f1329=1554787064");
		con.setRequestProperty("Host", "www.miui.com");
		con.setRequestProperty("Referer", "http://www.miui.com/index.html");
		con.setRequestProperty("Upgrade-Insecure-Requests", "1");
		con.setRequestProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3610.2 Safari/537.36");
		con.setDoOutput(true);
		con.setDoInput(true);
		out = new PrintWriter(con.getOutputStream());
		out.flush();
		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
		return result;
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
			conn.setRequestProperty("Cache-Control", "max-age=0");
			conn.setRequestProperty("Cookie",
					"UM_distinctid=16a0063695e395-0b79fe38edc1f7-7a1437-1fa400-16a0063695f386; Hm_lvt_3c5ef0d4b3098aba138e8ff4e86f1329=1554784677; __utma=230417408.1327665378.1554784677.1554784677.1554784677.1; __utmc=230417408; __utmz=230417408.1554784677.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); MIUI_2132_saltkey=K34JTtTt; MIUI_2132_lastvisit=1554781077; CNZZDATA30049650=cnzz_eid%3D1467917469-1554782691-http%253A%252F%252Fwww.miui.com%252F%26ntime%3D1554782691; MIUI_2132_ulastactivity=600dGN6lorlhyltQx3sXggs34jfT8GSUE6zQaf1hx3mfqk4lyO06NuE; MIUI_2132_auth=b510hzQk0DfKIgm7G%2FMzi1NVplWoSnJO7AC7n2g2rqH1V8LcL3%2FFjR4; lastLoginTime=f005olw1f8Av3AEcVxZpnpEa%2FW4%2FauPve7StrPcwyPvtsAIdvX8A; MIUI_2132_visitedfid=519D399D49D37; MIUI_2132_smile=3D1; MIUI_2132_home_diymode=1; MIUI_2132_forum_lastvisit=D_49_1554784739D_399_1554784767D_519_1554785169; MIUI_2132_viewid=tid_2104011; CNZZDATA2441309=cnzz_eid%3D272252395-1554782468-%26ntime%3D1554783588; __utmt=1; MIUI_2132_checkpm=1; MIUI_2132_sendmail=1; MIUI_2132_lastact=1554787062%09forum.php%09; __utmb=230417408.86.10.1554784677; Hm_lpvt_3c5ef0d4b3098aba138e8ff4e86f1329=1554787064");
			conn.setRequestProperty("Host", "www.miui.com");
			conn.setRequestProperty("Referer", "http://www.miui.com/index.html");
			conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
			conn.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3610.2 Safari/537.36");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义 BufferedReader输入流来读取URL的响应
			Reader reader = null;
			if ("gzip".equals(conn.getContentEncoding())) {
				in = new BufferedReader(new InputStreamReader(new GZIPInputStream(conn.getInputStream())));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
