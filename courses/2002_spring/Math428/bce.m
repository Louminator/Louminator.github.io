function [t,y] = bce(t,ic)

%A simple scalar backward Euler code.
%t is a vector of uniformly spaced times.
%ic is the initial condition.

y(1) = ic;

for thist = t(2:end)
y(end+1) = y(end)/(1 + (t(2)-t(1)));
end

% Notice we do not define a function here because I have already
% implicitly solved for f(y,t) = -y.