function dydt = bvp1(x,y)

dydt = zeros(4,1);

dydt(1) = y(2);
dydt(2) = exp(x)+y(1).^2*cos(x)-(x-1)*y(2);
dydt(3) = y(4);
dydt(4) = 2*exp(x)*y(1)*y(3)+(x-1)*y(4);