package me.Tazsjah.Data;

public enum GameState {

    WAITING, COUNTING, GAME, GUARD_WIN, PIRATE_WIN, END;

    private static GameState state;

    public static void setState(GameState state) {
        GameState.state = state;
    }

    public static boolean isState(GameState state) {
        return GameState.state == state;
    }

    public static GameState getState() {
        return state;
    }

}
