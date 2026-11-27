import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;

public class GymScheduler {
    public static void main(String[] args) {
    }
    public static void sort(ArrayList<CalendarEvent> events) {
        for (int i = 0; i < events.size() - 1; i++) {
            for (int j = 0; j < events.size() - 1 - i; j++) {
                if (events.get(j).getStartTime()
                        .isAfter(events.get(j + 1).getStartTime())) {
                    CalendarEvent tempEvent = events.get(j);
                    events.set(j, events.get(j + 1));
                    events.set(j + 1, tempEvent);
                }
            }
        }
    }

    public static ArrayList<TimeSlot> findAllSlotsAndRecommend(
            ArrayList<CalendarEvent> events,
            int duration,
            String day,
            LocalDateTime date,
            UserPreferences preferences) {

        ArrayList<TimeSlot> available = new ArrayList<>();
        //set start to midnight day 1 and end midnight the next day
        LocalDateTime start = date.toLocalDate().atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        //sort events
        sort(events);
        LocalDateTime currentTime = start;
        //Check each event 
        for (int i = 0; i < events.size(); i++) {
            CalendarEvent event = events.get(i);
            //skip events outisde the day the user selected 
            if (!event.getEndTime().isAfter(start)
                    || !event.getStartTime().isBefore(end)) {
                continue;
            }
            LocalDateTime eventStart;
            LocalDateTime eventEnd;
            //failsafe to adjust event start if it starts before the day
            if (event.getStartTime().isBefore(start)) {
                eventStart = start;
            } else {
                eventStart = event.getStartTime();
            }
            //failsafe to adjust event end if it ends after the day
            if (event.getEndTime().isAfter(end)) {
                eventEnd = end;
            } else {
                eventEnd = event.getEndTime();
            }
            //Check free time before the event
            if (eventStart.isAfter(currentTime)) {
                long freeMinutes = Duration.between(
                        currentTime, eventStart).toMinutes();
                if (freeMinutes >= duration) {
                    available.add(
                            new TimeSlot(currentTime, eventStart, day));
                }
            }
            // Update current time
            if (eventEnd.isAfter(currentTime)) {
                currentTime = eventEnd;
            }
        }
        //Check free time after the last event
        long freeMinutes = Duration.between(currentTime, end).toMinutes();
        if (freeMinutes >= duration) {
            available.add(new TimeSlot(currentTime, end, day));
        }
        //return the recomended slots using the avaliable slots
        return recommendSlots(available, preferences);
    }
    public static ArrayList<TimeSlot> recommendSlots(ArrayList<TimeSlot> avaliable, UserPreferences userPreferences) {
        ArrayList<TimeSlot> recommend = new ArrayList<>();
        //loop through all avaliable times
        for (int i = 0; i < avaliable.size(); i++) {
            TimeSlot slot = avaliable.get(i);
            //get hour of the start time
            int hour = slot.getStartTime().getHour();
            //check if the starting hour matches user preferences
            if (userPreferences.getPreferredWorkoutTime().equals("Morning") && hour >= 6 && hour < 12) {
                recommend.add(slot);
            } else if (userPreferences.getPreferredWorkoutTime().equals("Afternoon") && hour >= 12 && hour < 17) {
                recommend.add(slot);
            } else if (userPreferences.getPreferredWorkoutTime().equals("Evening") && hour >= 17 && hour < 22) {
                recommend.add(slot);
            } else if (userPreferences.getPreferredWorkoutTime().equals("Night") && (hour >= 22 || hour < 6)) {
                recommend.add(slot);
            }
        }
    return recommend;
    }
    
}