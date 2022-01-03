function [t,y] = taylor2(t,ic)

y(1) = ic;

for thist = t(1:end-1)
y(end+1) = y(end) + (t(2)-t(1))*f(thist,y(end)) + ...
    0.5*(t(2)-t(1))^2*f2(thist,y(end));
end

function dydt = f(t,y)
dydt = exp(-t)*y+cos(t);

function d2ydt2 = f2(t,y)
d2ydt2 = exp(-t)*(f(t,y)-y)-sin(t);


function d3ydt3 = f3(t,y)
d2ydt2 = exp(-t)*(y-2*f(t,y)+f2(t,y))-cos(t);
