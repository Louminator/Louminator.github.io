%Midpoint

function y=stab_mdpt(t)

r = exp(i*t);

y = (1-r.^2)/2./r;

