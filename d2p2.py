with open('inputs/day2.txt') as input_file:
    puzzle_input = input_file.readlines()

array = [[int(x) for x in line.split("\t")] for line in puzzle_input]

total = 0
for line in array:
    for i in range(0, len(line)):
        found = False
        for j in range(i + 1, len(line)):
            if line[i] % line[j] == 0:
                total += line[i] // line[j]
                found = True
                break
            if line[j] % line[i] == 0:
                total += line[j] // line[i]
                found = True
                break
        if found:
            break

print(total)