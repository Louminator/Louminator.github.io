%KC 8.12:4

function y=stab(t,a)

r = exp(i*t);

y = -(1/2)*(r.^2+a.*r-(1.0-a))./(-a.*r.^2+(4+3.*a).*r);
