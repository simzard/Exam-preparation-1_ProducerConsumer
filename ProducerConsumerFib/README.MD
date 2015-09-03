# Exam preparation 1 questions with answers #

### Question: When and why will we use Threads in our programs? ###
### Answer: We need threads when we have a part of our program that could freeze the rest of the program until it is done with its heavy task. In other words, if we have an event based program that always needs to be ready for the next event, we cannot block that with some heavy/lengthy computation and this is what we could use threads for. In general: When we need to do more things at the same time (asynchronously), we need threads to do that. ###


### Question: Explain about the Race Condition Problem. ###
### Answer: A race condition occurs, when we have some shared resource shared by two or more threads. We expect the threads to work with the shared resource in some specific order, HOWEVER the OS decides for us which thread should run first. This could result in random orders of the shared ressources being visited by the threads, thus producing unreliable outcome. This should of course be avoided by synchronizing the methods or providing some other kind of locks in order to make the program thread-safe. ###


### Question: Explain about the Producer/Consumer problem and how to solve it in modern Java Programs. ###
### Answer: The problem describes two processes, the producer and the consumer, who share a common, fixed-size buffer used as a queue. The producer's job is to generate a piece of data, put it into the buffer and start again. At the same time, the consumer is consuming the data (i.e., removing it from the buffer) one piece at a time. The problem is to make sure that the producer won't try to add data into the buffer if it's full and that the consumer won't try to remove data from an empty buffer. ###

### In Java this is easily done by using the BlockingQueue interface and the ArrayBlockingQueue<E> class, which is thread-safe and has methods to wait until there is something to take from the queue, which will just result in a waiting untill there is something to do (for the consumer) instead of incorrect output or even errors . ###
