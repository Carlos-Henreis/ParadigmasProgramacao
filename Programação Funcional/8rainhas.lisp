(defun queens (n &optional (m n))
  (if (zerop n)
      (list nil)
      (loop for solution in (queens (1- n) m)
        nconc (loop for new-col from 1 to m
                when (loop for row from 1 to n
                    for col in solution
                      always (/= new-col col (+ col row) (- col row))
                    )
                collect (cons new-col solution)
              )
      )
  )
)
(print (queens 8))
