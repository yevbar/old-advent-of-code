with open("input.txt") as f:
    content = f.readlines()

# Remove whitespaces
content = [x.strip() for x in content]
# Remove blank elements
content = [x for x in content if len(x) > 0]
# Remove '+' signs
content = [x[1:] if x[0] == '+' else x for x in content]
# Convert to integers
content = [int(x) for x in content]

output = None
seen = set()
running_sum = 0

while output == None:
    for num in content:
        running_sum += num
        if running_sum in seen:
            output = running_sum
            break
        seen.add(running_sum)

print(output)
