// Создаем класс Notebook
public class Notebook {
    private int ram; // поле для объема оперативной памяти
    private int hdd; // поле для объема жесткого диска
    private String model; // поле для модели ноутбука
    private String os; // поле для операционной системы
    private String color; // поле для цвета

    // Конструктор класса Notebook
    public Notebook(int ram, int hdd, String model, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.model = model;
        this.os = os;
        this.color = color;
    }

    // Геттеры и сеттеры для полей

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}