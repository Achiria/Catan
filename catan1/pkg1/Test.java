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
package catan1.pkg1;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Test
{
    static Player playerTurn;
    static DrawTable gui = new DrawTable();

    public static void main(String[] args) throws invalidLocationException, InterruptedException
    {
        Player p1 = new Player("Anthony", Color.BLUE);
        Player p2 = new Player("Donovon", Color.ORANGE);
        Player p3 = new Player("Andrew", Color.RED);
        Player p4 = new Player("Brian", Color.WHITE);

        int turn = 0;

        Board thingy = new Board();

        while (p1.getPoints() < 10 && p2.getPoints() < 10 && p3.getPoints() < 10 && p4.getPoints() < 10)
        {
            Actions.setEnd(false);
            if (turn % 4 == 0)
            {
                playerTurn = p1;
            }

            else if (turn % 4 == 1)
            {
                playerTurn = p2;
            }

            else if (turn % 4 == 2)
            {
                playerTurn = p3;
            }

            else
            {
                playerTurn = p4;
            }

            System.out.println(playerTurn.getName() + "'s turn.");

            while (Actions.turnEnd() == false)
            {
                TimeUnit.MILLISECONDS.sleep(1);
                if (Actions.turnEnd() == true)
                {
                    gui.checkTable();
                    turn++;

                    System.out.println("Turn end");
                    break;
                }
            }
        }
    }
}
