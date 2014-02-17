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
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;

public class TileComponent extends JComponent
{
    private final Color limeGreen = new Color(173, 255, 47);
    private final Color darkGreen = new Color(34, 139, 34);
    private final Color brickRed = new Color(139, 26, 26);
    private final Color desertTan = new Color(210, 180, 140);

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        final int WIDTH = 7;
        final int HEIGHT = 7;
        final int xDiff = 120;
        final int yDiff = 138;

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

        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

                if (i % 2 != 0)
                {
                    polygon.moveTo(x[0] + i * xDiff, y[0] + j * yDiff + 69);
                }

                else
                {
                    polygon.moveTo(x[0] + i * xDiff, y[0] + j * yDiff);
                }

                for (int k = 0; k < x.length; k++)
                {
                    if (i % 2 != 0)
                    {
                        polygon.lineTo(x[k] + i * xDiff, y[k] + j * yDiff + 69);
                    }

                    else
                    {
                        polygon.lineTo(x[k] + i * xDiff, y[k] + j * yDiff);
                    }
                }

                polygon.closePath();

                if (Board.table[i][j].getLand() != true)
                {
                    g2.setColor(Color.CYAN);
                }

                //if it is hay
                else if (Board.table[i][j].getResource() == 0)
                {
                    g2.setColor(Color.YELLOW);
                }

                //if it is sheep
                else if (Board.table[i][j].getResource() == 1)
                {
                    g2.setColor(limeGreen);
                }

                //if it is wood
                else if (Board.table[i][j].getResource() == 2)
                {
                    g2.setColor(darkGreen);
                }

                //if it is brick
                else if (Board.table[i][j].getResource() == 3)
                {
                    g2.setColor(brickRed);
                }

                //if it is ore
                else if (Board.table[i][j].getResource() == 4)
                {
                    g2.setColor(Color.DARK_GRAY);
                }

                //if it is desert
                else
                {
                    g2.setColor(desertTan);
                }

                g2.fill(polygon);

                g2.setColor(Color.BLACK);
                g2.draw(polygon);
            }
        }
    }
}
