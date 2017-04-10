Universe -   a project to simulate an alternative, finite universe.

This project is the starting point for the INTPROG Java coursework in academic year 2015/2016.

You will need to modify and add code as detailed in the coursework specification on Moodle

Currently the universe has 3 objects in it which are travelling in different directions. These
objects, of class Space_Object, have some of the behaviour of comets ( as described in the coursework brief).
Space_Objects can detect when they have reached the "bottom" of the Universe and bounce off
the bottom when they hit it. In this version they cannot detect the other edges of
the Universe. These features are illustrated by the green object. Space_Objects are
not aware of each other and, in the current version, should they collide they will just
pass through each other as illustrated by the red and blue objects.

You need to study the code for the Universe and Space_Object classes and make sure you
fully understand how they work. You do not need to look at the Canvas class source
code but you do need to know how to use it so you might want to use the documentation
view for Canvas.

N.B. You are simulating an imaginary, alternative Universe which obeys different rules
to the real Universe! You aren't expected to produce a program which fully obeys
the rules of physics!

__________________________________________________________________________________________________

Date: 10/03/2016
Author: UP781587
Purpose: Java Assignment
Description:

This project simulates an imaginary universe which consists of many different objects and actions. Firstly there are two types of comets. All comets
bounce against walls. Comet-6 changes size when hitting an edge and reduces life time while moving. Comet-7 changes speed when hitting an edge
and changes colour whilst moving. When comets of the same type collide, they bounce of each other. If comets of different types collide, the smaller
one is destroyed. If the size is equal, the slower one is destroyed. If speed is equal too, both are destroyed.

The universe also has stars which are stationary. Planets orbit these stars in circular motion. A comet can collide with a star which will destroy the comet
and increase the stars lifetime. A comet can also collide with a planet which will destroy the comet and increase the size of the planet.

Black holes are stationary objects which suck in comets. Planets and stars are unharmed my black holes but any comet which is in range will get sucked in. With
each iteration, the comet will increase speed towards the black hole.

To see the different interactions between objects, create a universe and simply choose a demo. There are a  range of demo methods to choose from.
