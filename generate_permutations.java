import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    
    public static List<String> generatePermutations(String s) {
        // Базовый случай
        if (s.length() <= 1) {
            List<String> result = new ArrayList<>();
            result.add(s);
            return result;
        }
        
        List<String> result = new ArrayList<>();
        
        // Перебираем каждый символ
        for (int i = 0; i < s.length(); i++) {
            // Текущий символ
            char currentChar = s.charAt(i);
            
            // Формируем оставшуюся строку
            String remaining = s.substring(0, i) + s.substring(i + 1);
            
            // Рекурсивно генерируем перестановки
            for (String perm : generatePermutations(remaining)) {
                result.add(currentChar + perm);
            }
        }
        
        return result;
    }
    // Пример использования
    public static void main(String[] args) {
        String input = "АБВ";
        List<String> permutations = generatePermutations(input);
        
        System.out.println("Все перестановки строки '" + input + "':");
        for (String p : permutations) {
            System.out.println(p);
          // Вывод:
          // Все перестановки строки 'АБВ':
          // АБВ
          // АВБ
          // БАВ
          // БВА
          // ВАБ
          // ВБА
        }
    }
}
