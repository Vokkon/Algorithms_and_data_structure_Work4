#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<string> generatePermutations(const string& s) {
    // Базовый случай
    if (s.length() <= 1) {
        return {s};
    }
    
    vector<string> result;
    
    // Перебираем каждый символ
    for (size_t i = 0; i < s.length(); ++i) {
        // Текущий символ
        char currentChar = s[i];
        
        // Формируем оставшуюся строку
        string remaining = s.substr(0, i) + s.substr(i + 1);
        
        // Рекурсивно генерируем перестановки
        vector<string> permutations = generatePermutations(remaining);
        
        // Добавляем текущий символ к каждой перестановке
        for (const string& perm : permutations) {
            result.push_back(currentChar + perm);
        }
    }
    
    return result;
}

// 1 в
int main() {
    string input = "123";
    vector<string> permutations = generatePermutations(input);
    
    cout << "Все перестановки строки '" << input << "':" << endl;
    for (const string& p : permutations) {
        cout << p << endl;
    }
    
    return 0;
}
// Вывод:
// Все перестановки строки '123':
// 123
// 132
// 213
// 231
// 312
// 321
