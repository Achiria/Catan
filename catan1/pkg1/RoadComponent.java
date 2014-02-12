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
import java.awt.geom.GeneralPath;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        final int ULAngle = 60;
        final int LLAngle = -60;
        final int URAngle = -60;
        final int LRAngle = 60;

        final String[] creases = new String[]
        {
            "T", "UL", "LL", "B", "UR", "LR"
        };

        Graphics2D g2 = (Graphics2D) g;

        //TR, TL, ML, LL, LR, MR
        int[] x =
        {
            140, 60, 20, 60, 140, 180
        };
        //TR, TL, ML, LL, LR, MR
        int[] y =
        {
            31, 31, 100, 169, 169, 100
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
                                    toDraw = new Rectangle(x[0] + (i * xDiff) + 20, y[0] + (j * yDiff) - 10, 40, 20);
                                }

                                else
                                {
                                    toDraw = new Rectangle(x[0] + (i * xDiff) + 20, y[0] + (j * yDiff) - 10, 40, 20);
                                }
                            }

                            //if it is upper left crease
                            else if (k == 1)
                            {
                                if (i % 2 == 0)
                                {
                                    toDraw = new Rectangle(x[0] + (i * xDiff) + 20, y[0] + (j * yDiff) - 10, 40, 20);
                                }

                                else
                                {
                                    toDraw = new Rectangle(x[0] + (i * xDiff) + 20, y[0] + (j * yDiff) - 10, 40, 20);
                                }
                            }
                            g2.setColor(Color.BLACK);
                            g2.draw(toDraw);
                            g2.setColor(Board.table[i][j].getCrease(creases[k]).getRoad().getOwner().getColor());
                            g2.fill(toDraw);
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

    private double toRadians(int angle)
    {
        return angle * (Math.PI / 180);
    }
}
