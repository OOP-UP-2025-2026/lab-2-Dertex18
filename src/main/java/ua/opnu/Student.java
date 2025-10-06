package ua.opnu;
import java.util.ArrayList;

public class Student {

    private String name;
    private int year; // від 1 до 4
    private ArrayList<String> courses;


    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім!");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання має бути від 1 до 4!");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }


    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            System.out.println("Назва дисципліни не може бути порожньою!");
            return;
        }
        courses.add(courseName);
    }


    public void dropAll() {
        courses.clear();
    }


    public int getCourseCount() {
        return courses.size();
    }


    public String getName() {
        return name;
    }


    public int getTuition() {
        int tuitionPerYear = 20000;
        return year * tuitionPerYear;
    }


    public int getYear() {
        return year;
    }


    public static void main(String[] args) {
        // Створення об’єкта студента
        Student st1 = new Student("Микита", 3);


        st1.addCourse("Програмування");
        st1.addCourse("Операційні системи");
        st1.addCourse("Дискретна математика");


        System.out.println(st1.getName() + ": кількість вивчаємих дисциплін - " + st1.getCourseCount());


        System.out.println(st1.getName() + ": рік навчання - " + st1.getYear());


        System.out.println(st1.getName() + ": заплатив за навчання - " + st1.getTuition() + " грн");
    }
}
