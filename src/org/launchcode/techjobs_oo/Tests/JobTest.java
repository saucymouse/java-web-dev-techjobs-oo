package org.launchcode.techjobs_oo.Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;

public class JobTest {
    @Test
    public void emptyTest() {
        assertEquals(10, 10, 0);
    }

    @Test
    public void testSettingJobId() {
        Job myFirstJob = new Job();
        Job mySecondJob = new Job();
        assertNotEquals(myFirstJob.getId(), mySecondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job myNewJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(myNewJob instanceof Job);
        assertEquals("Product tester", myNewJob.getName());
        assertEquals("ACME", myNewJob.getEmployer().getValue());
        assertEquals("Desert", myNewJob.getLocation().getValue());
        assertEquals("Quality control", myNewJob.getPositionType().getValue());
        assertEquals("Persistence", myNewJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job myFirstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job mySecondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(myFirstJob.equals(mySecondJob));
    }
}
