package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;


    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {

            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }


    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) return; // ігноруємо некоректні значення
        int totalMinutes = this.hours * 60 + this.minutes + hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }


    void addTimeSpan(TimeSpan timespan) {
        if (timespan == null) return;
        int totalMinutesToAdd = timespan.hours * 60 + timespan.minutes;

        if (totalMinutesToAdd < 0) return;
        int totalMinutes = this.getTotalMinutes() + totalMinutesToAdd;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }


    double getTotalHours() {
        return hours + minutes / 60.0;
    }


    int getTotalMinutes() {
        return hours * 60 + minutes;
    }


    void subtract(TimeSpan span) {
        if (span == null) return; // ігноруємо null
        int totalMinutesThis = this.getTotalMinutes();
        int totalMinutesSpan = span.getTotalMinutes();
        int resultMinutes = totalMinutesThis - totalMinutesSpan;
        if (resultMinutes < 0) return; // якщо негативно → нічого не змінюємо
        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }


    void scale(int factor) {
        if (factor <= 0) return;
        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
