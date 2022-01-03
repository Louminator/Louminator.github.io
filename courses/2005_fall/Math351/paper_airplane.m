%% paper_airplane.m
%% A MATLAB script
%% L F Rossi
%%
%% Specify the points of interest.
p1 = [0 0 0];
p2 = [0 10 -1];
p3 = [1/2 10 0];
p4 = [-1/2 10 0];
p5 = [4 10 0];
p6 = [-4 10 0];
%% Build a matrix of the points in the right order for a connect-the-dots
%% wire-frame figure.
v = [p1 ; p2; p3; p1; p2; p4; p1; p5; p3; p1; p6; p4; p1]';
plot3(v(1,:),v(2,:),v(3,:));
axis equal
