package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import View.PetLabel;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class AdultCat extends BabyCat implements Dance_IF
{
    public AdultCat(){
    	System.out.println("�⺻ ������ ȣ��");
    	
    }
    public AdultCat(Animal p) {
    	super(p);
    	System.out.println("AdultCat�� ������");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
<<<<<<< HEAD
    public AdultCat(Animal p, User myUser, PetLabel view) {
=======
    public AdultCat(String name, int index)
    {
        super.setName(name);
        
        System.out.println("�⺻ ������ ȣ��");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSpeechList("�Ŀ� �Ŀ�", 11);
        setSpeechList("������", 12);
        setSpeechList("������ �������� �ͱ���!", 13);
        setSpeechList("������ �߸��Ѱ� ����?", 14);
        setSpeechList("�ּ��� ���� ������", 15);
        setSpeechList("����...��", 16);
    }
    public AdultCat(Animal p, User myUser) {
>>>>>>> 7c6787afbd7fb6b92520ad2c7b882a94105bd82c
    	super(p);
    	super.setMyUser(myUser);
    	this.setLabel(view);
    	System.out.println("AdultCat�� ������");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("this.petLabel " + this.getLabel());
    }

    //change
    public void levelUp()
    {
        this.setLevel(this.getLevel()+1);
        this.setExp(0);
        this.setStemina(this.getStemina()+60);
        this.setPower(this.getPower()+20);
        this.setDefense(this.getDefense()+30);
    }

    public void dance()
    {
        System.out.println("Dance..");
    }

    public String getName(){return super.getName();}

    public void transform(User presentUser, int index)
    {
    	System.out.println("�巡�� ����" + presentUser);
        presentUser.setAnimal(index, new Dragon(this));
        
    }
    public boolean checkExp()
    {
    	if(this.getExp()>=30&&this.getLevel()<5) {
    		this.levelUp();
            
    		if(super.getLevel() == 3) {
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
    	System.out.println("ȣ���̷� ��ȭ  " + presentUser);
        presentUser.setAnimal(index, new Tiger(this, presentUser));       
    }
    
}
