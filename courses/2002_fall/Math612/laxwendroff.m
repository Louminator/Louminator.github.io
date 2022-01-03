%laxwendroff

function u = laxwendroff(x,T,c,u0);

u = laxwendroff1(x,T,c,u0);

function u = laxwendroff1(x,T,c,u0);

u(1,:) = u0;

mu = c*(T(2)-T(1))/(x(2)-x(1));
str = ['mu = ' num2str(mu)];
disp(str);

A = toeplitz([(1-mu^2) mu/2+mu^2/2 zeros(1,length(u0)-2)], ...
    [(1-mu^2) -mu/2+mu^2/2 zeros(1,length(u0)-2)])';

% Periodic BC's.
A(length(u0),1) = mu/2+mu^2/2;

for t=T(2:end)
    u(end+1,:) = (A*(u(end,:)'))';
end