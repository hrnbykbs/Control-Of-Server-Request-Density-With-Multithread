# Control Of Server Request Density With Multithread
It is to reduce the density of requests to the main server together with sub-servers by using multithread.

# Features of the project components
1- Main Server: Has a capacity of 10000 requests. It accepts random number of requests between [1-100] in 500 ms time intervals. As long as there is a request, it returns a random number of requests at intervals of 200 ms [1-50].
2- Sub Server: It has a capacity of 5000 requests. It receives random number of requests from the main server at intervals of 500 ms [1-50]. As long as there is a request, it returns a random number of requests between [1-50] with 300 ms time intervals.
3- Sub-Server Builder: Checks existing sub-servers. If the capacity of any sub server is 70% or more, it creates a new sub server and sends half of the capacity to the newly created sub server. If the capacity of any sub server reaches 0%, the existing sub server is removed from the system. At least two sub-servers must remain constantly running.
4- Server Tracking: It shows the information of all servers available in the system (Server / Number of Thread and their capacity (%)) live.

# Project Goal
![alt text](https://github.com/hrnbykbs/AllPictures/blob/main/ControlOfServerRequestDensityWithMultithread/problem.png)

# When the project is run
![alt text](https://github.com/hrnbykbs/AllPictures/blob/main/ControlOfServerRequestDensityWithMultithread/whenTheProjectIsRun.png)

# Capacity completed and new server created
![alt text](https://github.com/hrnbykbs/AllPictures/blob/main/ControlOfServerRequestDensityWithMultithread/capacityCompleted.png)
