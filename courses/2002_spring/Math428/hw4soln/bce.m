function [t,y] = fce(t,ic)

y = zeros(2,1);
y(:,1) = ic;
h = t(2)-t(1);

for thist = t(1:end-1)
%y(1,end+1) = (1./(1+h*h))*(y(1,end)-h*y(2,end)); 
%y(2,end+1) = (1./(1+h*h))*(h*y(1,end)+y(2,end)); 
y(:,end+1) = (1./(1+h*h))*[y(1,end)-h*y(2,end);h*y(1,end)+y(2,end)];
end

