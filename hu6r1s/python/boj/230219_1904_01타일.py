import sys
input = sys.stdin.readline

n = int(input())
d = [0] * 1000001
def dp(n):
    d[1] = 1
    d[2] = 2
    for i in range(3, n + 1):
        d[i] = (d[i - 1] + d[i - 2]) % 15746

print(dp(n))
