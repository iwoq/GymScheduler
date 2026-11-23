public class UserPreferences {
    private int workoutDuration;
    private int workoutsPerWeek;
    private String preferredWorkoutTime;

    public UserPreferences(int workoutDuration, int workoutsPerWeek, String preferredWorkoutTime) {
        this.workoutDuration = workoutDuration;
        this.workoutsPerWeek = workoutsPerWeek;
        this.preferredWorkoutTime = preferredWorkoutTime;
    }
    public int getWorkoutDuration() {
        return this.workoutDuration;
    }
    public int getWorkoutsPerWeek() {
        return this.workoutsPerWeek;  
    }
    public String getPreferredWorkoutTime() {
        return this.preferredWorkoutTime;
    }

}
