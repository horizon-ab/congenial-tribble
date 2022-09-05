---
title: The Trajectory Calculator
description: Design process of the trajectory calculator
toc: true
comments: true
layout: post
categories: [markdown, pbl]
author: Bailey Say
---

# The Trajectory Calculator

As my teamate (Andrew Meng) and I were wondering what to create for our GUI project, we eventually stumbled into the realm of physics. 
Originally, we wanted to create a kinematics simulator, but we soon realized how hard that would actually be. Apparently, real time updates 
take a lot of effort to implement.

Our next idea would be the one we chose - a trajectory calculator. The idea was simple: ask the user for inputs on velocity, angle, and 
height and the program would output a graph of the trajectory of the object. So, we soon got to work on implementing it.

## Bailey's Part

My part in creating it centered around the fundamental part of the idea - the mathematics. I realized that a class had to be made to 
handle all of the mathematical operations behind the trajectory, so I created TrajectoryMath.java to take care of all of that. 

TrajectoryMath takes in parameters of velocity, degrees, and height to perform all of the calculations. Once the object is created, it's 
able to return the equation in double or String format, the positive root (when the equation is equal to 0), and each of the coefficients 
for the equation.

Without this mathematical framework, the graph wouldn't be able to output anything useful at all.

## Andrew's Part

Andrew's part in creating it centered around the GUI portion of the process, making it interactive so that a user could input values and 
have the program spit out a graph as the output. He created two files, InputInitial.java and TrajectoryGraph.java to handle the inputs and 
graphing respectively.

InputInitial essentially creates a prompt for the user to input the velocity, degrees, and height for the equation. It also takes care of 
error handling with faulty inputs.

TrajectoryGraph is probably the central file of the entire operation, as it runs the entire program. It creates an object of the InputInitial 
class to get the inputs, and takes each of those inputs as parameters for the drawGraph() method. This method creates an object of the 
TrajectoryMath class to deal with the math and then takes values from that and uses it as inputs to create a graph using JFrame.

Without this interactive structure, the user wouldn't even be able to input and see anything at all.

## Conclusion

This project was a lot bigger than expected, and we ran into quite a few problems along the way. But I found it very fun to create a big 
project that actually has a cool purpose. I also really felt that I grew a lot during this project, as it was a new experience to deal with 
multiple Java files and complicated packages. Overall, it was a fun experience.

![Trajectory Equation Example]({{ site.baseurl }}/images/trajectoryexample1.png)