%centered-wind

function u = cenwind(x,T,c,u0);

u = upwind1(x,T,c,u0);

function u = upwind1(x,T,c,u0);

u(1,:) = u0;

mu = c*(T(2)-T(1))/(x(2)-x(1));

A = toeplitz([1 mu zeros(1,length(u0)-2)], [1 -mu zeros(1,length(u0)-2)])';

% Periodic BC's.
A(length(u0),1) = mu;

for t=T(2:end)
    u(end+1,:) = (A*(u(end,:)'))';
end
