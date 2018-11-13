package main;

import main.Monsters.Monster;

import java.util.List;

public abstract class Dungeon {
    private List<Monster> monsters;
    private List<Floor> floors;
    private String name;
    private String difficulty;
}
