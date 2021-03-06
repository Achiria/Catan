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

public class Turn
{
    private static int turn = 0;
    private static Player CurrentPlayer;

    public static void turnSet(int num)
    {
        turn = num;
    }
    
    public static void turnEnded()
    {
        turn++;
        Dialogs.turnChange(getPlayer());       
    }

    public static Player getPlayer()
    {
        if (turn % 4 == 0)
        {
            CurrentPlayer = Test.p1;
        }

        else if (turn % 4 == 1)
        {
            CurrentPlayer = Test.p2;
        }

        else if (turn % 4 == 2)
        {
            CurrentPlayer = Test.p3;
        }

        else
        {
            CurrentPlayer = Test.p4;
        }

        return CurrentPlayer;
    }
}
