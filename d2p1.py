with open('inputs/day2.txt') as input_file:
    puzzle_input = input_file.readlines()

array = [[int(x) for x in line.split("\t")] for line in puzzle_input]

total = 0
for line in array:
    total += max(line) - min(line)

print(total)
