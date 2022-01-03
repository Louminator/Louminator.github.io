<LI><A NAME="tex2html3" HREF="node5.html#1347">Functional relationship between flow derivatives
 <IMG WIDTH=29 HEIGHT=22 ALIGN=MIDDLE ALT="tex2html_wrap_inline2299" SRC="img1.gif"  >  and  <IMG WIDTH=62 HEIGHT=32 ALIGN=MIDDLE ALT="tex2html_wrap_inline2505" SRC="img93.gif"  >  and  <IMG WIDTH=12 HEIGHT=22 ALIGN=MIDDLE ALT="tex2html_wrap_inline2303" SRC="img3.gif"  > .</A>
<LI><A NAME="tex2html4" HREF="node8.html#1317">A example of the accuracy of the fourth order asymptotic expansion
of  <IMG WIDTH=16 HEIGHT=22 ALIGN=MIDDLE ALT="tex2html_wrap_inline2305" SRC="img4.gif"  > .  A second-order (squares) and fourth-order (diamonds) expansion are shown together
with the exact function (circles).  The aspect ratio of 5.44...
( <IMG WIDTH=48 HEIGHT=12 ALIGN=BOTTOM ALT="tex2html_wrap_inline2307" SRC="img5.gif"  > ) is chosen intentionally to be large to demonstrate that
the fourth order approximation is quite robust.  The streamfunction is
calculated with  <IMG WIDTH=37 HEIGHT=11 ALIGN=BOTTOM ALT="tex2html_wrap_inline2707" SRC="img169.gif"  >  and  <IMG WIDTH=37 HEIGHT=24 ALIGN=MIDDLE ALT="tex2html_wrap_inline2709" SRC="img170.gif"  >  on the left and  <IMG WIDTH=39 HEIGHT=29 ALIGN=MIDDLE ALT="tex2html_wrap_inline2711" SRC="img171.gif"  > 
and  <IMG WIDTH=37 HEIGHT=24 ALIGN=MIDDLE ALT="tex2html_wrap_inline2709" SRC="img170.gif"  >  on the right.</A>
<LI><A NAME="tex2html7" HREF="node8.html#887">Sample velocity (left) and velocity derivative (right) 
calculations for an
elliptical Gaussian element.  In this case,  <IMG WIDTH=47 HEIGHT=12 ALIGN=BOTTOM ALT="tex2html_wrap_inline2317" SRC="img9.gif"  >  corresponding to
an aspect ratio of 2.25.  One can see that corresponding symbols cover one
another indicating a very accurate match between the asymptotic
approximation and the ``exact'' quantity that is calculated numerically to 
machine precision.</A>
<LI><A NAME="tex2html9" HREF="node10.html#1021">Regulation of problem size through an aggressive merging algorithm.
The merging algorithm removes extraneous degrees of freedom by combining
several overlapping elements into a single element when this action induces
an error below a specified tolerance.  In all cases, the specified tolerance
is well below the spatial error of the simulation.</A>
<LI><A NAME="tex2html10" HREF="node11.html#1334">Normalized uniform error measurements
for ECCSVM approximation of a Gaussian
vortex (left) and a typical snapshot an error field
 <IMG WIDTH=82 HEIGHT=24 ALIGN=MIDDLE ALT="tex2html_wrap_inline3071" SRC="img12.gif"  > 
(right).  For larger values of <I>l</I> at 0.4 and 0.35, one can see that method
performs better than predicted.  This is attributable to the fact that
relatively few refinements occur for such large values of <I>l</I> and
correspondingly small
values of  <IMG WIDTH=10 HEIGHT=7 ALIGN=BOTTOM ALT="tex2html_wrap_inline2329" SRC="img13.gif"  > .
In the asymptotic regime, 
the computed intercept is roughly  <IMG WIDTH=83 HEIGHT=28 ALIGN=MIDDLE ALT="tex2html_wrap_inline2331" SRC="img14.gif"  > .
Merger induced errors are set to be small so that they
will not interfere with <I>l</I> dependence.
Thus, the figure shows  <IMG WIDTH=35 HEIGHT=28 ALIGN=MIDDLE ALT="tex2html_wrap_inline2335" SRC="img15.gif"  >  convergence is achieved as
 <IMG WIDTH=38 HEIGHT=12 ALIGN=BOTTOM ALT="tex2html_wrap_inline2337" SRC="img16.gif"  > .  At right, one can see that the difference between the
exact solution and the ECCSVM approximation is greatest at the center of
the vortex as one would expect.</A>
<LI><A NAME="tex2html11" HREF="node12.html#1051">Evolution of vortex dipole.  As indicated, snapshots progress from
left to right.  Vorticity contours have increments of 0.5 (T=0.0), 0.25
(T=2.0) and 0.125 (T=4.0).  Positive vorticity is shown with solid contours
and negative vorticity is shown with dashed contours.  The contour is
produced by projecting the basis functions onto a 100X100 grid over the
domain shown.</A>
<LI><A NAME="tex2html12" HREF="node12.html#1335">Basis function positions and orientations in vortex dipole
calculations.  These plots show vortex element positions from a low
resolution ( <IMG WIDTH=105 HEIGHT=28 ALIGN=MIDDLE ALT="tex2html_wrap_inline2339" SRC="img17.gif"  > ) dipole calculation.  There are 2299
computational elements at this point in the calculation.  The X's correspond
to  <IMG WIDTH=27 HEIGHT=14 ALIGN=MIDDLE ALT="tex2html_wrap_inline2341" SRC="img18.gif"  >  and  <IMG WIDTH=27 HEIGHT=14 ALIGN=MIDDLE ALT="tex2html_wrap_inline2341" SRC="img18.gif"  >  oriented at an angle  <IMG WIDTH=11 HEIGHT=24 ALIGN=MIDDLE ALT="tex2html_wrap_inline2345" SRC="img19.gif"  > .  Each
element is drawn in a rotating greyscale tone so that one can distinguish
elements from one another.  Vorticity contours have increments of 0.125
(left) and 0.0625 (right).
The right plot is a zoomed version of the right showing detailed positions
near the aft separatrix.</A>
<LI><A NAME="tex2html13" HREF="node12.html#1069">Spatial convergence for vortex dipole evolution problem.  The
reference solution has been calculated with an ADI method.  Since the ADI
solution noticeably interacts with the domain boundary at later times,
samples were measured at T=1.0 and T=2.0.  Though not as clean as for the
simple vortex experiment, this is to be expected because the ADI solution is
not exact.</A>
