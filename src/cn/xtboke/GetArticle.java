package cn.xtboke;

import java.util.List;
import java.util.Random;

public class GetArticle extends Thread {
	
	public static void main(String[] args) throws Exception {
		// 第一百页开始获取，防止第一页最后回复全是本人名字被发现
		Integer page = 500;
		while (true) {
			String url = "http://www.miui.com/forum.php?mod=forumdisplayall&page=" + page;
			String sendGet = HttpRequest.sendGet(url);
			List<String> taga = HTMLSpirit.delHTMLTag(sendGet);
			for (int i = 0; i < taga.size(); i++) {
				// 随机索引，选择自动回复内容数组的索引
				String articleId = null;
				taga.set(i, taga.get(i).replace("\"", ""));
				articleId = taga.get(i).substring(taga.get(i).indexOf("-") + 1);
				articleId = articleId.substring(0, articleId.indexOf("-"));
				String sendMessageUrl = "http://www.miui.com/forum.php?mod=post&action=reply&fid=38&tid="+articleId+"&extra=page%3D1&replysubmit=yes&infloat=yes&handlekey=fastpost&inajax=1";
				List<String> messages = HTMLSpirit.delArticleHTMLTag(HttpRequest.sendGet("http://www.miui.com/thread-" + articleId + "-1-1.html"));
				System.out.println(new Random().nextInt(messages.size()));
				int index = new Random().nextInt(messages.size());
				//&formhash=d479c513:315c974d改成你自己的
				String param = "&message=" + messages.get(index) + "&posttime=" + System.currentTimeMillis() + "&formhash=d479c513:315c974d&usesig=1&subject";
				String sendPost = HttpRequest.sendPost(sendMessageUrl, param);
				// 输出回复后的内容
				System.out.println(sendPost);
				// 页数+
				page++;
				// 间隔十五秒才能回复
				sleep(60000 + (new Random().nextInt(60*1000)));
			}
		}
	}
	
}
