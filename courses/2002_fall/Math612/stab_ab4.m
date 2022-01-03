%AB4

function y=stab_ab4(t)

r = exp(i*t);

y = 24*r.^3.*(1-r)./(55*r.^3-59*r.^2+37*r-9);
