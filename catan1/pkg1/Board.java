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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board
{
    private final int HEIGHT = 7;
    private final int WIDTH = 7;
    ArrayList<Integer> resources = new ArrayList();
    
    public static Tile[][] table;

    /**
     * creates the board the game will be played on
     *
     * @throws invalidLocationException
     */
    public Board() throws invalidLocationException
    {
        //a 2d array represents the hexagonal tiles
        table = new Tile[WIDTH][HEIGHT];

        //fills the 2d array with new Tiles
        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                table[i][j] = new Tile(i, j);
            }
        }

        /**
         * traces through the 2d array and initializes each tile with new
         * intersections and makes sure that each intersection that is shared
         * between tiles is actually shared. Same goes with creases
         */
        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                //the farthest left column
                if (i == 0)
                {
                    //the top-most position
                    if (j == 0)
                    {

                        //initializes new intersections because it is the first tile
                        table[0][0].setInter(new Intersection(0, 0), new Intersection(1, 0), new Intersection(0, 1),
                                new Intersection(1, 1), new Intersection(0, 2), new Intersection(1, 2));

                        //intializes new creases
                        table[0][0].setCrease(new Crease(table[0][0].get("tL"), table[0][0].get("tR")),
                                new Crease(table[0][0].get("tL"), table[0][0].get("mL")),
                                new Crease(table[0][0].get("mL"), table[0][0].get("lR")),
                                new Crease(table[0][0].get("tR"), table[0][0].get("mR")),
                                new Crease(table[0][0].get("mR"), table[0][0].get("lR")),
                                new Crease(table[0][0].get("lL"), table[0][0].get("lR")));
                    }

                    //if any other tile in the first column other than the top-most
                    else
                    {
                        /**
                         * initializes new intersections except for those shared
                         * with the tiles above it, namely tL and tR and lL and
                         * lR
                         */
                        table[0][j].setInter(table[0][j - 1].get("LL"), table[0][j - 1].get("LR"), new Intersection(0, 2 * j + 1),
                                new Intersection(1, 2 * j + 1), new Intersection(0, 2 * j + 2), new Intersection(1, 2 * j + 2));

                        /**
                         * initializes new crease except for those shared with
                         * the tiles above it, namely t and b
                         */
                        table[0][j].setCrease(table[0][j - 1].getCrease("b"),
                                new Crease(table[0][j].get("tL"), table[0][j].get("mL")),
                                new Crease(table[0][j].get("mL"), table[0][j].get("lL")),
                                new Crease(table[0][j].get("tR"), table[0][j].get("mR")),
                                new Crease(table[0][j].get("mR"), table[0][j].get("lR")),
                                new Crease(table[0][j].get("lL"), table[0][j].get("lR")));
                    }

                    //sets every tile in the left most column to water
                    table[0][j].setType("water");
                }

                //the second column from the left
                else if (i == 1)
                {
                    if (j == 0)
                    {
                        /**
                         * makes sure to also share intersections and creases
                         * with the tiles that are now to the left
                         */

                        table[1][0].setInter(table[0][0].get("MR"), new Intersection(2, 0), table[0][0].get("LR"),
                                new Intersection(2, 1), table[0][1].get("MR"), new Intersection(2, 2));

                        table[1][0].setCrease(new Crease(table[1][0].get("tL"), table[1][0].get("tR")),
                                table[0][0].getCrease("lR"),
                                table[0][1].getCrease("uR"),
                                new Crease(table[1][0].get("tR"), table[1][0].get("mR")),
                                new Crease(table[1][0].get("mR"), table[1][0].get("lR")),
                                new Crease(table[1][0].get("lL"), table[1][0].get("lR")));

                        table[1][0].setType("water");
                    }

                    //not the bottom-most
                    else if (j != 6)
                    {
                        table[1][j].setInter(table[1][j - 1].get("LL"), table[1][j - 1].get("LR"), table[0][j].get("LR"),
                                new Intersection(2, 2 * j + 1), table[0][j + 1].get("MR"), new Intersection(2, 2 * j + 2));

                        table[1][j].setCrease(table[1][j - 1].getCrease("b"),
                                table[0][j].getCrease("lR"),
                                table[0][j + 1].getCrease("uR"),
                                new Crease(table[1][j].get("tR"), table[1][j].get("mR")),
                                new Crease(table[1][j].get("mR"), table[1][j].get("lR")),
                                new Crease(table[1][j].get("lL"), table[1][j].get("lR")));
                    }

                    //the bottom most
                    else
                    {
                        table[1][6].setInter(table[1][5].get("LL"), table[1][5].get("LR"), table[0][6].get("LR"),
                                new Intersection(2, 13), new Intersection(1, 14), new Intersection(2, 14));

                        table[1][j].setCrease(table[1][j - 1].getCrease("b"),
                                table[0][6].getCrease("lR"),
                                new Crease(table[1][6].get("mL"), table[1][6].get("lL")),
                                new Crease(table[1][6].get("tR"), table[1][6].get("mR")),
                                new Crease(table[1][6].get("mR"), table[1][6].get("lR")),
                                new Crease(table[1][6].get("lL"), table[1][6].get("lR")));
                    }

                    if (j <= 1 || j >= 5)
                    {
                        table[i][j].setType("water");
                    }

                    else
                    {
                        table[i][j].setType("land");
                    }
                }

                else if (i == 2)
                {
                    if (j == 0)
                    {
                        table[2][0].setInter(new Intersection(2, 0), new Intersection(3, 0), table[1][0].get("TR"),
                                new Intersection(3, 1), table[1][0].get("MR"), new Intersection(3, 2));

                        table[2][0].setCrease(new Crease(table[2][0].get("tL"), table[2][0].get("tR")),
                                new Crease(table[2][0].get("tL"), table[2][0].get("mL")),
                                table[1][0].getCrease("uR"),
                                new Crease(table[2][0].get("tR"), table[2][0].get("mR")),
                                new Crease(table[2][0].get("mR"), table[2][0].get("lR")),
                                new Crease(table[2][0].get("lL"), table[2][0].get("lR")));

                    }

                    else if (j != 6)
                    {
                        table[2][j].setInter(table[2][j - 1].get("LL"), table[2][j - 1].get("LR"), table[1][j].get("TR"),
                                new Intersection(3, 2 * j + 1), table[1][j].get("MR"), new Intersection(3, 2 * j + 2));

                        table[2][j].setCrease(table[2][j - 1].getCrease("b"),
                                table[1][j - 1].getCrease("lR"),
                                table[1][j].getCrease("uR"),
                                new Crease(table[2][j].get("tR"), table[2][j].get("mR")),
                                new Crease(table[2][j].get("mR"), table[2][j].get("lR")),
                                new Crease(table[2][j].get("lL"), table[2][j].get("lR")));
                    }

                    else
                    {
                        table[2][6].setInter(table[2][5].get("LL"), table[2][5].get("LR"), table[1][6].get("TR"),
                                new Intersection(3, 13), table[1][6].get("MR"), new Intersection(3, 14));

                        table[2][6].setCrease(table[2][5].getCrease("b"),
                                table[1][j - 1].getCrease("lR"),
                                table[1][j].getCrease("uR"),
                                new Crease(table[2][6].get("tR"), table[2][6].get("mR")),
                                new Crease(table[2][6].get("mR"), table[2][6].get("lR")),
                                new Crease(table[2][6].get("lL"), table[2][6].get("lR")));
                    }

                    if (j <= 1 || j >= 6)
                    {
                        table[i][j].setType("water");
                    }

                    else
                    {
                        table[i][j].setType("land");
                    }
                }

                else if (i == 3)
                {
                    if (j == 0)
                    {
                        table[3][0].setInter(table[2][0].get("MR"), new Intersection(4, 0), table[2][0].get("LR"),
                                new Intersection(4, 1), table[2][1].get("MR"), new Intersection(4, 2));

                        table[3][0].setCrease(new Crease(table[3][0].get("tL"), table[3][0].get("tR")),
                                table[2][0].getCrease("lR"),
                                table[2][1].getCrease("uR"),
                                new Crease(table[3][0].get("tR"), table[3][0].get("mR")),
                                new Crease(table[3][0].get("mR"), table[3][0].get("lR")),
                                new Crease(table[3][0].get("lL"), table[3][0].get("lR")));
                    }

                    else if (j != 6)
                    {
                        table[3][j].setInter(table[3][j - 1].get("LL"), table[3][j - 1].get("LR"), table[2][j].get("LR"),
                                new Intersection(4, 2 * j + 1), table[2][j + 1].get("MR"), new Intersection(4, 2 * j + 2));

                        table[3][j].setCrease(table[3][j - 1].getCrease("b"),
                                table[2][j].getCrease("lR"),
                                table[2][j + 1].getCrease("uR"),
                                new Crease(table[3][j].get("tR"), table[3][j].get("mR")),
                                new Crease(table[3][j].get("mR"), table[3][j].get("lR")),
                                new Crease(table[3][j].get("lL"), table[3][j].get("lR")));
                    }

                    else
                    {
                        table[3][6].setInter(table[3][5].get("LL"), table[3][5].get("LR"), table[2][6].get("LR"),
                                new Intersection(4, 13), new Intersection(3, 14), new Intersection(4, 14));

                        table[3][6].setCrease(table[3][j - 1].getCrease("b"),
                                table[2][6].getCrease("lR"),
                                new Crease(table[3][6].get("mL"), table[3][6].get("lL")),
                                new Crease(table[3][6].get("tR"), table[3][6].get("mR")),
                                new Crease(table[3][6].get("mR"), table[3][6].get("lR")),
                                new Crease(table[3][6].get("lL"), table[3][6].get("lR")));
                    }

                    if (j == 0 || j >= 6)
                    {
                        table[i][j].setType("water");
                    }

                    else
                    {
                        table[i][j].setType("land");
                    }
                }

                else if (i == 4)
                {
                    if (j == 0)
                    {
                        table[4][0].setInter(new Intersection(4, 0), new Intersection(5, 0), table[3][0].get("TR"),
                                new Intersection(5, 1), table[3][0].get("MR"), new Intersection(5, 2));

                        table[4][0].setCrease(new Crease(table[4][0].get("tL"), table[4][0].get("tR")),
                                new Crease(table[4][0].get("tL"), table[4][0].get("mL")),
                                table[3][0].getCrease("uR"),
                                new Crease(table[4][0].get("tR"), table[4][0].get("mR")),
                                new Crease(table[4][0].get("mR"), table[4][0].get("lR")),
                                new Crease(table[4][0].get("lL"), table[4][0].get("lR")));
                    }

                    else if (j != 6)
                    {
                        table[4][j].setInter(table[4][j - 1].get("LL"), table[4][j - 1].get("LR"), table[3][j].get("MR"),
                                new Intersection(5, 2 * j + 1), table[3][j].get("LR"), new Intersection(5, 2 * j + 2));

                        table[4][j].setCrease(table[4][j - 1].getCrease("b"),
                                table[3][j - 1].getCrease("lR"),
                                table[3][j].getCrease("uR"),
                                new Crease(table[4][j].get("tR"), table[4][j].get("mR")),
                                new Crease(table[4][j].get("mR"), table[4][j].get("lR")),
                                new Crease(table[4][j].get("lL"), table[4][j].get("lR")));
                    }

                    else
                    {
                        table[4][6].setInter(table[4][5].get("LL"), table[4][5].get("LR"), table[3][6].get("TR"),
                                new Intersection(5, 13), table[3][6].get("MR"), new Intersection(5, 14));

                        table[4][6].setCrease(table[4][5].getCrease("b"),
                                table[3][5].getCrease("lR"),
                                table[3][6].getCrease("uR"),
                                new Crease(table[4][6].get("tR"), table[4][6].get("mR")),
                                new Crease(table[4][6].get("mR"), table[4][6].get("lR")),
                                new Crease(table[4][6].get("lL"), table[4][6].get("lR")));
                    }

                    if (j <= 1 || j >= 6)
                    {
                        table[i][j].setType("water");
                    }

                    else
                    {
                        table[i][j].setType("land");
                    }
                }

                else if (i == 5)
                {
                    if (j == 0)
                    {
                        table[5][0].setInter(table[4][0].get("MR"), new Intersection(6, 0), table[4][0].get("LR"),
                                new Intersection(6, 1), table[4][1].get("MR"), new Intersection(6, 2));

                        table[5][0].setCrease(new Crease(table[5][0].get("tL"), table[5][0].get("tR")),
                                table[4][0].getCrease("lR"),
                                table[4][1].getCrease("uR"),
                                new Crease(table[5][0].get("tR"), table[5][0].get("mR")),
                                new Crease(table[5][0].get("mR"), table[5][0].get("lR")),
                                new Crease(table[5][0].get("lL"), table[5][0].get("lR")));
                    }

                    else if (j != 6)
                    {
                        table[5][j].setInter(table[5][j - 1].get("LL"), table[5][j - 1].get("LR"), table[4][j].get("LR"),
                                new Intersection(6, 2 * j + 1), table[4][j + 1].get("MR"), new Intersection(6, 2 * j + 2));

                        table[5][j].setCrease(table[5][j - 1].getCrease("b"),
                                table[4][j].getCrease("lR"),
                                table[4][j + 1].getCrease("uR"),
                                new Crease(table[5][j].get("tR"), table[5][j].get("mR")),
                                new Crease(table[5][j].get("mR"), table[5][j].get("lR")),
                                new Crease(table[5][j].get("lL"), table[5][j].get("lR")));
                    }

                    else
                    {
                        table[5][6].setInter(table[5][5].get("LL"), table[5][5].get("LR"), table[4][6].get("LR"),
                                new Intersection(6, 13), new Intersection(5, 14), new Intersection(6, 14));

                        table[5][6].setCrease(table[5][j - 1].getCrease("b"),
                                table[4][6].getCrease("lR"),
                                new Crease(table[5][6].get("mL"), table[5][6].get("lL")),
                                new Crease(table[5][6].get("tR"), table[5][6].get("mR")),
                                new Crease(table[5][6].get("mR"), table[5][6].get("lR")),
                                new Crease(table[5][6].get("lL"), table[5][6].get("lR")));

                    }

                    if (j <= 1 || j >= 5)
                    {
                        table[i][j].setType("water");
                    }

                    else
                    {
                        table[i][j].setType("land");
                    }
                }

                else if (i == 6)
                {
                    if (j == 0)
                    {
                        table[6][0].setInter(new Intersection(6, 0), new Intersection(7, 0), table[5][0].get("TR"),
                                new Intersection(7, 1), table[5][0].get("MR"), new Intersection(7, 2));

                        table[6][0].setCrease(new Crease(table[6][0].get("tL"), table[6][0].get("tR")),
                                new Crease(table[6][0].get("tL"), table[6][0].get("mL")),
                                table[5][0].getCrease("uR"),
                                new Crease(table[6][0].get("tR"), table[6][0].get("mR")),
                                new Crease(table[6][0].get("mR"), table[6][0].get("lR")),
                                new Crease(table[6][0].get("lL"), table[6][0].get("lR")));
                    }

                    else if (j != 6)
                    {
                        table[6][j].setInter(table[6][j - 1].get("LL"), table[6][j - 1].get("LR"), table[5][j].get("TR"),
                                new Intersection(7, 2 * j + 1), table[5][j].get("MR"), new Intersection(7, 2 * j + 2));

                        table[6][j].setCrease(table[6][j - 1].getCrease("b"),
                                table[5][j - 1].getCrease("lR"),
                                table[5][j].getCrease("uR"),
                                new Crease(table[6][j].get("tR"), table[6][j].get("mR")),
                                new Crease(table[6][j].get("mR"), table[6][j].get("lR")),
                                new Crease(table[6][j].get("lL"), table[6][j].get("lR")));
                    }

                    else
                    {
                        table[6][6].setInter(table[6][5].get("LL"), table[6][5].get("LR"), table[5][6].get("TR"),
                                new Intersection(7, 13), table[5][6].get("MR"), new Intersection(7, 14));

                        table[6][6].setCrease(table[6][5].getCrease("b"),
                                table[5][5].getCrease("lR"),
                                table[5][6].getCrease("uR"),
                                new Crease(table[6][6].get("tR"), table[6][6].get("mR")),
                                new Crease(table[6][6].get("mR"), table[6][6].get("lR")),
                                new Crease(table[6][6].get("lL"), table[6][6].get("lR")));
                    }

                    table[i][j].setType("water");
                }
            }
        }

        resources.addAll(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5));
        Random ran = new Random();
        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                if (table[i][j].getLand())
                {
                    int temp = ran.nextInt(resources.size());
                    table[i][j].setResource(resources.get(temp));
                    resources.remove(temp);
                }
            }
        }
    }

    public Intersection getInter(int x, int y, String str) throws invalidLocationException
    {
        switch (str)
        {
            case "TL":
                return table[x][y].get("TL");
            case "TR":
                return table[x][y].get("TR");
            case "ML":
                return table[x][y].get("ML");
            case "MR":
                return table[x][y].get("MR");
            case "LL":
                return table[x][y].get("LL");
            case "LR":
                return table[x][y].get("LR");
            default:
                throw new invalidLocationException("FAIL at getInter in Board");
        }
    }
}
