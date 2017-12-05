with open('inputs/day4.txt') as input_file:
    puzzle_input = input_file.read()
    puzzle_input = puzzle_input.split("\n")

total = 0
for line in puzzle_input:
    words = line.split(" ")
    found = False
    for i in range(len(words)):
        for j in range(i + 1, len(words)):
            if words[i] == words[j]:
                total += 1
                found = True
                break
        if found:
            break

print(len(puzzle_input) - total)
