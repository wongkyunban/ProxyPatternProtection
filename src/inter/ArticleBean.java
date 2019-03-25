package inter;

public interface ArticleBean {
    String getAuthor();
    String getGender();
    String getArticleName();
    int getTicket();

    void setAuthor(String author);
    void setGender(String gender);
    void setArticleName(String articleName);
    void setTicket(int ticket);
}
