package com.lysechko.teams;

import com.lysechko.players.Player;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int playedGame = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println("Player " + player.getName() + " already of the team");
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked to the team " + this.name);
        }
    }

    public int numPlayer() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }
        playedGame++;
        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> o) {
        if (this.ranking() > o.ranking()) {
            return -1;
        } else if (this.ranking() < o.ranking()) {
            return 1;
        } else
            return 0;
    }

    @Override
    public String toString() {
        return "Team [" +
                "name ='" + name + '\'' +
                ", played game = " + playedGame +
                ", won = " + won +
                ", lost = " + lost +
                ", tied = " + tied +
                ", ranking = " + this.ranking() +
                ']';
    }
}