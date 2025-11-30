package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistRecommenderTest {

    @Test
    public void testClassifyEnergy() {
        //List<Integer> bpms = ;
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(List.of(140, 130, 190)));
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(List.of(100, 90, 150)));
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(List.of(60, 80, 110)));

        assertEquals("REJECT", PlaylistRecommender.classifyEnergy(List.of()));
        assertEquals("REJECT", PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    public void testIsValidTrackTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Valid Title"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Title that is far too long to be a valid title"));
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Title!"));
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
    }

    @Test
    public void testNormalizeVolume() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(999));
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-999));
    }
}
