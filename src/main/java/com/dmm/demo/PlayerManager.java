package com.dmm.demo;

public interface PlayerManager {

    /**
     * 增加一个玩家对象
     * @param player
     */
    void addPlayer(Player player);


    /**
     * 根据用户名获取玩家对象。
     * @param username
     * @return
     */
    Player getPlayer(String username);

    /**
     * 向系统中的所有玩家广播一条消息
     * @param message
     */
    void broadcast(String message);
}
