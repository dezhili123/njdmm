package com.dmm.game;

import com.dmm.demo.Gamers;
import com.dmm.demo.Player;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameApplicationTests {

    @Test
    void contextLoads() {
        Gamers gamers = new Gamers();
        Player player = new Player() {
            @Override
            public String getUsername() {
                return "testPlayer";
            }

            @Override
            public void write(String message) {

            }

            @Override
            public boolean isOffline() {
                return false;
            }
        };

        gamers.addPlayer(player);
    }

}
