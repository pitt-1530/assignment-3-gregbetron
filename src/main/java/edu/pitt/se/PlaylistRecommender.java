package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if(bpms == null || bpms.isEmpty()){
            return "REJECT";
        }

        int sum = 0;
        for(Integer bpm : bpms){
            sum += bpm;
        }
        double average = (double)sum / bpms.size();

        if(average >= 140){
            return "HIGH";
        }else if(average >= 100){
            return "MEDIUM";
        }else{
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if(title == null) return false;

        int length = title.length();
        if(length < 1 || length > 30) return false;

        for(int i = 0; i < length; i++){
            char c = title.charAt(i);
            if(!Character.isLetter(c) && c != ' ') return false;
        }

        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if(volumeDb > 100) volumeDb = 100;
        if(volumeDb < 0) volumeDb = 0;

        return volumeDb;
    }
}
