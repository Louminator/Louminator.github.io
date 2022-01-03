function [t,y] = mdpt(t,ic)

%A simple scalar centered difference code.
%t is a vector of uniformly spaced times.
%ic is the initial condition.

y(1) = ic;
y(end+1) = y(end) + (t(2)-t(1))*f(t(1),y(end));

for thist = t(2:end-1)
y(end+1) = y(end-1) + 2*(t(2)-t(1))*f(thist,y(end));
end

function dydt = f(t,y)
dydt = exp(-t)*y+cos(t);
