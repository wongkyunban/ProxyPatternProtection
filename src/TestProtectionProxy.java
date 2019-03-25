import impl.ArticleBeanImpl;
import impl.NonOwnerInvocationHandler;
import impl.OwnerInvocationHandler;
import inter.ArticleBean;

import java.lang.reflect.Proxy;

public class TestProtectionProxy {

    public static void main(String[] args) {

        TestProtectionProxy t = new TestProtectionProxy();
        t.test();
    }

    public void test(){
        ArticleBean articleBean = getActicle();  //获取一篇文章
        ArticleBean ownerProxy = getOwnerProxy(articleBean); //获取文章拥有者的代理
        ArticleBean nonOwnerProxy = getNonOwnerProxy(articleBean);////获取投票人的代理

        //投票人开始投票
        try{
            nonOwnerProxy.setTicket(1);
            String articleN = nonOwnerProxy.getArticleName();
            int num = nonOwnerProxy.getTicket();
            String s = articleN +"已获得：" + num  + "票";
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }


        //文章拥有者投自己一票，会报错，因为不能投自己的
        try{
            ownerProxy.setTicket(1);
        }catch (Exception e){
            System.out.println("不能给自己的文章投票！");
        }

    }



    //文章所有者的代理
    private ArticleBean getOwnerProxy(ArticleBean articleBean){
        ArticleBean ownerProxy = (ArticleBean)Proxy.newProxyInstance(articleBean.getClass().getClassLoader(),articleBean.getClass().getInterfaces(),new OwnerInvocationHandler(articleBean));
        return ownerProxy;
    }

    //投票人的代理
    private ArticleBean getNonOwnerProxy(ArticleBean articleBean){
        ArticleBean nonOwnerProxy = (ArticleBean) Proxy.newProxyInstance(articleBean.getClass().getClassLoader(),articleBean.getClass().getInterfaces(),new NonOwnerInvocationHandler(articleBean));
        return nonOwnerProxy;
    }

    //测试需要
   private ArticleBean getActicle(){
        ArticleBean bean = new ArticleBeanImpl();
        bean.setArticleName("论人文精神的重要性");
        bean.setAuthor("Wongkyunban");
        bean.setGender("Boy");
        bean.setTicket(0);
        return bean;
    }
}
