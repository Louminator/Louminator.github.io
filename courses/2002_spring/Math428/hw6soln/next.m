function z = next(y1,y2)

z = y1(1,2) - (y1(end,1)-3)*(y1(1,2)-y2(1,2))./(y1(end,1)-y2(end,1));