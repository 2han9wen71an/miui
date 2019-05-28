package cn.xtboke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *	过滤html标签只留a标签，并且取出href中的链接
 */
public class HTMLSpirit {

	public static List<String> delHTMLTag(String htmlStr) {
		String regex = "<a.*?/a>";
		List<String> al = new ArrayList<String>();
		Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(htmlStr);
        while(mt.find()){
        	String s3 = "href=\"(.*?)\"";
            Pattern pt3=Pattern.compile(s3);
            Matcher mt3=pt3.matcher(mt.group());
            while(mt3.find())
            {
                String u=mt3.group().replaceAll("href=|>","");
                al.add(u);
            }
        }
        for (int i = 0; i < al.size(); i++) {
			if(!al.get(i).contains("thread-")){
				al.remove(i);
				i--;
			}
		}
        for (int i = 0; i < al.size(); i++) {
        	if(!al.get(i).contains("http")){
				al.set(i, "http://www.miui.com/" + al.get(i).replace("\"", ""));
			}
		}
        Set<String> urlList = new HashSet<>(al);
        al = new ArrayList<>(urlList);
		return al; // 返回文本字符串
	}
	
	public static List<String> delArticleHTMLTag(String htmlStr) {
		String regex = "<td class=\"t_f\" .*?/td>";
		List<String> al = new ArrayList<String>();
		Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(htmlStr);
        while(mt.find())
        {
            String u=mt.group();
            al.add(u);
        }
        for (int i = 0; i < al.size(); i++) {
			if(!al.get(i).contains("postmessage") || al.get(i).contains("发表于") || al.get(i).contains("设备") || al.get(i).contains("地点")){
				al.remove(i);
				i--;
			}
		}
        for (int i = 0; i < al.size(); i++) {
        	String delTag = delTag(al.get(i));
        	al.set(i, delTag);
		}
		return al; // 返回文本字符串
	}
	
	static String delTag(String htmlStr){
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 
        return htmlStr.trim(); //返回文本字符串 
	}

}
