with open('inputs/day1.txt') as input_file:
    puzzle_input = input_file.read()

digits = [int(x) for x in puzzle_input]
size = len(digits)

total = 0
for i in range(0, size):
    if digits[i] == digits[(i + (size // 2)) % size]:
        total += digits[i]

print(total)
