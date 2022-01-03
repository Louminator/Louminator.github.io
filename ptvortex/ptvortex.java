/* ptvortex.java */
/* Copyright (c) 2004 Louis F. Rossi                                    *
 * A fun little applet for demonstrating point vortex methods           *

 * This program is free software; you can redistribute it and/or modify *
 * it under the terms of the GNU General Public License as published by *
 * the Free Software Foundation; either version 2 of the License, or    *
 * (at your option) any later version.					*

 * This program is distributed in the hope that it will be useful,      *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of       *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the        *
 * GNU General Public License for more details.                         *

 * You should have received a copy of the GNU General Public License    *
 * along with this program; if not, write to the Free Software          *
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 *
 * USA                                                                  *
 *                                                                      *
 * Louis Rossi                                                          *
 * Department of Mathematical Sciences                                  *
 * University of Delaware                                               *
 * Newark, DE 19716-2553                                                */

import java.awt.*;
import java.applet.*;
import java.lang.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ptvortex extends JApplet 
{

    public void init()
    {
	int i,j;

	Container contentPane = getContentPane();
	JPanel panel = new JPanel(new FlowLayout());

	String polynstr;
	String nparticlesstr;
	String radiusstr;
	vorticity fluid;

	int tmpr = 50;
	
	try
	    {
		radiusstr = getParameter("RADIUS");
		tmpr = Integer.valueOf(radiusstr).intValue();
		fluid = new vorticity(tmpr);
	    }
	catch (Exception e)
	    {
		fluid = new vorticity();
	    }

	controlpanel cp = new controlpanel(fluid);

	panel.add(fluid);
	panel.add(cp);

	fluid.setBorder(BorderFactory.createLineBorder(Color.black));

	contentPane.add(panel);
    }
}

class controlpanel extends JPanel
{
    public controlpanel(final vorticity fluid)
    {
	int i;

	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

	JButton go = new JButton("Go");
	JButton clear = new JButton("Clear");
	JPanel  switches = new JPanel(new FlowLayout());


	if (fluid.myTimer.isRunning())
	    go.setText("Stop");

	go.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    JButton s = (JButton)e.getSource();
		    if (fluid.myTimer.isRunning() == true)
			{
			    s.setText("Go");
			    fluid.myTimer.stop();
			}
		    else
			{
			    s.setText("Stop");
			    fluid.myTimer.start();
			}
		}
	    });

	clear.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    JButton s = (JButton)e.getSource();
		    fluid.dotCount=0;
		    fluid.stackptr=0;
		    fluid.markerCount=0;
		    fluid.markerstackptr=0;
		    fluid.repaint();
		}
	    });

	switches.add(go);
	switches.add(clear);
	this.add(switches);
    }
}

