function A = buildsys(x)

n = length(x);

%Assume a uniform mesh.
h = x(2)-x(1);

A = zeros(n,n);

A(1,1) = 1;
A(n,n) = 1;

for i=2:n-1
    A(i,i-1) = 1./h.^2-(x(i)-1)./h./2;
    A(i,i) = -2./h.^2 - cos(x(i));
    A(i,i+1) = 1./h.^2+(x(i)-1)./h./2;
end