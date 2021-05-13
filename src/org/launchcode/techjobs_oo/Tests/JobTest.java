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

    Job myFirstJob;
    Job mySecondJob;

    @Before
    public void createJobObjects() {
        myFirstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        mySecondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(myFirstJob.getId(), mySecondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(myFirstJob instanceof Job);
        assertEquals("Product tester", myFirstJob.getName());
        assertEquals("ACME", myFirstJob.getEmployer().getValue());
        assertEquals("Desert", myFirstJob.getLocation().getValue());
        assertEquals("Quality control", myFirstJob.getPositionType().getValue());
        assertEquals("Persistence", myFirstJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(myFirstJob.equals(mySecondJob));
    }

    @Test
    public void toStringReturnsBlanks() {
        String myJobString = myFirstJob.toString();

        assertTrue("\n".equals(myJobString.substring(0, 1)));
        assertTrue("\n".equals(myJobString.substring(myJobString.length()-1)));

    }

    @Test
    public void toStringReturnsLabels() {
        String myJobString = myFirstJob.toString();
        String expected = "\nID: 1" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";

        assertEquals(expected, myJobString);

    }
}
