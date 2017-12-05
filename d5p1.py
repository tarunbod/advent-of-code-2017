with open('inputs/day5.txt') as input_file:
    puzzle_input = input_file.readlines()

instructions = map(lambda x: int(x), puzzle_input)

position = 0
count = 0
while position >= 0 and position < len(instructions):
    instructions[position] += 1
    position += instructions[position] - 1
    count += 1

print(count)
