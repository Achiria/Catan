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

        Dialogs.turnChange(p1);
        
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
