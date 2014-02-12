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

import java.awt.Dimension;
import javax.swing.*;

public class PaneDemo extends JPanel
{
    private JLayeredPane pane;
    
    public PaneDemo()
    {
        pane = new JLayeredPane();
        pane.setPreferredSize(new Dimension(2000, 1500));
        
        TileComponent component = new TileComponent();
        
        pane.add(component, 0);
        
        add(pane);
    }
}
