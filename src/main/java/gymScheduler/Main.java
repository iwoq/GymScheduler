import java.time.LocalDateTime;
import java.util.ArrayList;
public class Main {
    
    public static void main(String[] args) {
        ArrayList<CalendarEvent> events = new ArrayList<>();
        events.add(new CalendarEvent("Event 1", LocalDateTime.of(2026, 9, 21, 10, 0), LocalDateTime.of(2026, 9, 21, 11, 0)));
        events.add(new CalendarEvent("Event 2", LocalDateTime.of(2026, 9, 21, 7, 0), LocalDateTime.of(2026, 9, 21, 8, 0)));
        events.add(new CalendarEvent("Event 3", LocalDateTime.of(2026, 9, 21, 17, 0), LocalDateTime.of(2026, 9, 21, 18, 0)));
        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i).getName());
            System.out.println(events.get(i).getStartTime());
            System.out.println(events.get(i).getEndTime());
        }
        UserPreferences userPreferences = new UserPreferences(60, 5, "Afternoon");
        System.out.println(userPreferences.getWorkoutDuration());
        System.out.println(userPreferences.getWorkoutsPerWeek());
        System.out.println(userPreferences.getPreferredWorkoutTime());
        TimeSlot timeSlot = new TimeSlot(LocalDateTime.of(2026, 9, 21, 10, 0), LocalDateTime.of(2026, 9, 21, 11, 0), "Monday");
        System.out.println(timeSlot.getDay());
        System.out.println(timeSlot.getStartTime());
        System.out.println(timeSlot.getEndTime());
        ArrayList<TimeSlot> recomended = GymScheduler.findAllSlotsAndRecommend(events, 60, "Monday", LocalDateTime.of(2026, 9, 21, 0, 0), userPreferences);
        for (int i = 0; i < recomended.size(); i++) {
            System.out.println(recomended.get(i).getDay());
            System.out.println(recomended.get(i).getStartTime());
            System.out.println(recomended.get(i).getEndTime());

        }
    }
    
}
