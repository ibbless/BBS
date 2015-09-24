package com.cw.Entity;

import java.util.HashSet;
import java.util.Set;


public class Topic extends Article {
		private String title;
		private Set<Reply> replies = new HashSet<Reply>();

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Set<Reply> getReplies() {
			return replies;
		}

		public void setReplies(Set<Reply> replies) {
			this.replies = replies;
		}
		
}
