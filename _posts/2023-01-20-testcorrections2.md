---
title: Test Corrections 2
description: Correcting 52 Question and 66 Question Quiz
toc: true
comments: true
layout: post
categories: [markdown, college board]
author: Bailey Say
---

## Overall Score

1.8 + 0.92 = 2.72
## 52 Question Test

Score: 50/52

This test was essentially a long distance marathon in terms of its questions and length. The questions weren't too hard in my opinion,
but they took a long time to finish, especially when going through dozens of them in a single sitting. I took 83 minutes to finish,
so I could definitely have done better with the timing, though I got a good score from it. Looking at my mistakes (2), I think I'm actually 
pretty good overall, though I can make silly mistakes when visualizing loops and forget certain obscure features of Java.

### Question

```java
int a = 1988;

int b = 1990;

String claim = " that the world’s athletes " + "competed in Olympic Games in ";

String s = "It is " + true + claim + a + " but " + false + claim + b + ".";

System.out.println(s);
```

My mistake was thinking that the code wouldn't compile because it tried to concatenate two non-String variables together. But I forgot 
that Java will automatically convert non-String variables in a String variable, which is why the code will actually compile and print 
the correct statement. So the correct answer is actually D.

### Question 42

```java
public static void mystery(List<Integer> nums)
{
    for (int k = 0; k < nums.size(); k++)
    {
        if (nums.get(k).intValue() == 0)
        {
            nums.remove(k);
        }
    }
}

nums = [0, 0, 4, 2, 5, 0, 3, 0];
```

My mistake was thinking that the boolean condition was static and that it wouldn't change as numbers were removed from the list. I realized
that certain numbers would be skipped, but I thought it wouldn't matter if the code wouldn't compile in the first place. So the correct answer
is actually D.

## 66 Question Test

Score 61/66

This test was pretty much the same as the 52 Question test, but I was more used to the more endurance-based style after having taken the other 
one. I actually finished this one in 74 minutes, faster than the previous one, but I made a bit more mistakes this time (5). Looking at 
these mistakes, I think I need to be more careful with reading the questions because I made a lot of silly mistakes that I would've noticed if 
I just read more carefully.

### Question 1

```java
public static void addOneToEverything(int[] numbers)
{
    for (int j = 0; j < numbers.length; j++)
    {
        numbers[j]++;
    }
}

// 1
for (int num : numbers)
{
    num++;
}

// 2
for (int num : numbers)
{
    num[j]++;
}

// 3
for (int num : numbers)
{
    numbers[num]++;
}
```

I thought that the first implementation would return the same result, but I didn't realize that num is only assigned a copy of the value in numbers, 
and so the corresponding value in numbers doesn't actually change when being incremented. So the correct answer is actually E (none of them work).

### Question 7

```java
public class A
{
    private int al;

    public void methodA()
    {
      methodB();     // Statement  I 
    }
}

public class B extends A
{
    public void methodB()
    {
                methodA();        // Statement II
                al = 0;                 // Statement III
           }
}
```

I noticed that Statement I wouldn't work because a parent class can't call a method from a child class, but I didn't realize that Statement III 
wouldn't work either because a child class can't access a private variable in a parent class (it can access a protected variable though). So the correct answer is actually D (I and III are incorrect).

### Question 38

```java
public String inRangeMessage(int value)
{
  if (value < 0 || value > 100)
    return "Not in range";
  else
    return "In range";
}

// 1
if (value < 0)
   {
     if (value > 100)
        return "Not in range";
     else
        return "In range";
   }
   else
     return "In range";
 
// 2
if (value < 0)
      return "Not in range";
    else if (value > 100)
      return "Not in range";
    else
      return "In range";

// 3
if (value >= 0)
      return "In range";
    else if (value <= 100)
      return "In range";
    else
      return "Not in range";
```

I thought that both 2 and 3 would work, but in actuality 3 doesn't work. This is because the code in 3 would allow a larger range of values as 
answers as long as the value was positive, so something like value = 1000 would work just by fulfilling the first condition. So the correct answer 
is actually B (II only).

### Question 43

```java
    // 1
    for (int j = 0; j < arr.length; j++)
    {
        sum[j] = sum[j - 1] + arr[j];
    }

    // 2
    for (int j = 0; j < arr.length; j++)
    {
        for (int k = 0; k <= j; k++) {
            sum[j] = sum[j] + arr[k];
        }
    }
```

I incorrectly thought that the first implementation of the sum would work because Java could access indexes of -1 like Python would (accessing the last value in a list), but Java doesn't actually work like that and would instead return an error. So the correct answer is actually D (2 works, 1 doesn't).

### Question 52

```java
public class Toy
{

    private String name;
    private double price;

    public Toy(String n, double p)
    {
        name = n;
        price = p;
    }

    public void raisePrice(double surcharge) // Line 12
    {
        return price + surcharge; // Line 14
    }
}
```

I thought replace the void in line 12 with double would fix the compilation error, which it would, but I didn't realize that it wouldn't actually do what it's supposed to. Since the method is supposed to raise the price, line 14 should actually be replaced with price += surcharge. So the correct answer is actually B.
