import java.time.LocalDateTime;
public class TimeSlot {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String day;

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime, String day) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }
    public String getDay() {
        return this.day;
    }
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }
}