class vorticity extends JPanel
    implements ActionListener,MouseMotionListener,MouseListener
{
    public Timer myTimer;

    int dotCount = 0;
    int maxCount = 20;
    vortex dots[];
    int maxmarkerCount = 500;
    int markerCount = 0;
    marker passive[];
    int stackptr;
    int markerstackptr;

    int CenX=52,CenY=52,R=50;

    public vorticity()
    {
	super();

	myTimer = new Timer(0,this);

	addMouseListener(this);
	addMouseMotionListener(this);

	dots = new vortex[maxCount];
	stackptr = dotCount;

	passive = new marker[maxmarkerCount];
	markerstackptr = markerCount;

	myTimer.stop();
    }

    public vorticity(int R)
    {
	super();

	this.R = R;
	this.CenX = R+2;
	this.CenY = R+2;

	myTimer = new Timer(50,this);

	addMouseListener(this);
	addMouseMotionListener(this);

	dots = new vortex[maxCount];
	stackptr = dotCount;

	passive = new marker[maxmarkerCount];
	markerstackptr = markerCount;

	myTimer.stop();
    }

    public Dimension getMinimumSize()
    {
	return new Dimension(CenX*2,CenY*2);
    }

    public Dimension getPreferredSize()
    {
	return new Dimension(CenX*2,CenY*2);
    }

    public void addDot(int x, int y,double strength)
    {
	if (x*x + y*y < R*R)
	    {
		dots[stackptr] = new vortex(x,y,strength);
		    
		++stackptr;
		if (stackptr == maxCount)
		    stackptr = 0;
		else if (dotCount < maxCount) 
		    ++dotCount;
	    }
    }

    public void addMarker(int x, int y)
    {
	if (x*x + y*y < R*R)
	    {
		passive[markerstackptr] = new marker(x,y);
		    
		++markerstackptr;
		if (markerstackptr == maxmarkerCount)
		    markerstackptr = 0;
		else if (markerCount < maxmarkerCount) 
		    ++markerCount;
	    }
    }

    public void paintComponent(Graphics g)
    {
	int i;

	super.paintComponent(g);
	
	g.setColor(getBackground());
	g.fillRect(0,0,CenX*2,CenY*2);
		

	/* Put a little + there so the vortices are a little more visible. */
	for (i=0; i<dotCount; ++i)
	    {
		g.setColor(dots[i].col);
		g.drawLine(((int) dots[i].x)+CenX,CenY-((int) dots[i].y)+1,
			   ((int) dots[i].x)+CenX,CenY-((int) dots[i].y)-1);
		g.drawLine(((int) dots[i].x)+CenX+1,CenY-((int) dots[i].y),
			   ((int) dots[i].x)+CenX-1,CenY-((int) dots[i].y));
	    }
	g.setColor(Color.black);
	for (i=0; i<markerCount; ++i)
	    {
		g.drawLine(((int) passive[i].x)+CenX,CenY-((int) passive[i].y),
			   ((int) passive[i].x)+CenX,CenY-((int) passive[i].y));
	    }

	g.drawOval(1,1,2*R+1,2*R+1);
    }
	
    public void mousePressed(MouseEvent event)
    {
    }

    public void mouseDragged(MouseEvent event)
    {
	if (SwingUtilities.isLeftMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),0.5/Math.PI);

	if (SwingUtilities.isMiddleMouseButton(event))
	    addMarker(event.getX()-CenX,CenY-event.getY());

	if (SwingUtilities.isRightMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),-0.5/Math.PI);

	repaint();
    }

    public void mouseMoved(MouseEvent event)
    {}

    public void mouseClicked(MouseEvent event)
    {
	if (SwingUtilities.isLeftMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),0.5/Math.PI);

	if (SwingUtilities.isMiddleMouseButton(event))
	    addMarker(event.getX()-CenX,CenY-event.getY());

	if (SwingUtilities.isRightMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),-0.5/Math.PI);

	repaint();
    }

    public void mouseReleased(MouseEvent event)
    {}

    public void mouseEntered(MouseEvent e) 
    {
	/* myTimer.stop(); */
    }

    public void mouseExited(MouseEvent e) 
    {
	/* myTimer.start(); */
    }

    public void actionPerformed(ActionEvent e)
    {
	updateParticles(1.0);
	repaint();
    }
	
    public void updateParticles(double timestep)
    {
	int i,j;
	double dx,dy,r2,velx[],vely[],mvelx[],mvely[];
	double tempx,tempy;

	mvelx = new double[maxmarkerCount];
	mvely = new double[maxmarkerCount];

	velx = new double[maxCount];
	vely = new double[maxCount];


	for (i=0; i<markerCount; ++i)
	    {
		mvelx[i] = 0.0;
		mvely[i] = 0.0;
		for (j=0; j<dotCount; ++j)
		    {
			dx = passive[i].x-dots[j].x;
			dy = passive[i].y-dots[j].y;
			
			r2 = Math.pow(dx,2)+Math.pow(dy,2);

			mvelx[i] -= dots[j].strength*dx/r2;
			mvely[i] += dots[j].strength*dy/r2;
		    }
	    }

	for (i=0; i<markerCount; ++i)
	    {
		passive[i].x += timestep*mvelx[i];
		passive[i].y += timestep*mvely[i];
	    }

	for (i=0; i<dotCount; ++i)
	    {
		velx[i] = 0.0;
		vely[i] = 0.0;
	    }

	for (i=0; i<dotCount; ++i)
	    {
		for (j=0; j<i; ++j)
		    {
			dx = dots[i].x-dots[j].x;
			dy = dots[i].y-dots[j].y;
			
			r2 = Math.pow(dx,2)+Math.pow(dy,2);
			    
			tempx = dy/r2; tempy = dx/r2;

			velx[i] -= dots[j].strength*tempx;
			vely[i] += dots[j].strength*tempy;

			/* Apply reciprocity. */

			velx[j] += dots[i].strength*tempx;
			vely[j] -= dots[i].strength*tempy;
		    }
	    }

	for (i=0; i<dotCount; ++i)
	    {
		dots[i].x += timestep*velx[i];
		dots[i].y += timestep*vely[i];
	    }
    }
}

class vortex
{
    double strength,x,y;
    Color col;

    public vortex(double x, double y, double strength)
    {
	this.strength = strength;
	this.x = x;
	this.y = y;

	if (strength > 0.0)
	    col = Color.blue;
	else
	    col = Color.red;
    }

    public vortex(int x, int y, double strength)
    {
	this.strength = strength;
	this.x = (double) x;
	this.y = (double) y;

	if (strength > 0.0)
	    col = Color.blue;
	else
	    col = Color.red;
    }

}

class marker
{
    double x,y;
    Color col;

    public marker(double x, double y)
    {
	this.x = x;
	this.y = y;

	col = Color.black;
    }

    public marker(int x, int y)
    {
	this.x = (double) x;
	this.y = (double) y;

	col = Color.black;
    }

}

