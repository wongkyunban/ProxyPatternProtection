package impl;


import inter.ArticleBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {

    private ArticleBean article;

    public NonOwnerInvocationHandler(ArticleBean article){
        this.article = article;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try{
            if(method.getName().startsWith("get")){
                return method.invoke(article,args);//对查询是全部提供的
            }else if(method.getName().startsWith("setTicket")){
                return method.invoke(article,args); //对投票方法是开放的
            }else if(method.getName().startsWith("set")){
                throw new IllegalAccessException(); //对于除作者以外的人，其他set方法是关闭的
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
