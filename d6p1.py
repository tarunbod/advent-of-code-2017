puzzle_input = "10\t3\t15\t10\t5\t15\t5\t15\t9\t2\t5\t8\t5\t2\t3\t6"
# puzzle_input = "0\t2\t7\t0"

def stringify(banks):
    return ' '.join([str(x) for x in banks])

banks = [int(x) for x in puzzle_input.split("\t")]
num_banks = len(banks)

found = []

while True:
    max_blocks = 0
    max_idx = 0
    for i in range(num_banks):
        if banks[i] > max_blocks:
            max_blocks = banks[i]
            max_idx = i

    idx = max_idx
    banks[idx] = 0
    while max_blocks > 0:
        idx = (idx + 1) % num_banks
        banks[idx] += 1
        max_blocks -= 1
    
    
    if stringify(banks) in found:
        print(stringify(banks)) # this to be used in part 2
        break
    else:
        found.append(stringify(banks)) # reference to same variable issue

print(len(found) + 1)
