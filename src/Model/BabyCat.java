package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class BabyCat extends Animal
{
    
	public BabyCat(){}
	
    public BabyCat(Animal p)
    {
    	super(p);
    	System.out.println("�⺻ ������ ȣ��");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public BabyCat(String name, int index)
    {
        super.setName(name);
        super.setIndex(index);
        System.out.println("�⺻ ������ ȣ��");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSpeechList("�� �׳� �߷�! ��", 9);
        setSpeechList("����~!", 11);
        setSpeechList("�ɳ�", 12);
        setSpeechList("�����̳� ��~", 13);
        setSpeechList("���� ����ٰž�?", 14);
        setSpeechList("���� �� �߸��ߴٰ�...", 15);
        setSpeechList("���߿ˤ�", 16);
    }
    
    public BabyCat(String name, int price, boolean flag)
    {
    	this();
    	super.setName(name);
    	super.setPrice(price);
    }
    
    //change
    public void levelUp(User presentUser, int index)
    {
        super.levelUp();
        super.setPower(super.getPower()+10);
        super.setStemina(super.getStemina()+30);
        super.setDefense(super.getDefense()+15);

        if(super.getLevel()==2)
            this.grow(presentUser, index);
    }

    public boolean checkExp()
    {
    	if(this.getExp()>=20&&this.getLevel()<5) {
    		this.levelUp();
    		
    		if(super.getLevel() == 2) {
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
    	System.out.println("����� ��ȭ  " + presentUser);
        presentUser.setAnimal(index, new AdultCat(this));
        
        
    }
}
