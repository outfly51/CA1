package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import Model.Animal;

public class PetLabel extends JLabel implements Runnable, MouseListener {
	protected Animal pet;
	private Place place;
	private JPopupMenu menu;
	private JPopupMenu placeMenu;
	private int flag;
	private int moveFlag;
	protected int o_x, o_y;
	
	Thread t;
	
	public PetLabel() {
	}
	public PetLabel(Animal pet, Place place) {
		this.pet = pet;
		this.place = place;
		this.menu = new JPopupMenu();
		this.setText(pet.getName());
		//System.out.println(this.getX() +" "+ this.getY());
		
		this.flag = 0;
		this.moveFlag = 0;
		
		
		JMenuItem item1 = new JMenuItem("move");
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				// TODO Auto-generated method stub
				place.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(flag == 1) {
							moveThread(e.getX(), e.getY());
							flag = 0;	
							
						}
					}
				});
			}
		});
		JMenu item2 = new JMenu("talk");
		JMenu item3 = new JMenu("change map");
		JMenu item4 = new JMenu("map behavior");
		JMenu item5 = new JMenu("pet behavior");
		
		menu.add(item1);
		menu.add(item2);
		JMenuItem talkItem1 = new JMenuItem("�λ��ϱ�");
		JMenuItem talkItem2 = new JMenuItem("�����ϰ� ���ϱ�");
		JMenuItem talkItem3 = new JMenuItem("�����ϱ�");
		item2.add(talkItem1);
		item2.add(talkItem2);
		item2.add(talkItem3);
		
		menu.add(item3);
		JMenuItem mapItem1 = new JMenuItem("Livingroom");
		mapItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				place.c.changeMap(pet, 0);
			}		
		});
		JMenuItem mapItem2 = new JMenuItem("Bathroom");
		mapItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				place.c.changeMap(pet, 1);
			}		
		});
		JMenuItem mapItem3 = new JMenuItem("Yard");
		mapItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				place.c.changeMap(pet, 0);
			}		
		});
		menu.add(item4);
		JMenuItem behaviorItem1 = new JMenuItem("���ڱ�");
		JMenuItem behaviorItem2 = new JMenuItem("�����ֱ�");
		
		JMenuItem behaviorItem3 = new JMenuItem("����ֱ�");
		JMenuItem behaviorItem4 = new JMenuItem("�����ϱ�");
		
		JMenuItem behaviorItem5 = new JMenuItem("��ġ���");
		JMenuItem behaviorItem6 = new JMenuItem("�ʹ���");
		JMenuItem behaviorItem7 = new JMenuItem("����Ȯ��");
		if(this.place instanceof LivingroomPage) {
			item3.add(mapItem2);
			item3.add(mapItem3);
			item4.add(behaviorItem1);
			item4.add(behaviorItem2);
		} else if(this.place instanceof BathroomPage) {
			item3.add(mapItem1);
			item3.add(mapItem3);
			item4.add(behaviorItem5);
			item4.add(behaviorItem6);
			item4.add(behaviorItem7);
		} else if(this.place instanceof YardPage) {
			item3.add(mapItem1);
			item3.add(mapItem2);
			item4.add(behaviorItem3);
			item4.add(behaviorItem4);
		}
			
		
		menu.add(item5);
		
		this.addMouseListener(this);
		
		this.setVisible(true);
		
	}
	public void makeThread() {
		this.t = new Thread(this);
		this.t.start();
	}
	public void moveThread(int x, int y) {
		this.t = new Thread(this);
		moveFlag = 1;
		this.o_x = x;
		this.o_y = y;
		this.t.start();
	}
	@Override
	public void run() {
		this.pet.setXY(this.getX(), this.getY());
		double x = (double)this.pet.getX();
		double y = (double)this.pet.getY();
		double x_cal = x;
		double y_cal = y;
		double speed_x = Math.abs(o_x - x) / 30;
		double speed_y = Math.abs(o_y - y) / 30;
		// TODO Auto-generated method stub
		System.out.println("speed : x y" + speed_x + " " + speed_y);
		while(this.moveFlag == 1) {
			System.out.println(x + "   " + y);
			if(x < this.o_x && y < this.o_y) {
				x_cal += speed_x;
				y_cal += speed_y;
				if(x_cal > this.o_x || y_cal > this.o_y) {
					x_cal = this.o_x;
					y_cal = this.o_y;
					moveFlag = 0;
				}
			} else if(x < this.o_x && y > this.o_y) {
				x_cal += speed_x;
				y_cal -= speed_y;
				if(x_cal > this.o_x || y_cal < this.o_y) {
					x_cal = this.o_x;
					y_cal = this.o_y;
					moveFlag = 0;
				}
			} else if(x > this.o_x && y < this.o_y) {
				x_cal -= speed_x;
				y_cal += speed_y;
				if(x_cal < this.o_x || y_cal > this.o_y) {
					x_cal = this.o_x;
					y_cal = this.o_y;
					moveFlag = 0;
				}
			} else if(x > this.o_x && y > this.o_y) {
				x_cal -= speed_x;
				y_cal -= speed_y;
				if(x_cal < this.o_x || y_cal < this.o_y) {
					x_cal = this.o_x;
					y_cal = this.o_y;
					moveFlag = 0;
				}
			}			
			
			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setLocation((int)x_cal % 850, (int)y_cal %450);
			System.out.println(x_cal + "  " + y_cal);
		}
		this.pet.setXY((int)x_cal,(int)y_cal);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this) {
			menu.show(this, this.getWidth(), 0);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		/*
		if(e.isPopupTrigger()) {
			menu.show(e.getComponent(), e.getX(), e.getY());
		}*/
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	/*	// TODO Auto-generated method stub
		if(e.isPopupTrigger()) {
			menu.show(e.getComponent(), e.getX(), e.getY());
		}*/
	}
	
}
