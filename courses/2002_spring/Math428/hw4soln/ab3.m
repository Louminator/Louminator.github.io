%An AB3 solver.

function [t,y] = ab3(t,ic)

y = zeros(2,1);
y(:,1) = ic;
h = t(2)-t(1);

%Startup procedure using a second order Taylor series method.
thist = t(1);
y(:,end+1) = y(:,end) + h*f(thist,y(:,end)) +...
    h^2/2.0*[-y(1); -y(2)];
thist = t(2);
y(:,end+1) = y(:,end) + h*f(thist,y(:,end)) +...
    h^2/2.0*[-y(1); -y(2)];


for thist = t(3:end-1)
    y(:,end+1) = y(:,end) + ...
        (h/12)*(23*f(thist,y(:,end))-16*f(thist-h,y(:,end-1))+ ...
        5*f(thist-2*h,y(:,end-2)));
end

function dydt = f(t,y)
dydt = [-y(2); y(1)];
