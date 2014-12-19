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
package catan.pkg1;

import java.awt.Color;
import java.util.ArrayList;

public class Player
{

    private String name;
    private Color color;
    private short points;

    int[] hand;

    private int roadsLeft;
    private int settlementsLeft;
    private int citiesLeft;

    private ArrayList<DevCard> devCards = new ArrayList<>();

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

    //  hay = 0
    //  sheep = 1
    //  wood = 2
    //  brick = 3
    //  ore = 4
    // desert = 5;
    public void addHand(int card, int amount)
    {
        hand[card] = hand[card] + amount;
    }

    public void addCard(DevCard toAdd)
    {
        devCards.add(toAdd);
    }

    public void buildSettlement(int x, int y, String str) throws invalidLocationException
    {
        if (Board.table[x][y].get(str).isValid(x, y, str))
        {
            //if you have enough cards
//            if (hand[0] >= 1 && hand[1] >= 1 && hand[2] >= 2 && hand[3] >= 1)
            {
                //if you have enough settlements
                if (settlementsLeft > 0)
                {
                    {
                        Board.table[x][y].get(str).setOcc(true);
                        Board.table[x][y].get(str).setType(new Settlement(this));
                        //remove settlements left
                        settlementsLeft--;
                        //remove cards
                        for (int i = 0; i < 4; i++)
                        {
                            hand[i] = hand[i]--;
                        }
                        points++;
                    }
                }

                else
                {
                    Dialogs.noSett();
                }
            }

//            else
//            {
//                Dialogs.cardsError();
//            }
        }
    }

    public void buildCity(int x, int y, String str) throws invalidLocationException
    {
//      if (place.isValid)

        //if you have enough cards
        if (hand[0] >= 2 && hand[4] >= 3)
        {
            if (Board.table[x][y].get(str).getType() instanceof Settlement)
            {
                // if you have cities left to build
                if (citiesLeft > 0)
                {
                    if (Board.table[x][y].get(str).getType().getOwner() == Turn.getPlayer())
                    {
                        Board.table[x][y].get(str).setType(new City(this));
                        settlementsLeft++;
                        citiesLeft--;
                        points++;
                    }

                    //might be moved to isValid method if ever made
                    else
                    {
                        Dialogs.settErrorOwn();
                    }
                }

                else
                {
                    Dialogs.noCity();
                }
            }

            //might be moved to isValid method
            else
            {
                Dialogs.settErrorLoc();
            }
        }

        else
        {
            Dialogs.cardsError();
        }

    }

    public void buildFirstRoad(Crease place)
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

    public void buildRoad(Crease place)
    {
        place.setOcc(true);
        place.setBuilt(new Road(this));
        roadsLeft--;
    }
}
