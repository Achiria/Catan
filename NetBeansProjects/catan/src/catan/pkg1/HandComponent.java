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
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class HandComponent extends JComponent
{
    private final Color limeGreen = new Color(173, 255, 47);
    private final Color darkGreen = new Color(34, 139, 34);
    private final Color brickRed = new Color(139, 26, 26);
    private final int cirDiameter = 40;

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        final int cardWidth = 100;
        final int cardHeight = 150;
        final int gap = 5;
        final int offset = 10;
        final int circleX = 35;
        final int circleY = 60;
        final int diameter = 50;

        Rectangle hay = new Rectangle();
        Rectangle sheep = new Rectangle();
        Rectangle wood = new Rectangle();
        Rectangle brick = new Rectangle();
        Rectangle ore = new Rectangle();

        hay.setBounds(offset, offset, cardWidth, cardHeight);
        sheep.setBounds(2 * offset + cardWidth, 10, cardWidth, cardHeight);
        wood.setBounds(3 * offset + 2 * cardWidth, 10, cardWidth, cardHeight);
        brick.setBounds(4 * offset + 3 * cardWidth, 10, cardWidth, cardHeight);
        ore.setBounds(5 * offset + 4 * cardWidth, 10, cardWidth, cardHeight);

        g2.setColor(Color.YELLOW);
        g2.fill(hay);

        g2.setColor(limeGreen);
        g2.fill(sheep);

        g2.setColor(darkGreen);
        g2.fill(wood);

        g2.setColor(brickRed);
        g2.fill(brick);

        g2.setColor(Color.DARK_GRAY);
        g2.fill(ore);

        g2.setColor(Color.BLACK);
        g2.draw(hay);
        g2.draw(sheep);
        g2.draw(wood);
        g2.draw(brick);
        g2.draw(ore);

        Ellipse2D.Double circle = new Ellipse2D.Double();
        g2.setColor(Color.WHITE);
        circle.setFrame(circleX, circleY, diameter, diameter);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        g2.draw(circle);
        g2.setColor(Color.WHITE);
        circle.setFrame(circleX + cardWidth + offset, circleY, diameter, diameter);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        g2.draw(circle);
        g2.setColor(Color.WHITE);
        circle.setFrame(circleX + 2 * cardWidth + 2 * offset, circleY, diameter, diameter);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        g2.draw(circle);
        g2.setColor(Color.WHITE);
        circle.setFrame(circleX + 3 * cardWidth + 3 * offset, circleY, diameter, diameter);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        g2.draw(circle);
        g2.setColor(Color.WHITE);
        circle.setFrame(circleX + 4 * cardWidth + 4 * offset, circleY, diameter, diameter);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        g2.draw(circle);

        for (int i = 0; i < 5; i++)
        {
            int toDraw = Turn.getPlayer().hand[i];
            g2.drawString("" + toDraw, 110 + circleX + (i - 1) * cardWidth + (i - 1) * offset + 20, circleY + 30);
        }
    }
}
