package com.lysechko;

import com.lysechko.players.BasketballPlayer;
import com.lysechko.players.FootballPlayer;

import com.lysechko.teams.League;
import com.lysechko.teams.Team;

public class Main {
    public static void main(String[] args) {
        Team<FootballPlayer> ball = new Team<>("Ball");
        Team<FootballPlayer> risk = new Team<>("Risk");
        Team<FootballPlayer> strike = new Team<>("Strike");

        ball.matchResult(risk, 4, 2);
        risk.matchResult(ball, 3, 5);
        strike.matchResult(ball, 3, 2);

        Team<BasketballPlayer> basket = new Team<>("Basket");
        Team<BasketballPlayer> like = new Team<>("Like");
        Team<BasketballPlayer> team = new Team<>("Team");

        basket.matchResult(team, 25, 13);
        team.matchResult(like, 15, 10);
        like.matchResult(basket, 15, 15);

        League<Team<FootballPlayer>> footballLeague = new League<>("Football League");
        footballLeague.addTeamToTheLeague(ball);
        footballLeague.addTeamToTheLeague(risk);
        footballLeague.addTeamToTheLeague(strike);
        System.out.println("========Football League===============");
        footballLeague.seeLeague();

        League<Team<BasketballPlayer>> basketballLeague = new League<>("Basketball League");
        basketballLeague.addTeamToTheLeague(basket);
        basketballLeague.addTeamToTheLeague(like);
        basketballLeague.addTeamToTheLeague(team);
        System.out.println("========Basketball League===============");
        basketballLeague.seeLeague();
    }
}
