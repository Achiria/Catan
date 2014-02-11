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

public class Tile
{
    private int x;
    private int y;

    private Intersection topLeft;
    private Intersection topRight;
    private Intersection midLeft;
    private Intersection midRight;
    private Intersection lowLeft;
    private Intersection lowRight;

    private Crease top;
    private Crease upperLeft;
    private Crease lowerLeft;
    private Crease bottom;
    private Crease upperRight;
    private Crease lowerRight;

    private boolean land;
    private int numb;
    private boolean robber;
    private int resource;

    public Tile(int setX, int setY)
    {
        x = setX;
        y = setY;

        topLeft = new Intersection();
        topRight = new Intersection();
        midLeft = new Intersection();
        midRight = new Intersection();
        lowLeft = new Intersection();
        lowRight = new Intersection();

        top = new Crease();
        upperLeft = new Crease();
        lowerLeft = new Crease();
        upperRight = new Crease();
        lowerRight = new Crease();
        bottom = new Crease();
    }

    public void setInter(Intersection tL, Intersection tR, Intersection mL,
            Intersection mR, Intersection lL, Intersection lR)
    {
        topLeft = tL;
        topRight = tR;
        midLeft = mL;
        midRight = mR;
        lowLeft = lL;
        lowRight = lR;
    }

    public void setCrease(Crease t, Crease uL, Crease lL,
            Crease uR, Crease lR, Crease b)
    {
        top = t;
        upperLeft = uL;
        lowerLeft = lL;
        bottom = b;
        upperRight = uR;
        lowerRight = lR;
    }

    public void setType(String str)
    {
        land = !str.equals("water");
    }

    public void setResource(String str)
    {
        //  hay = 0
//  sheep = 1
//  wood = 2
//  brick = 3
//  ore = 4
        switch (str)
        {
            case "hay":
                resource = 0;
            case "sheep":
                resource = 1;
            case "wood":
                resource = 2;
            case "brick":
                resource = 3;
            case "ore":
                resource = 4;
        }
    }

    public void setNumb(int newNumb)
    {
        numb = newNumb;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean getLand()
    {
        return land;
    }

    public Intersection get(String str) throws invalidLocationException
    {
        switch (str)
        {
            case "TL":
                return topLeft;
            case "TR":
                return topRight;
            case "ML":
                return midLeft;
            case "MR":
                return midRight;
            case "LL":
                return lowLeft;
            case "LR":
                return lowRight;
            default:
                throw new invalidLocationException("FAIL at getting intersection in tile ");
        }
    }

    public Crease getCrease(String str) throws invalidLocationException
    {
        switch (str)
        {
            case "t":
                return top;
            case "uL":
                return upperLeft;
            case "lL":
                return lowerLeft;
            case "uR":
                return upperRight;
            case "lR":
                return lowerRight;
            case "b":
                return bottom;
            default:
                throw new invalidLocationException("FAIL at getting crease in tile");

        }
    }
}
