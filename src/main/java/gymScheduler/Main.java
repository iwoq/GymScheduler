import java.time.LocalDateTime;
import java.util.ArrayList;
public class Main {
    
    public static void main(String[] args) {
        ArrayList<CalendarEvent> events = new ArrayList<>();
        events.add(new CalendarEvent("Event 1", LocalDateTime.of(2026, 9, 21, 10, 0), LocalDateTime.of(2026, 9, 21, 11, 0)));
        events.add(new CalendarEvent("Event 2", LocalDateTime.of(2026, 9, 22, 10, 0), LocalDateTime.of(2026, 9, 22, 11, 0)));
        events.add(new CalendarEvent("Event 3", LocalDateTime.of(2026, 9, 23, 10, 0), LocalDateTime.of(2026, 9, 23, 11, 0)));
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

    }
    
}
