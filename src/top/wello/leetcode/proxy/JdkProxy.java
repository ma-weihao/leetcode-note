package top.wello.leetcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by maweihao on 4/3/22
 */
public class JdkProxy implements InvocationHandler {

    public static class IInterfaceImpl implements IInterface {

        @Override
        public void doSomething() {
            System.out.println("doSomething");
        }
    }

    private final Object bean;

    public JdkProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        return method.invoke(bean, args);
    }

    public static void main(String[] args) {
        JdkProxy proxy = new JdkProxy(new IInterfaceImpl());
        IInterface iInterface = (IInterface) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{IInterface.class}, proxy);
        iInterface.doSomething();
    }
}
