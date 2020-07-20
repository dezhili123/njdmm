package com.dmm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Gamers implements PlayerManager {

    @Autowired
    private RedisTemplate redisTemplate;

    Map<String,Player> concurrentHashMap =new ConcurrentHashMap();

    @Override
    public void addPlayer(Player player) {
        if(player ==null || player.getUsername() ==null){
            return;
        }
        //加锁
        if(redisTemplate.opsForValue().setIfAbsent(player.getUsername(),0)){
            redisTemplate.expire(player.getUsername(),2, TimeUnit.SECONDS);
        }
        //判断当前用户是否在线
        Player player1 = concurrentHashMap.get(player.getUsername());
        if(player1 == null){
            concurrentHashMap.put(player.getUsername(),player);
        }
    }

    @Override
    public Player getPlayer(String username) {
        return concurrentHashMap.get(username);
    }

    @Override
    public void broadcast(String message) {
        for(Player player : concurrentHashMap.values()){
            player.write(message);
        }
    }
}
