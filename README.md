[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=6112886&assignment_repo_type=AssignmentRepo)
# Buffon's Needle

Buffon's Needle is a statistical thought experiment (although it could be
performed in the real world). The experiment goes like this:

1. Assume that you have needles of some length _l_.
2. You also have a tarp (or wooden boards or something) with vertical lines
drawn at it intervals of _t_.

The question is: **What is the probability of a needle crossing one of the lines**.

This question can be answered with some advanced calculus, but that is not always
the case. In this project, you will conduct a _Monte Carlo_ simmulation of Buffon's
needle experiment to obtain the probability _experimentally_.

## Assignment

This experiment is as much an exercise in monte carlo simmulation as it is in good
_class encapsulation_. That is, you will represent the various components of the
experiments using classes. Particularly, you will need a class for each of the
following:

1. Tarp
2. Needle
3. A simmulation of the experiment

### Tarp API
The tarp can be simulated as single width onto which needles will be "thrown." It
should have a fixed interval _t_ that defines that width. In the original experiment,
of course, we needed to draw multiple lines on the tarp so that the needles could
spread out, but in Java, we can assume that all the needles land within the same
interval of width _t_.

Since the lines are vertical, it also does not matter where needles land in the
y-direction, so the tarp does not need a height.

The tarp, however, _must_ specify the length of the needles that are permitted to land
on it since it is not allowable (in this experiment) for differently-sized needles to
be on the same tarp. Thus, although _l_ is a property of the needles themselves, it is
_also_ a property of the tarp.

Thus the `Tarp` class will need to implement the following API:

`public Tarp(double t, double l) {}` generates a new tarp with the given _t_ and _l_ values.

`public void throwNeedle() {}` adds a new needle to the tarp at a random position and angle.

`public int numberOfCrossings() {}` returns how many needles cross over the line.

`public int numberOfNeedles() {}` returns the total number of needles on the tarp.

`public double ratioOfCrossings() {}` returns the fraction of the needles on the tarp that cross
one of the vertical lines.

### Needle API
The needle class should be able to "throw" a needle randomly onto a Tarp.

`public Needle(Tarp t) {}` generates a new needle following the _l_ and _t_
specifications of the given Tarp (see below). The _angle_ of the needle and its
position should be generated randomly.

`public double rightTip() {}` returns the x-location on the tarp of the needle.

    
`public double leftTip() {}` returns the y-location on the tarp of the needle.

`public double center() {}` returns the center of the needle (same as its location).

`public double angle() {}` returns the angle of rotation of the needle.

### Simulation API
A class called `BuffonSimulation` will also be needed. This will represent a single simulation
with one tarp and a specified number of needles randomly tossed onto the tarp. As you may have
guessed, the _scale_ or _units_ (inches, cm, meteres, parsecs, etc.) don't matter much to the
probability. Thus, what we are concerned with is not so much _l_ and _t_ as their _ratio_.

For that reason (and to make your life just that little bit harder) the simulation will only
care about the value _r = l/t_. The goal of the simmulation is to determine the _constant_
 _k_ which goes in front of _r_ in the probability: _p(x) = k x r_.
 
To achieve this, the following API should be implemented in `BuffonSimulation`

`public BuffonSimulation(double r, int n){}` constructs and _runs_ a simmulation of the given _r_ value
(see above) with _n_ neeldes.

`public double kValue(){}` which returns the experimentally determined _k_ - value (as above).

`public static void main(String[] args){}` which does the following:

1. Takes a number of simulations to run from the command-line
2. Prints an experimental value for _k_ averaged accross all simulations run
3. Prints a 95% confidence interval for the actual value of k.
