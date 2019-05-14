import random

readFile = open("guategrafo.txt","r+")
cities = []

FileLines = readFile.readlines()
for x in FileLines:
    cities.append(x)

print(len(cities))

index = 0


while( index <= len(cities)) :

    i = cities[index]
    print(i)

    x = i.split(",")
    print(x)

    number = random.randint(1,101)
    number = str(number)
    x[2] = number
    print(x)

    index = index + 1

    readFile.write(",".join(x) + "\n")


readFile.close()

