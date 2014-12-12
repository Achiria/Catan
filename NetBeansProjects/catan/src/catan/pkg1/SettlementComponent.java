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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;

public class SettlementComponent extends JComponent
{
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        final int WIDTH = 7;
        final int HEIGHT = 7;
        final int xDiff = 120;
        final int yDiff = 138;

        // TR, TL, ML, LL, LR, MR
        int[] x =
        {
            140, 60, 20, 60, 140, 180
        };
        int[] y =
        {
            31, 31, 100, 169, 169, 100
        };

        String[] corners =
        {
            "TR", "TL", "ML", "LL", "LR", "MR"
        };

        for (int i = 0; i < WIDTH; i++)
        {
            for (int j = 0; j < HEIGHT; j++)
            {
                try
                {
                    for (int k = 0; k < corners.length; k++)
                    {
                        if (Board.table[i][j].get(corners[k]).getType() instanceof Settlement)
                        {
                            if (i % 2 == 0)
                            {
                                GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

                                // TR
                                polygon.moveTo(x[k] + (i * xDiff) + 10, y[k] + (j * yDiff) - 8);
                                //T
                                polygon.lineTo(x[k] + (i * xDiff), y[k] + (j * yDiff) - 17);
                                //TL
                                polygon.lineTo(x[k] + (i * xDiff) - 10, y[k] + (j * yDiff) - 8);
                                // LL
                                polygon.lineTo(x[k] + (i * xDiff) - 10, y[k] + (j * yDiff) + 10);
                                //LR
                                polygon.lineTo(x[k] + (i * xDiff) + 10, y[k] + (j * yDiff) + 10);
                                //TR
                                polygon.closePath();

                                g2.setPaint(Board.table[i][j].get(corners[k]).getType().getOwner().getColor());
                                g2.fill(polygon);
                                g2.setPaint(Color.BLACK);
                                g2.draw(polygon);
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
