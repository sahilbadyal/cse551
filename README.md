# cse551
Contains Algorithms of CSE 551 ASU

### Stable Matching
#### Input

3  <br /> 
0 1 2  <br /> 
1 0 2  <br /> 
0 1 2 <br /> 
1 2 0 <br /> 
2 0 1 <br /> 
0 1 2 <br /> 
-------------------------------- <br /> 
Running GS Algorithm <br /> 

Debug:: man 0 proposes women 0 while otherMan is -1 --> Engaged <br /> 
Debug:: man 1 proposes women 1 while otherMan is -1 --> Engaged <br /> 
Debug:: man 2 proposes women 0 while otherMan is 0 --> Swapped <br /> 
Debug:: man 0 proposes women 1 while otherMan is 1 --> Swapped <br /> 
Debug:: man 1 proposes women 0 while otherMan is 2 --> Swapped <br /> 
Debug:: man 2 proposes women 1 while otherMan is 0 --> Swapped <br /> 
Debug:: man 0 proposes women 2 while otherMan is -1 --> Engaged <br /> 
--------------------------------- <br /> 
Final matching <br /> 
--------------------------------- <br /> 

M1 <-marries-> W0 <br /> 
M2 <-marries-> W1 <br /> 
M0 <-marries-> W2 <br /> 
