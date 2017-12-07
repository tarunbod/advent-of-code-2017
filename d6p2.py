def stringify(banks):
    return ' '.join([str(x) for x in banks])

# the final banks in part 1, 
# have to find how many cycles it takes to get back to this configuration
banks = [1, 1, 0, 15, 14, 13, 12, 10, 10, 9, 8, 7, 6, 4, 3, 5]
num_banks = len(banks)

found = []

while True:
    print(banks)
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
    
    if "1 1 0 15 14 13 12 10 10 9 8 7 6 4 3 5" in found:
        break
    else:
        found.append(stringify(banks)) # reference to same variable issue

print(len(found))
