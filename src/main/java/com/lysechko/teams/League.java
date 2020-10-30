package com.lysechko.teams;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;

    private ArrayList<Team> arrayList = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTeamToTheLeague(T team) {
        if (arrayList.contains(team)) {
            System.out.println(team.getName() + " " + " already in the league.");
        } else {
            arrayList.add(team);
        }
    }

    public void seeLeague() {
        Collections.sort(arrayList);
        for (Team team : arrayList) {
            System.out.println(team);
        }
    }

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }
}
