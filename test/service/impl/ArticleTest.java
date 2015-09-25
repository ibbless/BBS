package service.impl;

import java.util.List;

import org.junit.Test;

import com.cw.Entity.Article;
import com.cw.Entity.Reply;
import com.cw.Entity.Topic;
import com.cw.Entity.User;
import com.cw.service.ArticleDao;
import com.cw.service.impl.ArticleDaoImpl;

public class ArticleTest {
	ArticleDaoImpl a = new ArticleDaoImpl();

	@Test
	public void Show() {
		List<Article> list = a.getAll();
		System.out.println(list);
	}

	@Test
	public void save(){
		Topic topic = new Topic();
		User user = new User();
		user.setId(1);
		topic.setAuthor(user);
		topic.setContent("nnnnnnnnnnnnnnnnnn");
		a.saveTopic(topic);
	}
	@Test
	public void saveR(){
		Reply r = new Reply();
		User user = new User();
		user.setId(1);
		Topic t = (Topic) a.getAll().get(0);
		r.setAuthor(user);
		r.setContent("sofa~~~~~");
		r.setTopic(t);
		a.saveReply(r);
	}
}
