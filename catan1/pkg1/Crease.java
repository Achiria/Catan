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

/**
 *
 * @author Anthony
 */
public class Crease
{
    private Intersection start;
    private Intersection end;
    private boolean occupied;
    private Road built;
    
    public Crease()
    {
        start = new Intersection();
        end = new Intersection();
        occupied = false;
        built = null;
    }
    
    public Crease(Intersection s, Intersection e)
    {
        start = s;
        end = e;
    }
    
    public void setOcc(boolean occ)
    {
        occupied = occ;
    }
    
    public void setBuilt(Road toBeBuilt)
    {
        built = toBeBuilt;
    }
}
