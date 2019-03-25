package impl;

import inter.ArticleBean;

public class ArticleBeanImpl implements ArticleBean {

    private String author;
    private String gender;
    private String articleName;
    private int ticket = 0;

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getArticleName() {
        return articleName;
    }

    @Override
    public int getTicket() {
        return ticket;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    @Override
    public void setTicket(int ticket) {
        this.ticket = this.ticket + ticket;
    }
}
