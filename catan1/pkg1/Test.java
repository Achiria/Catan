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
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Test
{
    public static void main(String[] args)
    {
        Player p1 = new Player("Anthony", Color.BLUE);
        Player p2 = new Player("Donovon", Color.ORANGE);
        Player p3 = new Player("Andrew", Color.RED);
        Player p4 = new Player("Brian", Color.GREEN);

        JFrame frame = new JFrame();
        frame.setSize(2000, 1150);
        frame.setTitle("Catan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        TileComponent component = new TileComponent();
                
        JLayeredPane boardLayer = new JLayeredPane();
        boardLayer.setLayer(component, 0);
        boardLayer.setVisible(true);
        frame.add(component);
        
        frame.setVisible(true);

        try
        {
            Board thingy = new Board();
        }

        catch (invalidLocationException e)
        {
            System.out.println("Fail in main test");
        }

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
            }

            catch (invalidLocationException e)
            {
                System.out.println("FAIL");
            }

            SettlementComponent comp = new SettlementComponent();
            frame.add(comp);

            frame.setVisible(true);
        }
    }
}
