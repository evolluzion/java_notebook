import java.util.*;
import java.util.stream.Collectors;

// Создаем множество для ноутбуков
public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        // Добавляем ноутбуки в множество
        notebooks.add(new Notebook(4, 500, "Lenovo", "Windows", "Черный"));
        notebooks.add(new Notebook(6, 1000, "HP", "Windows", "Серый"));
        notebooks.add(new Notebook(8, 1000, "Acer", "Linux", "Серый"));
        notebooks.add(new Notebook(8, 2000, "Macbook", "MacOS", "Белый"));
        notebooks.add(new Notebook(16, 2000, "Asus", "Windows", "Белый"));
        notebooks.add(new Notebook(16, 2000, "HP", "Linux", "Серый"));
        notebooks.add(new Notebook(32, 2000, "Dexp", "Linux", "Черный"));

        // Создаем метод для фильтрации
        filterNotebooks(notebooks);
    }

    public static void filterNotebooks(Set<Notebook> notebooks) {
        // Создаем Map для хранения
        Map<Integer, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем данные у пользователя
        System.out.println("Выберите критерий для сортировки:");
        System.out.println("1 - Модель Ноутбука");
        System.out.println("2 - Объем ОЗУ");
        System.out.println("3 - Объем HDD");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Цвет");

        int criteria = scanner.nextInt();

        switch (criteria) {
            case 1:
                System.out.println("Введите название модели Ноутбука:");
                scanner.nextLine(); 
                String model = scanner.nextLine();
                filterCriteria.put(criteria, model);
                break;
            case 2:
                System.out.println("Введите минимальный объем оперативной памяти:");
                int ram = scanner.nextInt();
                filterCriteria.put(criteria, ram);
                break;
            case 3:
                System.out.println("Введите минимальный объем жесткого диска:");
                int hdd = scanner.nextInt();
                filterCriteria.put(criteria, hdd);
                break;
            case 4:
                System.out.println("Введите операционную систему:");
                scanner.nextLine(); 
                String os = scanner.nextLine();
                filterCriteria.put(criteria, os);
                break;
            case 5:
                System.out.println("Введите цвет:");
                scanner.nextLine(); 
                String color = scanner.nextLine();
                filterCriteria.put(criteria, color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        // Отфильтровываем Ноутбуки
        Set<Notebook> filteredNotebooks = notebooks.stream()
                .filter(notebook -> {
                    for (Map.Entry<Integer, Object> entry : filterCriteria.entrySet()) {
                        int key = entry.getKey();
                        Object value = entry.getValue();

                        if (key == 1 && !notebook.getModel().equals(value)) {
                            return false;
                        } else if (key == 2 && notebook.getRam() < (int) value) {
                            return false;
                        } else if (key == 3 && notebook.getHdd() < (int) value) {
                            return false;
                        } else if (key == 4 && !notebook.getOs().equals(value)) {
                            return false;
                        } else if (key == 5 && !notebook.getColor().equals(value)) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toSet());

        // Выводим результаты
        System.out.println("Подходящие ноутбуки:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println("Модель: " + notebook.getModel() + ", ОЗУ: " + notebook.getRam() + ", HDD: " + notebook.getHdd() +
                    ", ОС: " + notebook.getOs() + ", Цвет: " + notebook.getColor());
        }
    }
}
