import java.util.*;

public class LaptopFilter {
    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("storage") && laptop.getStorage() < (int) filters.get("storage")) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }
            if (matches) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }
}
