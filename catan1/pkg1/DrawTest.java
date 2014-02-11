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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Anthony Gamboa
 */
public class DrawTest
{
    public static void main(String args[])
    {
        try
        {
            JFrame frame = new JFrame();
            frame.setSize(1600, 900);
            frame.setTitle("Catan");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            TileComponent component = new TileComponent();
            frame.add(component);
            frame.setVisible(true);
            Board thingy = new Board();
            
            try
            {
                Player p1 = new Player("Anthony", Color.BLUE);
                Player p2 = new Player("Brian", Color.RED);
                Player p3 = new Player("Donovon", Color.GREEN);
                p1.buildSettlement(2, 2, "MR");
                p1.buildSettlement(5, 3, "MR");
                p2.buildSettlement(4, 5, "TR");
                p1.buildSettlement(2, 2, "ML");
                p1.buildSettlement(3, 2, "TL");
                p3.buildSettlement(0, 0, "TL");
                
                
            }
            
            catch (invalidLocationException e)
            {
                System.out.println("Fail");
            }
            
            SettlementComponent comp = new SettlementComponent();
            frame.add(comp);
            
            frame.setVisible(true);
        }
        catch (invalidLocationException ex)
        {
            System.out.println("Fail");
        }
    }
}
