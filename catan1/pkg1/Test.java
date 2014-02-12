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
        
//        while (p1.getPoints() < 10 && p2.getPoints() < 10 && p3.getPoints() < 10 && p4.getPoints() < 10)
        {
            //print board
            //check whose turn
            try
            {
                p1.buildSettlement(2, 2, "MR");
                p1.buildSettlement(5, 3, "MR");
                p2.buildSettlement(4, 5, "TR");
                p1.buildSettlement(2, 2, "ML");
                p1.buildSettlement(3, 2, "TL");
                p3.buildSettlement(0, 0, "TL");
                p1.buildRoad(Board.table[2][2].getCrease("T"));
                p2.buildRoad(Board.table[3][2].getCrease("T"));
                p1.buildRoad(Board.table[2][2].getCrease("UL"));
                p2.buildRoad(Board.table[3][2].getCrease("UL"));
                p2.buildRoad(Board.table[3][4].getCrease("LL"));
                p2.buildRoad(Board.table[4][4].getCrease("B"));
                p2.buildRoad(Board.table[0][4].getCrease("LR"));
            }

            catch (invalidLocationException e)
            {
                System.out.println("FAIL");
            }
        }
    }
}
