/*
 * Copyright (C) 2014 Anthony Gamboa
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Player
{
    private JFrame frame;
    
    private String name;
    private Color color;
    private short points;

    int[] hand;

    private int roadsLeft;
    private int settlementsLeft;
    private int citiesLeft;

    public Player(String str, Color col)
    {
        name = str;
        color = col;
        points = 0;

        roadsLeft = 15;
        settlementsLeft = 5;
        citiesLeft = 4;

        hand = new int[5];
        for (int i = 0; i < 5; i++)
        {
            hand[i] = 0;
        }

    }

    public short getPoints()
    {
        return points;
    }

    public void buildSettlement(int x, int y, String str) throws invalidLocationException
    {
//      if (place.isValid)

//        if (hand[0] >= 1 && hand[1] >= 1 && hand[2] >= 2 && hand[3] >= 1 && settlementsLeft > 0)
        {
            Board.table[x][y].get(str).setOcc(true);
            Board.table[x][y].get(str).setType(new Settlement(this));
            settlementsLeft--;
            points++;
        }
    }

    public void buildCity(int x, int y, String str) throws invalidLocationException
    {
//      if (place.isValid)
//        if (hand[0] >= 2 && hand[4] >= 3 && citiesLeft > 0)
        {
            if (Board.table[x][y].get(str).getType() instanceof Settlement)
            {
                if (Board.table[x][y].get(str).getType().getOwner() == Test.playerTurn)
                {
                    Board.table[x][y].get(str).setType(new City(this));
                    settlementsLeft++;
                    citiesLeft--;
                    points++;
                }
                
                else
                {
                    JOptionPane.showMessageDialog(frame,
                        "That is not your settlement!",
                        "Inane error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }

            else
            {
                JOptionPane.showMessageDialog(frame,
                        "You do not have a settlement there!",
                        "Inane error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void buildRoad(Crease place)
    {
//      if (that thing is valid
//        if (hand[2] >= 1 && hand[3] >= 1)
        {
            place.setOcc(true);
            place.setBuilt(new Road(this));
            roadsLeft--;
        }
    }

    public Color getColor()
    {
        return color;
    }

    public String getName()
    {
        return name;
    }
}
