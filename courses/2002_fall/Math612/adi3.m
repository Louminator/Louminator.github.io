%ADI - 2D - Dirichlet BCs on two sides and Neumann on two sides.

function u = adi3(x,y,T,kappa,u0)

mux = kappa*(T(2)-T(1))/(x(2)-x(1))^2/2;
muy = kappa*(T(2)-T(1))/(y(2)-y(1))^2/2;

m = length(x);
n = length(y);

u0c = reshape(u0',m*n,1);

Diagx = sparse(1:m,1:m,[-mux -2*mux*ones(1,m-1)],m,m);
Ex = sparse(2:m,1:m-1,mux*ones(1,m-1),m,m);
sub1 = Ex+Diagx+Ex';

Dxx = kron(speye(n),sub1);

Diagy1 = sparse(1:m,1:m,-2*muy*ones(1,m),m,m);
Diagy2 = sparse(1:m,1:m,muy*ones(1,m),m,m);
Ey = sparse(2:n,1:n-1,ones(1,n-1),n,n);

newspeye = sparse(1:n,1:n,[0.5 ones(1,n-1)],n,n);

Dyy = kron(newspeye,Diagy1) + kron(Ey,Diagy2) + kron(Ey',Diagy2);

v1 = u0c;
u = zeros(n,m,1);
u(:,:,1) = reshape(v1,m,n)';
for t=T(2:end)
    v2 = (speye(m*n)-Dxx)\((speye(m*n)+Dyy)*v1);
    v1 = (speye(m*n)-Dyy)\((speye(m*n)+Dxx)*v2);
    u(:,:,end+1)  = reshape(v1,m,n)';
end
