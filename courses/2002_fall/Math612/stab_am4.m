%AM4

function y=stab_am4(t)

r = exp(i*t);

y = 24*r.^2.*(1-r)./(9*r.^3+19*r.^2-5*r+1);
