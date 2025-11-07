def generate_permutations(s):
    # Базовый случай: если строка пустая или содержит один символ
    if len(s) <= 1:
        return [s]
    
    # Список для хранения всех перестановок
    result = []
    
    # Перебираем каждый символ в строке
    for i, char in enumerate(s):
        # Формируем оставшуюся строку без текущего символа
        remaining = s[:i] + s[i+1:]
        
        # Рекурсивно генерируем перестановки оставшейся строки
        for perm in generate_permutations(remaining):
            # Добавляем текущий символ к каждой перестановке
            result.append(char + perm)
    
    return result

# Пример использования
input_string = "abc"
permutations = generate_permutations(input_string)
print(f"Все перестановки строки '{input_string}':")
for p in permutations:
    print(p)
# Вывод:
# Все перестановки строки 'abc':
# abc
# acb
# bac
# bca
# cab
# cba
# 321
