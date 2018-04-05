# Flang-Interpreter
Simple interpreter of an impractical (but turing-complete) language written in Java. This project was originally created to pass a class at my university and has not been updated since. Flang is a stack-oriented language with one main stack and one additional for every function. Functions and variables are stored as strings and evaluated when needed. Becouse of that program can modify its code at runtime. 

This is an examaple code that randomly generates two matrices (size of which is given by user) and adds them.

```
rseed

3 (createMatrix) 
(	
	(rows)	ARG_0	var
	(cols)	ARG_1	var
	(name)	ARG_2 var
	
	(x) 1 var
	(y) 1 var
	rows
	(
		cols
		(
			(val) 0 4 random var			        #generates random number between 0 and 4
			(val) val (integer) convert var	  #casts val to integer
			name (_) + x + (.) + y + val var	#declares variable "[name]_[x].[y]" with value of val

			(y) 1 y + var	
		) repeat
		(x) 1 x + var
		(y) 1 var
	) repeat		
) def

3 (printMatrix)
(
	(rows)	ARG_0	var
	(cols)	ARG_1	var
	(name)	ARG_2 var
	
	(x) 1 var
	(y) 1 var
	rows
	(
		cols
		(
			(element) name (_) + x + (.) + y + evaluate var
			element (text) convert ( ) + print

			(y) 1 y + var	
		) repeat
		nl

		(x) 1 x + var
		(y) 1 var
	) repeat		
) def

5 (addMatrices)
(
	(rows)	ARG_0	var
	(cols)	ARG_1	var
	(name1)	ARG_2 var
	(name2)	ARG_3 var
	(newname)	ARG_4 var
	
	(x) 1 var
	(y) 1 var
	rows
	(
		cols
		(
			(element1) name1 (_) + x + (.) + y + evaluate var
			(element2) name2 (_) + x + (.) + y + evaluate var
			
			(sum) element1 element2 + var
			newname (_) + x + (.) + y + sum var

			(y) 1 y + var
		) repeat

		(x) 1 x + var
		(y) 1 var
	) repeat	
) def

(
	(Write size of matrices:) print nl
	( -columns:  ) print (X) get var nl
	( -rows:     ) print (Y) get var nl nl

	(((mat1))) X Y createMatrix
	(((mat2))) X Y createMatrix

	(Randomly generated 2 matrices with size ) X + (x) + Y + print nl nl

	(Matrix 1:) print nl
	(((mat1))) X Y printMatrix nl
	(Matrix 2:) print nl
	(((mat2))) X Y printMatrix nl nl

	(((newmat))) (((mat1))) (((mat2))) X Y addMatrices

	(Added matrices) print nl (New matrix:) print nl
	(((newmat))) X Y printMatrix

	nl nl (If you want to continue write "next") print nl
	(next) get var nl nl

	next (next) equal  () ( stop) if
) stoploop
(End of program) print 
```
