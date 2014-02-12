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
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Test
{
    public static void main(String[] args) throws invalidLocationException
    {
        Player p1 = new Player("Anthony", Color.BLUE);
        Player p2 = new Player("Donovon", Color.ORANGE);
        Player p3 = new Player("Andrew", Color.RED);
        Player p4 = new Player("Brian", Color.WHITE);

        Player playerTurn;

        int turn = 0;

        Board thingy = new Board();

        JFrame frame = new JFrame();

        frame.setSize(2000, 1150);
        frame.setTitle("Catan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane pane = new JLayeredPane();
        pane.setPreferredSize(new Dimension(2000, 1500));

        TileComponent tileComp = new TileComponent();
        pane.add(tileComp, new Integer(0));
        tileComp.setBounds(0, 0, 2000, 1500);

        frame.setContentPane(pane);

        SettlementComponent settComp = new SettlementComponent();
        pane.add(settComp, new Integer(2));
        settComp.setBounds(0, 0, 2000, 1500);

        PogComponent pogComp = new PogComponent();
        pane.add(pogComp, new Integer(2));
        pogComp.setBounds(0, 0, 2000, 1500);

        RoadComponent roadComp = new RoadComponent();
        pane.add(roadComp, new Integer(2));
        roadComp.setBounds(0, 0, 2000, 1500);

        frame.setVisible(true);

        Buttons butt = new Buttons();
        butt.setOpaque(true);
        pane.add(butt, new Integer(0));
        butt.setBounds(0, 0, 2000, 1500);

        frame.setVisible(true);

        while (p1.getPoints() < 10 && p2.getPoints() < 10 && p3.getPoints() < 10 && p4.getPoints() < 10)
        {
            switch (turn % 4)
            {
                case 0:
                    playerTurn = p1;
                case 1:
                    playerTurn = p2;
                case 2:
                    playerTurn = p3;
                case 3:
                    playerTurn = p4;
            }
            turn++;
        }
    }
}
