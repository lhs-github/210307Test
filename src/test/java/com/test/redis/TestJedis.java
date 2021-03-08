package com.test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedis {

    @Test
    public void TestJedis01() {

        // 1.创建Jedis对象, 指定ip和端口
        Jedis jedis = new Jedis("192.168.1.173",6379);
        // 2.使用jedis操作数据库, 每一个命令对应一个方法
        String name = jedis.get("name");
        // 3.打印输出
        System.out.println(name);
        // 4.关闭Jedis
        jedis.close();
    }

    @Test
    public void TestJedisPool() {

        // 1.创建JedisPool对象, 指定ip和端口号
        JedisPool jedisPool = new JedisPool("192.168.1.173",6379);
        // 2.从JedisPool池中获取一个Jedis对象
        Jedis jedis = jedisPool.getResource();
        // 3.使用jedis操作数据库
        String name = jedis.get("name");
        // 4.打印输出
        System.out.println(name);
        // 5.关闭资源
        jedis.close();
        jedisPool.close();

    }

}
