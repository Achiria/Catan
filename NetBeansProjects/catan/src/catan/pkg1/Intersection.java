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

public class Intersection {

    private final Set location;
    private Boolean occupied;
    private Building type;

    public Intersection() {
        location=new Set();
        occupied=false;
        type=null;
    }

    public Intersection(int a, int b) {
        location=new Set(a, b);
        occupied=false;
        type=null;
    }

    public void setOcc(boolean toSet) {
        occupied=toSet;
    }

    public void setType(Building built) {
        type=built;
    }

    public Building getType() {
        return type;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public boolean isValid(int x, int y, String str) throws invalidLocationException {
        if (occupied==true) {
            Dialogs.invalidSettTaken();
            return false;
        } else {
            boolean valid=true;
            switch (str.toUpperCase()) {
                case "TL":
                    if (Board.table[x][y-1].get("ML").occupied||Board.table[x][y].get("ML").occupied||Board.table[x][y].get("TR").occupied) {
                        valid=false;
                    }
                    break;
                case "TR":
                    if (Board.table[x][y-1].get("MR").occupied||Board.table[x][y].get("TL").occupied||Board.table[x][y].get("MR").occupied) {
                        valid=false;
                    }
                    break;
                case "ML":
                    if (x%2==0) {
                        if (Board.table[x-1][y].get("TL").occupied||Board.table[x][y].get("TL").occupied||Board.table[x][y].get("LL").occupied) {
                            valid=false;
                        }
                    } else {
                        if (Board.table[x-1][y+1].get("TL").occupied||Board.table[x][y].get("TL").occupied||Board.table[x][y].get("LL").occupied) {
                            valid=false;
                        }
                    }
                    break;
                case "MR":
                    if (x%2==0) {
                        if (Board.table[x+1][y].get("TR").occupied||Board.table[x][y].get("TR").occupied||Board.table[x][y].get("LR").occupied) {
                            valid=false;
                        }
                    } else {
                        if (Board.table[x+1][y+1].get("TR").occupied||Board.table[x][y].get("TL").occupied||Board.table[x][y].get("LL").occupied) {
                            valid=false;
                        }
                    }
                break;
                case "LL":
                    if (Board.table[x][y+1].get("ML").occupied||Board.table[x][y].get("ML").occupied||Board.table[x][y].get("LR").occupied) {
                        valid=false;
                    }
                break;
                case "LR":
                    if (Board.table[x][y+1].get("MR").occupied||Board.table[x][y].get("MR").occupied||Board.table[x][y].get("LL").occupied) {
                        valid=false;
                    }
            }
            
            if (!valid)
            {
                Dialogs.invalidSettDist();
            }
            
            return valid;
        }
    }
}
