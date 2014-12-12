/*
 * Copyright (C) 2014 Anthony
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package catan.pkg1;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Test
{
//    static Player playerTurn;

    static DrawTable gui = new DrawTable();

    static Player p1;
    static Player p2;
    static Player p3;
    static Player p4;

    public static void main(String[] args) throws invalidLocationException, InterruptedException
    {
        p1 = new Player("Anthony", Color.BLUE);
        p2 = new Player("Donovon", Color.ORANGE);
        p3 = new Player("Andrew", Color.RED);
        p4 = new Player("Brian", Color.WHITE);

        Board thingy = new Board();

//        int[] rolls = new int[4];
//
//        Dialogs.positionRoll();
//
//        Dialogs.tellRoll(p1);
//        rolls[0] = Actions.roll();
//        Dialogs.tellRoll(p2);
//        rolls[1] = Actions.roll();
//        Dialogs.tellRoll(p3);
//        rolls[2] = Actions.roll();
//        Dialogs.tellRoll(p4);
//        rolls[3] = Actions.roll();
//
//        int biggestRoll = rolls[0];
//
//        for (int i = 1; i < rolls.length; i++)
//        {
//            if (rolls[i] > biggestRoll)
//            {
//                biggestRoll = rolls[i];
//            }
//        }
//
//        int startPlayer;
//
//        if (biggestRoll == rolls[0])
//        {
//            Dialogs.firstRoll(p1);
//            Turn.turnSet(0);
//            startPlayer = 0;
//        }
//
//        else if (biggestRoll == rolls[1])
//        {
//            Dialogs.firstRoll(p2);
//            Turn.turnSet(1);
//            startPlayer = 1;
//        }
//
//        else if (biggestRoll == rolls[2])
//        {
//            Dialogs.firstRoll(p3);
//            Turn.turnSet(2);
//            startPlayer = 2;
//        }
//
//        else
//        {
//            Dialogs.firstRoll(p4);
//            Turn.turnSet(3);
//            startPlayer = 3;
//        }
//
//        for (int i = 0; i < 4; i++)
//        {
//            p1.addHand(i, 2);
//            p2.addHand(i, 2);
//            p3.addHand(i, 2);
//            p4.addHand(i, 2);
//        }
//
//        for (int i = startPlayer; i < 4; i++)
//        {
//            String input = Dialogs.buildPlace();
//            input = input.trim();
//            int xPoint = Integer.parseInt(input.substring(0, 1));
//            int yPoint = Integer.parseInt(input.substring(2, 3));
//            String inter = input.substring(4, input.length());
//            Tile t = Board.table[xPoint][yPoint];
//            Turn.getPlayer().buildSettlement(t.getX(), t.getY(), inter);
//            DrawTable.checkTable();
//            Turn.turnEnded();
//        }
//
//        for (int i = 0; i < startPlayer; i++)
//        {
//            String input = Dialogs.buildPlace();
//            input = input.trim();
//            int xPoint = Integer.parseInt(input.substring(0, 1));
//            int yPoint = Integer.parseInt(input.substring(2, 3));
//            String inter = input.substring(4, input.length());
//            Tile t = Board.table[xPoint][yPoint];
//            Turn.getPlayer().buildSettlement(t.getX(), t.getY(), inter);
//            DrawTable.checkTable();
//            Turn.turnEnded();
//        }
//
//        for (int i = startPlayer; i >= 0; i--)
//        {
//            String input = Dialogs.buildPlace();
//            input = input.trim();
//            int xPoint = Integer.parseInt(input.substring(0, 1));
//            int yPoint = Integer.parseInt(input.substring(2, 3));
//            String inter = input.substring(4, input.length());
//            Tile t = Board.table[xPoint][yPoint];
//            Turn.getPlayer().buildSettlement(t.getX(), t.getY(), inter);
//            DrawTable.checkTable();
//            Turn.turnEnded();
//        }
//
//        for (int i = 3; i > startPlayer; i--)
//        {
//            String input = Dialogs.buildPlace();
//            input = input.trim();
//            int xPoint = Integer.parseInt(input.substring(0, 1));
//            int yPoint = Integer.parseInt(input.substring(2, 3));
//            String inter = input.substring(4, input.length());
//            Tile t = Board.table[xPoint][yPoint];
//            Turn.getPlayer().buildSettlement(t.getX(), t.getY(), inter);
//            DrawTable.checkTable();
//            Turn.turnEnded();
//        }

        while (p1.getPoints() < 10
                && p2.getPoints() < 10
                && p3.getPoints() < 10
                && p4.getPoints() < 10)
        {
            Actions.setEnd(false);

            while (Actions.turnEnd() == false)
            {
                TimeUnit.MILLISECONDS.sleep(1);
                if (Actions.turnEnd() == true)
                {
                    gui.checkTable();
                    Turn.turnEnded();

                    break;
                }
            }
        }

        if (p1.getPoints() >= 10)
        {
            Dialogs.gameOver(p1);
        }

        else if (p2.getPoints() >= 10)
        {
            Dialogs.gameOver(p2);
        }

        else if (p3.getPoints() >= 10)
        {
            Dialogs.gameOver(p3);
        }

        else if (p4.getPoints() >= 10)
        {
            Dialogs.gameOver(p4);
        }
    }
}
