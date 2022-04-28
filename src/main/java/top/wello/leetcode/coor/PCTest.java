package top.wello.leetcode.coor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by maweihao on 4/6/22
 */
public class PCTest {

    Queue<Object> queue = new ArrayDeque<>();
    final Object o = new Object();
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void testWait() throws InterruptedException {
        synchronized (o) {
            o.wait();
        }
        o.notify();


        condition.await();
        condition.signal();
    }

    public static void main(String[] args) {

    }

    public static class Producer {

    }
}
