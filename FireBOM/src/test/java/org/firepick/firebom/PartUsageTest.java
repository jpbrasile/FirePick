package org.firepick.firebom;
/*
    Copyright (C) 2013 Karl Lew <karl@firepick.org>. All rights reserved.
    DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
    
    This file is part of FirePick Software.
    
    FirePick Software is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FirePick Software is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with FirePick Software.  If not, see <http://www.gnu.org/licenses/>.
    
    For more information about FirePick Software visit http://firepick.org
 */

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class PartUsageTest {
    @Test
    public void testComparable() throws Exception{
        Part part1 = PartFactory.getInstance().createPart(new URL("http://shpws.me/nekC"));
        Part part2 = PartFactory.getInstance().createPart(new URL("http://shpws.me/nuwV"));
        PartUsage partUsage1 = new PartUsage().setPart(part1);
        PartUsage partUsage2 = new PartUsage().setPart(part2);
        PartUsage partUsage1_2 = new PartUsage().setPart(part1).setQuantity(2);

        assertEquals(-16, part1.compareTo(part2));
        assertEquals(16, part2.compareTo(part1));
        assertEquals(0, part1.compareTo(part1));

        assertEquals(-16, partUsage1.compareTo(part2));
        assertEquals(16, partUsage2.compareTo(part1));
        assertEquals(0, partUsage1.compareTo(part1));

        assertEquals(-16, partUsage1.compareTo(partUsage2));
        assertEquals(16, partUsage2.compareTo(partUsage1));
        assertEquals(0, partUsage1.compareTo(partUsage1));

        assertEquals(-1, (int) Math.signum(partUsage1.compareTo(partUsage1_2)));
        assertEquals(1, (int) Math.signum(partUsage1_2.compareTo(partUsage1)));
        assertEquals(0, partUsage1_2.compareTo(part1));
    }
}
