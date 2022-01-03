%MOL

% Method of lines for the heat equation with Dirichlet boundary condition
% u(x(1)) = u(x(end)) = 0
% with explicit first order differencing.

function u = mol(x,T,kappa,u0);

u = mol1(x,T,kappa,u0);

% mol1 is a naive implementation with lots of looping.

function u = mol1(x,T,kappa,u0);

u(1,:) = u0;

mu = kappa*(T(2)-T(1))/(x(2)-x(1))^2;

for t=T(2:end)
    u(end+1,:) = u0;
    u(end,1) = 0.0;
    u(end,end) = 0.0;
    for i = 2:length(u0)-1
        u(end,i) = mu*u(end-1,i+1)+(1-2*mu)*u(end-1,i)+mu*u(end-1,i-1);
    end
end

% mol2 is a little smarter and takes advantage of matlab's vectorization.

function u = mol2(x,T,kappa,u0);

u(1,:) = u0;

mu = kappa*(T(2)-T(1))/(x(2)-x(1))^2;

for t=T(2:end)
    u(end+1,:) = ...
        [0 ...
            mu*(u(end,3:end)+u(end,1:end-2))+(1-2*mu)*u(end,2:end-1) ...
            0];
end

% mol3 uses matrices as a linear transformations to go from one state
% to the next.

function u = mol3(x,T,kappa,u0);

u(1,:) = u0;

mu = kappa*(T(2)-T(1))/(x(2)-x(1))^2;

A = toeplitz([(1-2*mu) mu zeros(1,length(u0)-2)]);

A(1,:) = zeros(1,length(u0));

A(end,:) = zeros(1,length(u0));

for t=T(2:end)
    u(end+1,:) = (A*(u(end,:)'))';
end