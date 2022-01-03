/* differential.java */
/* Copyright (c) 2003 Louis F. Rossi                                    *
 * A fun little applet for demonstrating mixing of passive quantities   *
 * rotating fluid flows.                                                *

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

public class differential extends JApplet 
{

    public void init()
    {
	int i,j;

	Container contentPane = getContentPane();
	JPanel panel = new JPanel(new FlowLayout());

	String polynstr;
	String nparticlesstr;
	markers passive;
	
	diffrot rotator;

	try 
	    {
		polynstr = getParameter("POLYN");
		int polyn = Integer.valueOf(polynstr).intValue();
		rotator = new diffrot(polyn);
	    }
	catch (Exception e) 
	    {
		rotator = new diffrot(4);
	    }

	try
	    {
		nparticlesstr = getParameter("NPARTICLES");
		int nparticles = Integer.valueOf(nparticlesstr).intValue();
		passive = new markers(rotator,nparticles);
	    }
	catch (Exception e)
	    {
		passive = new markers(rotator);
	    }

	controlpanel cp = new controlpanel(passive);

	panel.add(passive);
	panel.add(cp);
	panel.add(rotator);

	passive.setBorder(BorderFactory.createLineBorder(Color.black));

	contentPane.add(panel);
    }
}

class controlpanel extends JPanel
{
    public controlpanel(final markers passive)
    {
	int i;

	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

	JButton stir = new JButton("Stir");
	JButton clear = new JButton("Clear");
	JButton reverse = new JButton("Reverse");
	JSlider timeDelay = new JSlider(0,100);
	JLabel  refresh = new JLabel("Refresh interval");
	JPanel  switches = new JPanel(new FlowLayout());


	if (passive.myTimer.isRunning())
	    stir.setText("Stop");

	stir.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    JButton s = (JButton)e.getSource();
		    if (passive.myTimer.isRunning() == true)
			{
			    s.setText("Stir");
			    passive.myTimer.stop();
			}
		    else
			{
			    s.setText("Stop");
			    passive.myTimer.start();
			}
		}
	    });

	clear.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    JButton s = (JButton)e.getSource();
		    passive.dotCount=0;
		    passive.stackptr=0;
		    passive.repaint();
		}
	    });

	reverse.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    JButton s = (JButton)e.getSource();
		    passive.rotator.reverseParms();
		}
	    });

	timeDelay.setPaintLabels(true);
	timeDelay.setMajorTickSpacing(20);
	timeDelay.setMinorTickSpacing(10);
	timeDelay.setValue(50);

	timeDelay.addChangeListener(new ChangeListener()
	    {
		public void stateChanged(ChangeEvent e)
		{
		    JSlider s = (JSlider)e.getSource();
		    passive.changeDelay(s.getValue());
		}
	    });

	this.add(timeDelay);
	this.add(refresh);
	switches.add(stir);
	switches.add(clear);
	switches.add(reverse);
	this.add(switches);
    }
}

class markers extends JPanel
    implements ActionListener,MouseMotionListener,MouseListener
{
    public Timer myTimer;

    int dotCount = 0;
    int maxCount = 500;
    particle dots[];
    int stackptr;
    diffrot rotator;

    int CenX=52,CenY=52,R=50;

    public markers(diffrot rotator)
    {
	super();

	int i,j;

	this.rotator = rotator;

	myTimer = new Timer(50,this);

	addMouseListener(this);
	addMouseMotionListener(this);

	dots = new particle[maxCount];
	stackptr = dotCount;

	myTimer.stop();
    }

    public markers(diffrot rotator, int nparticles)
    {
	super();

	int i,j;

	this.rotator = rotator;

	myTimer = new Timer(50,this);

	addMouseListener(this);
	addMouseMotionListener(this);

	maxCount = nparticles;

	dots = new particle[maxCount];
	stackptr = dotCount;

	myTimer.stop();
    }

    public Dimension getMinimumSize()
    {
	return new Dimension(104,104);
    }

    public Dimension getPreferredSize()
    {
	return new Dimension(104,104);
    }

    public void addDot(int x, int y,Color col)
    {
	if (x*x + y*y < R*R)
	    {
		dots[stackptr] = new particle(x,y,col);
		    
		++stackptr;
		if (stackptr == maxCount)
		    stackptr = 0;
		else if (dotCount < maxCount) 
		    ++dotCount;
	    }
    }

    public void paintComponent(Graphics g)
    {
	int i;

	super.paintComponent(g);
	
	g.setColor(getBackground());
	g.fillRect(0,0,104,104);
		
	for (i=0; i<dotCount; ++i)
	    {
		g.setColor(dots[i].col);
		g.drawLine(dots[i].x+CenX,CenY-dots[i].y,
			   dots[i].x+CenX,CenY-dots[i].y);
	    }
	g.setColor(Color.black);

	g.drawOval(1,1,101,101);

	g.drawLine(CenX,CenY,CenX,CenY);
		
    }
	
    public void mousePressed(MouseEvent event)
    {
    }

    public void mouseDragged(MouseEvent event)
    {
	if (SwingUtilities.isLeftMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),Color.black);

	if (SwingUtilities.isMiddleMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),Color.red);

	if (SwingUtilities.isRightMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),Color.blue);

	repaint();
    }

    public void mouseMoved(MouseEvent event)
    {}

    public void mouseClicked(MouseEvent event)
    {
	if (SwingUtilities.isLeftMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),Color.red);

	if (SwingUtilities.isMiddleMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),Color.green);

	if (SwingUtilities.isRightMouseButton(event))
	    addDot(event.getX()-CenX,CenY-event.getY(),Color.blue);

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

    public void changeDelay(int delay)
    {
	myTimer.setDelay(delay);
    }

    public void actionPerformed(ActionEvent e)
    {
	int i;

	for (i=0; i<dotCount; ++i)
	    updateParticle(0.1f,dots[i]);
	repaint();
    }
	
    public void updateParticle(float timestep, particle dot)
    {
	double dtheta;

	dtheta = rotator.f(dot.r);

	dot.theta = dot.theta+dtheta*timestep;
	dot.x = (int) (dot.r*Math.cos(dot.theta));
	dot.y = (int) (dot.r*Math.sin(dot.theta));
    }
}

class velPlot extends JPanel
{
    diffrot rotator;

    public velPlot(diffrot rotator)
    {
	this.rotator = rotator;
    }

    public Dimension getMinimumSize()
    {
	return new Dimension(100,100);
    }

    public Dimension getPreferredSize()
    {
	return new Dimension(100,100);
    }

    public void paintComponent(Graphics g)
    {
	int i;
	int y,yold;

	super.paintComponent(g);
	
	g.setColor(getBackground());
	g.fillRect(0,0,100,100);
		
	g.setColor(Color.black);
		
	g.drawLine(0,50,100,50);
	yold = (int) (48.0*rotator.f(0.0));

	for (i=2;i<98;++i)
	    {
		y = (int) (48.0*rotator.f((double) ((i-1.0)*50.0/97.0)));
		g.drawLine(i-1,50-yold,i,50-y);
		yold = y;
	    }

	for (i=0; i<rotator.size; ++i)
	    {
		y = (int) (48.0*rotator.parm[i]);
		g.setColor(Color.red);
		g.drawLine((int) (rotator.r[i]*97.0/50.0)-1,50-y,
 			   (int) (rotator.r[i]*97.0/50.0)+3,50-y);
		g.drawLine((int) (rotator.r[i]*97.0/50.0)+1,48-y,
			   (int) (rotator.r[i]*97.0/50.0)+1,52-y);
	    }
    }
}

class diffrot extends JPanel
{
    double r[],parm[];
    int size;
    JSlider parms[];
    JLabel  labels[];
    int     i;
    JPanel  vp,controls;

    public diffrot(int nparm)
    {
	int i;

	this.size = nparm;

	this.parm = new double[nparm];
	this.r = new double[nparm];

	for (i=0; i<nparm; ++i)
	    {
		this.r[i] = 50.0*i/(nparm-1);
		this.parm[i] = 1.0*i/(nparm-1);
	    }

	parms = new JSlider[nparm];
	labels = new JLabel[nparm];

	controls = new JPanel(new FlowLayout());

	controls.setLayout(new BoxLayout(controls,BoxLayout.Y_AXIS));

	for  (i=0; i<nparm; ++i)
	    {
		this.labels[i] = new JLabel("Parameter " + i);
		this.parms[i]  = new JSlider(-100,100);
		this.parms[i].setPaintLabels(true);
		this.parms[i].setMajorTickSpacing(50);
		this.parms[i].setMinorTickSpacing(25);
		this.parms[i].setValue((int) (this.parm[i]*100.0));
		parms[i].addChangeListener(new ChangeListener()
		    {
			public void stateChanged(ChangeEvent e)
			{
			    JSlider s = (JSlider)e.getSource();
			    getParms();
			    vp.repaint();
			}
		    });
		controls.add(parms[i]);
		controls.add(labels[i]);
	    }
	vp = new velPlot(this);
	vp.setBorder(BorderFactory.createLineBorder(Color.black));

	this.add(vp);
	this.add(controls);
    }

    public void getParms()
    {
	int i;

	for  (i=0; i<this.size; ++i)
	    this.parm[i] = (double) (parms[i].getValue()/100.0);
    }

    public void reverseParms()
    {
	int i;

	for  (i=0; i<this.size; ++i)
	    {
		this.parm[i] = -this.parm[i];
		parms[i].setValue((int) (this.parm[i]*100.0));
	    }
    }

	

    public double f(double r)
    {
	int i,j;
	double sum,term;

	sum = 0.0;

	for (i=0; i<this.size; ++i)
	    {
		term = this.parm[i];
		for (j=0; j<this.size; ++j)
		    if (j != i)
			term = term*(r-this.r[j])/(this.r[i]-this.r[j]);
		sum = sum+term;
	    }
	return sum;
    }
}

class particle
{
    double r,theta;
    int x,y;
    Color col;
	
    public particle(int x0, int y0)
    {
	x = x0;
	y = y0;
		
	r = Math.sqrt((x*x) + (y*y));
	theta = Math.atan2(((double) y),((double) x));
		
	col = Color.black;
    }
	
    public particle(int x0, int y0, Color setcol)
    {
	x = x0;
	y = y0;
		
	r = Math.sqrt((x*x) + (y*y));
	theta = Math.atan2(((double) y),((double) x));
		
	col = setcol;
    }
}
