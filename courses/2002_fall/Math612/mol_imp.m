%MOL implicit

% Method of lines for the heat equation with Dirichlet boundary condition
% u(x(1)) = u(x(end)) = 0
% with implicit first order differencing.

function u = mol_imp(x,T,kappa,u0);

u = mol4(x,T,kappa,u0);

% mol3 uses matrices as a linear transformations to go from one state
% to the next.

function u = mol3(x,T,kappa,u0);

u(1,:) = u0;

mu = kappa*(T(2)-T(1))/(x(2)-x(1))^2;

A = toeplitz([(1+2*mu) -mu zeros(1,length(u0)-2)]);

A(1,:) = zeros(1,length(u0));

A(end,:) = zeros(1,length(u0));

for t=T(2:end)
    u(end+1,:) = (A\(u(end,:)'))';
end

% mol4 uses matrices as a linear transformations to go from one state
% to the next.

function u = mol4(x,T,kappa,u0);

u(1,:) = u0;

mu = kappa*(T(2)-T(1))/(x(2)-x(1))^2;

A = toeplitz([(1+2*mu) -mu zeros(1,length(u0)-2)]);

A(1,:) = [1 zeros(1,length(u0)-1)];

A(end,:) = [zeros(1,length(u0)-1) 1];

for t=T(2:end)
    u(end+1,:) = (A\(u(end,:)'))';
end

