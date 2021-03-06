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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogs
{
    private static JFrame frame;

    public static void positionRoll()
    {
        JOptionPane.showMessageDialog(frame, "Roll to see who goes first.");
    }

    public static void tellRoll(Player player)
    {
        JOptionPane.showMessageDialog(frame, player.getName() + ", roll now.");
    }

    public static void firstRoll(Player player)
    {
        JOptionPane.showMessageDialog(frame, player.getName() + " goes first.");
    }

    public static void firstPlaces(Player player, String build)
    {
        JOptionPane.showMessageDialog(frame, player.getName() + ", place a " + build);
    }
    
    public static String buildPlace()
    {
        String input = JOptionPane.showInputDialog(frame, "Enter two ints and location as string:");
        return input;
    }

    public static void settErrorLoc()
    {
        JOptionPane.showMessageDialog(frame,
                "You do not have a settlement there!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void settErrorOwn()
    {
        JOptionPane.showMessageDialog(frame,
                "That is not your settlement!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void rollError()
    {
        JOptionPane.showMessageDialog(frame,
                "Roll first!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void rolled(int r)
    {
        JOptionPane.showMessageDialog(frame,
                r + " was the number rolled.");
    }

    public static void rolledError()
    {
        JOptionPane.showMessageDialog(frame,
                "You have already rolled!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void turnChange(Player current)
    {
        JOptionPane.showMessageDialog(frame,
                current.getName() + "'s turn.");
    }

    public static void noSett()
    {
        JOptionPane.showMessageDialog(frame,
                "You don't have enough settlements!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void noCity()
    {
        JOptionPane.showMessageDialog(frame,
                "You don't have enough cities!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void noRoads()
    {
        JOptionPane.showMessageDialog(frame,
                "You don't have enough roads!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void invalidSettDist()
    {
        JOptionPane.showMessageDialog(frame,
                "That is not a valid location! You must be at least two spaces away from another settlement.",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void invalidSettTaken()
    {
        JOptionPane.showMessageDialog(frame,
                "That is not a valid location! That spot is already taken.",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void cardsError()
    {
        JOptionPane.showMessageDialog(frame,
                "You do not have enough cards!",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void gameOver(Player p)
    {
        JOptionPane.showMessageDialog(frame,
                p.getName() + "wins the game!");
    }
}
