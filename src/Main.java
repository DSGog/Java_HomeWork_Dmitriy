import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
                new Laptop(16, 256, "Windows", "Белый"),
                new Laptop(16, 512, "Windows", "Серый"),
                new Laptop(8, 256, "Windows", "Чёрный"),
                new Laptop(8, 256, "MacOS", "Металлика"),
                new Laptop(12, 1000, "Linux", "Чёрный")
        ));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Вы можете выбрать следующие критерии для фильтрации ноутбуков:");
        System.out.println("1 - ОЗУ (например, 8, 16, 32 и т.д. в ГБ)");
        System.out.println("2 - Объем памяти (например, 256, 512, 1000 и т.д. в ГБ)");
        System.out.println("3 - Операционная система (например, Windows, MacOS, Linux)");
        System.out.println("4 - Цвет (например, Белый, Серый, Чёрный, Металлика)");

        String input = scanner.nextLine();
        String[] criteria = input.split(",");

        for (String criterion : criteria) {
            switch (criterion.trim()) {
                case "1":
                    System.out.println("Введите минимальный объем ОЗУ (в ГБ):");
                    int minRam = scanner.nextInt();
                    filters.put("ram", minRam);
                    break;
                case "2":
                    System.out.println("Введите минимальный объем памяти (в ГБ):");
                    int minStorage = scanner.nextInt();
                    filters.put("storage", minStorage);
                    break;
                case "3":
                    System.out.println("Введите операционную систему (например, Windows, MacOS, Linux):");
                    String os = scanner.next();
                    filters.put("os", os);
                    break;
                case "4":
                    System.out.println("Введите цвет (например, Белый, Серый, Чёрный, Металлика):");
                    String color = scanner.next();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Ошибка: Неверный критерий - " + criterion);
            }
        }

        System.out.println("\nВыбранные критерии:");
        for (String key : filters.keySet()) {
            System.out.println(getCriteriaName(key) + ": " + filters.get(key));
        }

        Set<Laptop> filteredLaptops = LaptopFilter.filterLaptops(laptops, filters);

        System.out.println("\nНоутбуки, соответствующие критериям:");
        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих выбранным критериям.");
        } else {
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    private static String getCriteriaName(String key) {
        return switch (key) {
            case "ram" -> "ОЗУ";
            case "storage" -> "Объем памяти";
            case "os" -> "Операционная система";
            case "color" -> "Цвет";
            default -> "Неизвестный критерий";
        };
    }
}
