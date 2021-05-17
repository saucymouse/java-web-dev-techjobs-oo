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
        assertFalse(myFirstJob.equals(mySecondJob));
        assertTrue(mySecondJob.getId() - myFirstJob.getId() == 1);
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
        String expected = "\nID: " + myFirstJob.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        String actual = myFirstJob.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void toStringReturnsDataNotAvailable() {
        Job noEmployer = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + noEmployer.getId() +
                "\nName: Product tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        String actual = noEmployer.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void jobOnlyContainsId() {
        Job jobOnlyId = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        //how come i can't instantiate with new Job()?
        String expected = "OOPS! This job does not seem to exist.";
        String actual = jobOnlyId.toString();

        assertEquals(expected, actual);

    }
}
