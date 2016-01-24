# alphabet-diamond

## Background

Write a program which draws a diamond of the form illustrated below. The letter which is to appear at the widest point of the figure (E in the example) is to be specified as input data (CLI arg, keyboard read-in, etc).

                      A
                     B B
                    C   C
                   D     D
                  E       E
                   D     D
                    C   C
                     B B
                      A

Inputs are [a-zA-Z] (e.g. letters only, upper or lower case). Output is upper case only.
Edge cases:
If you input "a" or "A", then he output is simply "A".
If the input is invalid, then the output is "INVALID INPUT". If you read from keyboard input you may ask the user for a new input.

## Installation

Download from https://github.com/andeemarks/alphabet-diamond.

## Tested on

	$ java -version

	java version "1.8.0-ea"
	Java(TM) SE Runtime Environment (build 1.8.0-ea-b113)
	Java HotSpot(TM) 64-Bit Server VM (build 25.0-b55, mixed mode)

	$ lein -version

	Leiningen 2.5.3 on Java 1.8.0-ea Java HotSpot(TM) 64-Bit Server VM

## Usage

    $ ./go.sh <letter>

## Examples

    $ ./go.sh F

    $ ./go.sh j

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
