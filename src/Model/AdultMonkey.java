package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class AdultMonkey extends BabyMonkey implements Sit_IF
{
    public AdultMonkey(){}
    public AdultMonkey(String name){this.setName(name);}
    public AdultMonkey(Animal p) {
    	super(p);
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setSpeechList("������ ������ħ", 11);
        setSpeechList("�������� ���´ٸ� ���� �е�", 12);
        setSpeechList("�����̾�? �ٳ�����...", 13);
        setSpeechList("�츰 ģ�� ģ��~", 14);
        setSpeechList("�߸��߾�...", 15);
        setSpeechList("��������!", 16);
    }
    public AdultMonkey(String name, int index)
    {
        super.setName(name);
        
        System.out.println("�⺻ ������ ȣ��");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    //change
    public void levelUp()
    {
       	this.setLevel(this.getLevel()+1);
       	this.setExp(0);

       	this.setStemina(this.getStemina()+40);
     	this.setPower(this.getPower()+40);
      	this.setDefense(this.getDefense()+30);
        
    }

    public void sit()
    {
        System.out.println("I'm Sit..");
    }

    public String getName(){return super.getName();}
    
    public boolean checkExp()
    {
    	if(this.getExp()>=30&&this.getLevel()<5) {
    		this.levelUp();
            
    		if(super.getLevel() == 3 || super.getLevel() == 4) {
    			super.getLabel().grow();
    		//super.getLabel().setBounds(super.getLabel().getX(),super.getLabel().getY(), 144, 130);
    		//super.getLabel().setVisible(true);
    		}
    		
    		return true;
    	}
    	else
    		return false;
    
    }
    
    public void grow(User presentUser, int index)
    {
        presentUser.setAnimal(index, new Gorilla(this));
    }
    
    public void transform(User presentUser, int index)
    {
    	System.out.println("�巡�� ����" + presentUser);
        presentUser.setAnimal(index, new Dragon(this));
        
    }
}
