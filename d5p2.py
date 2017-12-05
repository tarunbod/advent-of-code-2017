with open('inputs/day5.txt') as input_file:
    puzzle_input = input_file.readlines()

instructions = map(lambda x: int(x), puzzle_input)

last_position, position = 0, 0
count = 0
while position >= 0 and position < len(instructions):
    position += instructions[position]
    if instructions[last_position] >= 3:
        instructions[last_position] -= 1
    else:
        instructions[last_position] += 1
    last_position = position
    count += 1

print(count)
