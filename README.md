# cse551
Contains Algorithms of CSE 551 ASU

# Stable Matching
## Input
3
0 1 2
1 0 2
0 1 2
1 2 0
2 0 1
0 1 2
--------------------------------
Running GS Algorithm

Debug:: man 0 proposes women 0 while otherMan is -1 --> Engaged
Debug:: man 1 proposes women 1 while otherMan is -1 --> Engaged
Debug:: man 2 proposes women 0 while otherMan is 0 --> Swapped
Debug:: man 0 proposes women 1 while otherMan is 1 --> Swapped
Debug:: man 1 proposes women 0 while otherMan is 2 --> Swapped
Debug:: man 2 proposes women 1 while otherMan is 0 --> Swapped
Debug:: man 0 proposes women 2 while otherMan is -1 --> Engaged
---------------------------------
Final matching
---------------------------------

M1 <-marries-> W0
M2 <-marries-> W1
M0 <-marries-> W2
