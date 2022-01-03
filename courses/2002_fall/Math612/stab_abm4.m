%ABM4

function [y1, y2]=stab_abm4(t)

r = exp(i*t);

c = r.^4-r.^3;
b = 1/24*(28*r.^3-5*r.^2+r);
a = -9/24^2*(55*r.^3-59*r.^2+37*r-9);

y1 = (-b+sqrt(b.^2-4*a.*c))/2./a;
y2 = (-b-sqrt(b.^2-4*a.*c))/2./a;
