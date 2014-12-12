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

public class Cards
{
    public static void addCards()
    {
        final int WIDTH = 7;
        final int HEIGHT = 7;
        String[] corners =
        {
            "TL", "TR", "ML", "MR", "LL", "LR"
        };

        //  hay = 0
        //  sheep = 1
        //  wood = 2
        //  brick = 3
        //  ore = 4
        // desert = 5;
        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                try
                {
                    //if the tile number is the same as the number rolled and the tile is not shut down
                    if (Board.table[i][j].getNumb() == Actions.getNumRolled() && !Board.table[i][j].isShutdown())
                    {
                        //go through all the corners of that tile
                        for (String corner : corners)
                        {
                            //if there is a building on a corner
                            if (Board.table[i][j].get(corner).getType() instanceof Settlement || Board.table[i][j].get(corner).getType() instanceof City)
                            {
                                //set = the building
                                Building set = Board.table[i][j].get(corner).getType();
                                int toAdd;
                                if (set instanceof Settlement)
                                {
                                    toAdd = 1;
                                }

                                else
                                {
                                    toAdd = 2;
                                }

                                //add the resource of the tile to the owner's hand
                                set.getOwner().addHand(Board.table[i][j].getResource(), toAdd);
                            }
                        }
                    }
                }

                catch (invalidLocationException ex)
                {
                    System.out.println("FAIL in settlementComponent");
                }
            }
        }
    }
}
