<LI><A NAME="tex2html3" HREF="node5.html#746">Extreme values of () must occur on the coordinate axes.
A representation of the contours of the constituent functions is displayed
above with the axisymmetric Gaussian contours shown as solid lines and the
elliptical Gaussian contours shown as dotted lines.  If a ``local minimum''
denoted by <B>x</B>
were not on the <I>x</I>-axis, one could follow the path described by the
intersecting elliptical Gaussian toward <B>m</B> to decrease this minimum.
Following this path reduces the magnitude of the first term of ()
while keeping the second term constant.
Similarly, if <B>x</B> were a maximum, one could increase it by traveling
along the arc of the circle toward point <B>M</B> on the <I>y</I>-axis.  
Thus, any extreme value
must lie on either the x or y axis.</A>
<LI><A NAME="tex2html4" HREF="node7.html#775">Contour plot of advecting vortex dipole at <I>t</I>=4.0.  The
algorithm attempts to merge redundant elements at time intervals of 0.2 so
that this configuration has experienced the algorithm 20 times.  The maximum
acceptable error for each pass is 0.08 though the actual error never
exceeds a
tenth of this value. On the left, vorticity contours (solid for positive and
dashed for negative) are evenly
spaced at intervals of 0.25.  On the right, the difference between the
vorticity field before and after merging is displayed.
The
error contours (solid) are evenly spaced at intervals of  <IMG WIDTH=31 HEIGHT=15 ALIGN=BOTTOM ALT="tex2html_wrap_inline1378" SRC="img1.gif"  > .</A>
<LI><A NAME="tex2html5" HREF="node7.html#776">The anatomy of a single merging event.  For the same snapshot at in
Fig. (), the merged elements are displayed.  Contour lines and
computational elements are superposed on the right.  Computational elements
are shown by X's where the length of the lines are proportional to the
semi-major and semi-minor axes.  Negative elements are
displayed slightly darker than positive elements.  The black elements are
the elements that are merged.  The area in the box on the left plot is
expanded on the right.  Notice that nearby elements tend to align with one
another because the Reynolds number is high.</A>
<LI><A NAME="tex2html6" HREF="node7.html#681">Growth of the problem size with time for the dipole example.  In
this figure, we see that the merging algorithm effectively controls the
otherwise exponential growth of the problem size for ECCSVM.  Three examples
are shown.  The first measurements are for ECCSVM without merging where the
problem size grows exponentially.  The program halted when <I>N</I> grew to be
too large. The second set of measurements are with a low uniform merging
error of 0.08 both before and after merging.  Again, this bound is used
every time the merging scheme is applied at intervals of 0.2. The third data
set is with a high uniform merging error of 0.16.  Since the third curve
produces merging errors that are roughly half as large, the problem size is
larger though it still exhibits the same trend.  After some transient
effects, the problem size behavior stabilizes
and grows quadratically with time.</A>
