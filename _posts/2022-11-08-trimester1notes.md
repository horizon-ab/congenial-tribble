---
title: Trimester 1 Notes (Units 1-6)
description: Notes on all of the units covered so far
toc: true
comments: true
layout: post
categories: [markdown, college board]
author: Bailey Say
---

# Trimester 1 Notes

Notes for all of the College Board units covered so far.

## Unit 1: Primitive Types

- Numerous primitive datatypes
  - Ints
  - Booleans
  - Chars
  - Doubles
- Naming conventions
  - Lowercase then capital
  - No special characters or keywords
- Casting
  - Convert primitives
- Operators
  - +, -, *, /, %, //, etc.
  
[Homework]({{site.baseurl}}/2022/10/16/unit1primitives.html)

## Unit 2: Using Objects

- Instances of a class
- Reference types
- Void methods vs Non-void methods
  - No return type vs return type
- Static methods vs Non-static methods
  - Can be called by class vs can't be called by class
- Import external libraries
  
[Homework]({{site.baseurl}}/2022/10/18/unit2objects.html)

## Unit 3: Boolean Expressions and If Statements

- Control operators
- Evaluates to true or false and converges from then
- If, else-if, and else
- De Morgan's Law
  
[Homework]({{site.baseurl}}/2022/10/20/unit3booleans.html)

## Unit 4: Iteration

- For, while, and for-each loops
- Infinite loops
- String manipulation through iteration
- Do-While Loops
  - Have the condition at the very end of the loop
  - The loop is always run at least once (unlike while loops)
  
Our group created the [lesson](https://nicm2.github.io/macromonkeys_blog/college%20board/units/2022/10/10/unit4iteration.html)

## Unit 5: Writing Classes

- Creation of classes
  - Constructors (overloading)
- Access modifiers
  - Public - everything can access the class
  - private - only the class itself + instances of it can access the class
  - protected - only the class itself along with child classes + instances of either can access the class
  - Data encapsulation
- Getters and setters
  
[Homework]({{site.baseurl}}/2022/10/24/unit5classes.html)

## Unit 6: Arrays

- Array Creation
  - Constructors vs. pre-initialized arrays
- Traversing arrays
  - Iteration (for, while, and for-each loops)
  - Using algorithms to manipulate each element
  
[Homework]({{site.baseurl}}/jupyter/2022/10/25/unit6arrays.html)

## Unit 7: ArrayLists

- Dynamic data structure from imported class ArrayList
- Use Wrapper classes (in generics) to store primitive datatypes

[Homework]({{site.baseurl}}/java/labs/2022/11/30/unit7arraylists.html)
## Unit 8: 2D Arrays



## Unit 9: Inheritance

- Classes are allowed to inherit attributes and methods from other classes using the "extends" keyword
  - Class inheriting is the child class, class being inherited from is the parent class
- super() can be used to call methods (and constructors) from the parent class inside the child class
  - Subclass constructor can use super() to quickly set attributes originally from the parent class
- Polymorphism
  - Child class can be treated as an instance of its parent class (referencing superclass of object)
    - Child won't be able to access its own methods this way
  - Methods can be overriden with new definitions
    - @Override keyword
  - Methods can be overloaded with different function signatures
    - Same name, different parameters
- Late binding - Methods are searched for by the compiler during runtime, not during the compilation of the code. Think about overriding the method
- Abstract class + methods
  - Abstraction
  - Cannot create an object from it directly, must be created using a child class inheriting from the abstract class
  - Abstract methods originally only have their signature created and must be fully established in the child class definition
- Standard methods - methods inherited from the original Object class
  - toString() - will usually print out the memory address of an object, can be overriden to print more specific information about the object in question
  - equals() - checks if two objects are equal using "==" (which checks if the two memory addresses point to the same object); can also be overriden for more specific terms of being equal
  - hashCode() - generates a unique numeric ID for each object, which can be used to check if they're equal to one another; can also be overriden for more specific terms

## Unit 10: Recursion

- Big O Notation - function used to represent the run time of certain algorithms and functions
  - Hash Maps - O(1) (in most cases)
  - Binary Search - O(log(n))
  - Single Loop - O(n)
  - Nested Loop - O(n^2)