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
package catan.pkg1;

public class Crease
{

    private Intersection start;
    private Intersection end;
    private boolean occupied;
    private Road built;

    private Crease bro1;
    private Crease bro2;
    private Crease bro3;
    private Crease bro4;

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

    public Road getRoad()
    {
        return built;
    }

    public boolean getOcc()
    {
        return occupied;
    }

    public Crease getSibling(int toGet)
    {
        switch (toGet)
        {
            case 1:
                return bro1;
            case 2:
                return bro2;
            case 3:
                return bro3;
            case 4:
                return bro4;
            default:
                System.err.println("That is not a correct sibling. Crease ln 66");
        }
        return null;
    }

    public void setSibling(Crease newSibling, int toSet)
    {
        switch (toSet)
        {
            case 1:
                bro1 = newSibling;
            case 2:
                bro2 = newSibling;
            case 3:
                bro3 = newSibling;
            case 4:
                bro4 = newSibling;
            default:
                System.err.println("That is not a correct sibling. Crease ln 66");
        }

    }

    public void setAllSiblings(Crease newsib1, Crease newsib2, Crease newsib3, Crease newsib4)
    {
        bro1 = newsib1;
        bro2 = newsib2;
        bro3 = newsib3;
        bro4 = newsib4;
    }
}
