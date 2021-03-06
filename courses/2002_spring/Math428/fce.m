function [t,y] = fce(t,ic)

%A simple scalar forward Euler code.
%t is a vector of uniformly spaced times.
%ic is the initial condition.

y(1) = ic;

for thist = t(1:end-1)
y(end+1) = y(end) + (t(2)-t(1))*f(thist,y(end));
end

function dydt = f(t,y)
%dydt = exp(-t)*(y^2-y)+cos(t);
dydt = -y;
%dydt = -(1+0.9*cos(t))*y;
