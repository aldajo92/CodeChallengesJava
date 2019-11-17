# def solution(size, arr):
#     books = [i + 1 for i in range(size)]

#     trans = books.copy()
#     for i in range(size):
#         book = books[i]
#         index = arr[i] - 1
#         trans[index] = book
    
#     days = [1 for _ in arr]

#     while books != trans:
#         n_b = trans.copy()
#         for i in range(size):
#             if(trans[i] != books[i]):
#                 book = trans[i]
#                 index = arr[i] - 1
#                 n_b[index] = book
#                 days[i] += 1
#         trans = n_b.copy()

#     print(days)

def solution(size, arr):
    books = [i + 1 for i in range(size)]
    trans = books.copy()
    days = [1 for _ in arr]
    for i in range(size):
        trans[arr[i] - 1] = books[i]

    while books != trans:
        n_b = trans.copy()
        for i in range(size):
            if(trans[i] != books[i]):
                n_b[arr[i] - 1] = trans[i]
                days[i] += 1
        trans = n_b.copy()
    print(' '.join(str(n) for n in days))


for _ in range(int(input())):
    solution(int(input()), [int(x) for x in input().split(" ")])