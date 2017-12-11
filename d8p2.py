with open('inputs/day8.txt') as input_file:
    instructions = input_file.read().split("\n")

registers = {}

highest = 0

for instruction in instructions:
    parts = instruction.split(" ")
    rname = parts[0]
    sname = parts[4]
    if rname not in registers:
        registers[rname] = 0
    if sname not in registers:
        registers[sname] = 0

    multiplier = -1 if parts[1] == "dec" else 1
    amount = int(parts[2])
    if eval( str(registers[sname]) + parts[5] + parts[6] ):
        registers[rname] += multiplier * amount
    
    current_max = max(registers.values())
    if current_max > highest:
        highest = current_max

print(highest)
