package impl;

import inter.ArticleBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

    private ArticleBean articleBean;

    public OwnerInvocationHandler(ArticleBean articleBean){
        this.articleBean = articleBean;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if(method.getName().startsWith("get")){
                return method.invoke(articleBean,args);
            }else if(method.getName().startsWith("setTicket")){
                //作者不能投自己票
                System.out.println("不能给自己的文章投票！");
                throw new IllegalAccessException();
            }else if(method.getName().startsWith("set")){
                return method.invoke(articleBean,args);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
