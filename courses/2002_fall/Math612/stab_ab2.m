%AB2

function y=stab_ab2(t)

r = exp(i*t);

y = r.*(1-r)./(3*r/2-1/2);
