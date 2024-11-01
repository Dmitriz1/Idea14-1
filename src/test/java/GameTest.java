import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        game = new Game();
        player1 = new Player(1, "Alice", 10);
        player2 = new Player(2, "Bob", 20);
        player3 = new Player(3, "Charlie", 10);
    }

    @Test
    void testRegister() {
        game.register(player1);
        assertEquals(1, game.players.size());
    }

    @Test
    void testRoundPlayer1Wins() {
        game.register(player1);
        game.register(player2);
        assertEquals(1, game.round("Bob", "Alice"));
    }

    @Test
    void testRoundPlayer2Wins() {
        game.register(player2);
        game.register(player3);
        assertEquals(2, game.round("Charlie", "Bob"));
    }

    @Test
    void testRoundDraw() {
        game.register(player1);
        game.register(player3);
        assertEquals(0, game.round("Alice", "Charlie"));
    }

    @Test
    void testRoundPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);
        NotRegisteredException exception = assertThrows(NotRegisteredException.class, () -> {
            game.round("Alice", "Charlie");
        });
        assertEquals("Player Charlie not registered", exception.getMessage());
    }

    @Test
    void testRoundBothPlayersNotRegistered() {
        NotRegisteredException exception1 = assertThrows(NotRegisteredException.class, () -> {
            game.round("Alice", "Bob");
        });
        assertEquals("Player Alice not registered", exception1.getMessage());
    }
}