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

import java.util.Random;

public class Actions
{
    private static boolean rolled = false;
    private static boolean end = false;
    private static int numRolled;

    public void trade()
    {

    }

    public static void setEnd(boolean newEnd)
    {
        rolled = false;
        end = newEnd;
    }

    public static void setRoll(boolean roll)
    {
        rolled = roll;
    }

    public static int roll()
    {
        Integer[] rolls = new Integer[]
        {
            2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6,
            7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 12
        };

        Random ran = new Random();
        int temp = ran.nextInt(rolls.length);
        numRolled = rolls[temp];
        Dialogs.rolled(numRolled);
        Cards.addCards();
        return temp;
    }

    public static boolean getRolled()
    {
        return rolled;
    }

    public static boolean turnEnd()
    {
        return end;
    }

    public static int getNumRolled()
    {
        return numRolled;
    }
}
