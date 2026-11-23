import java.time.LocalDateTime;
public class CalendarEvent {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public CalendarEvent(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getName() {
        return this.name;
    }
    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    public LocalDateTime getEndTime() {
        return this.endTime;
    }
    
}