function [t,y] = fce(t,ic)

y = zeros(2,1);
y(:,1) = ic;

for thist = t(1:end-1)
y(:,end+1) = y(:,end) + (t(2)-t(1))*f(thist,y(:,end));
end

function dydt = f(t,y)
dydt = [-y(2); y(1)];
