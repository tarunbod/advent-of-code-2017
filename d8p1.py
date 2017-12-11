with open('inputs/day8.txt') as input_file:
    instructions = input_file.read().split("\n")

registers = {}

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
    

print(max(registers.values()))
