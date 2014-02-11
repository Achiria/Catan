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

public class Intersection
{
    private final Set location;
    private Boolean occupied;
    private Building type;
    
    public Intersection()
    {
        location = new Set();
        occupied = false;
        type = null;
    }
    
    public Intersection(int a, int b)
    {
        location = new Set(a, b);     
    }
    
    public void setOcc(boolean toSet)
    {
        occupied = toSet;
    }
    
    public void setType(Building built)
    {
        type = built;
    }
    
    public Building getType()
    {
        return type;
    }
    
//    public boolean isValid()
//    {
//        if (occupied == true)
//        {
//            return false;
//        }
//        
//        else
//        {
//            return Board.isValid(location.x, location.y);
//        }
//    }
}
