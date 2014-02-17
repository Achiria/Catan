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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class RoadComponent extends JComponent
{
    @Override
    public void paintComponent(Graphics g)
    {
        final int HEIGHT = 7;
        final int WIDTH = 7;
        final int xDiff = 120;
        final int yDiff = 138;
        final int oddOffset = 69;
        final int roadHeight = 10;
        final int roadWidth = 50;
        final int xOffset = 15;
        final int yOffset = 5;

        final int ULAngle = 60;
        final int LLAngle = -60;
        final int URAngle = -60;
        final int LRAngle = 60;

        final String[] creases = new String[]
        {
            "T", "UL", "LL"
        };

        Graphics2D g2 = (Graphics2D) g;

        //TL, ML, LL, LR, MR, TR
        int[] x =
        {
            60, 20, 60, 140, 180, 140
        };
        //TL, ML, LL, LR, MR, TR
        int[] y =
        {
            31, 100, 169, 169, 100, 31
        };

        Rectangle toDraw = new Rectangle();

        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                for (int k = 0; k < creases.length; k++)
                {
                    try
                    {
                        if (Board.table[i][j].getCrease(creases[k]).getOcc())
                        {
                            //if it is the top crease
                            if (k == 0)
                            {
                                if (i % 2 == 0)
                                {
                                    toDraw = new Rectangle(x[0] + (i * xDiff) + xOffset, y[0] + (j * yDiff) - yOffset, roadWidth, roadHeight);
                                }

                                else
                                {
                                    toDraw = new Rectangle(x[0] + (i * xDiff) + xOffset, y[0] + (j * yDiff) - yOffset + oddOffset, roadWidth, roadHeight);
                                }

                                g2.setColor(Board.table[i][j].getCrease(creases[k]).getRoad().getOwner().getColor());
                                g2.fill(toDraw);
                                g2.setColor(Color.BLACK);
                                g2.draw(toDraw);
                            }

                            //if it is upper left crease
                            else if (k == 1)
                            {
                                if (i % 2 == 0)
                                {
                                    toDraw = new Rectangle(x[1] + (i * xDiff) + xOffset - 20, y[1] + (j * yDiff) - yOffset - 35, roadWidth, roadHeight);
                                }

                                else
                                {
                                    toDraw = new Rectangle(x[1] + (i * xDiff) + xOffset - 20, y[1] + (j * yDiff) - yOffset - 35 + oddOffset, roadWidth, roadHeight);
                                }

                                g2.setColor(Board.table[i][j].getCrease(creases[k]).getRoad().getOwner().getColor());
                                g2.fill(toDraw);
                                g2.setColor(Color.BLACK);
                                g2.draw(toDraw);
                            }

                            //lower left
                            else if (k == 2)
                            {
                                if (i % 2 == 0)
                                {
                                    toDraw = new Rectangle(x[1] + (i * xDiff) + xOffset - 20, y[2] + (j * yDiff) - yOffset - 35, roadWidth, roadHeight);
                                }

                                else
                                {
                                    toDraw = new Rectangle(x[1] + (i * xDiff) + xOffset - 20, y[2] + (j * yDiff) - yOffset - 35 + oddOffset, roadWidth, roadHeight);
                                }

                                g2.setColor(Board.table[i][j].getCrease(creases[k]).getRoad().getOwner().getColor());
                                g2.fill(toDraw);
                                g2.setColor(Color.BLACK);
                                g2.draw(toDraw);
                            }
                        }
                    }

                    catch (invalidLocationException ex)
                    {
                        System.out.println("Fail at RoadComponent");
                    }
                }
            }
        }
    }
}
