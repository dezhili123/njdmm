package com.dmm.demo;

public interface Player {

    /**
     * 用户名。
     * @return
     */
    String getUsername();

    /**
     * 向玩家发送消息。
     * @param message
     */
    void write(String message);


    /**
     * 玩家是否掉线。
     * @return
     */
    boolean isOffline();
}
