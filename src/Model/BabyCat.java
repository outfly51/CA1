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
    
	public BabyCat(){
		
    }
    public BabyCat(Animal p) {
    	super(p);
    	System.out.println("�⺻ ������ ȣ��");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public BabyCat(String name)
    {
        super.setName(name);
        System.out.println("�⺻ ������ ȣ��");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSpeechList(" ", 8);
        setSpeechList(" ", 9);
        setSpeechList(" ", 10);
        setSpeechList(" ", 11);
        setSpeechList(" ", 12);
        setSpeechList(" ", 13);
        setSpeechList(" ", 14);
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

    public void grow(User presentUser, int index)
    {
        presentUser.setAnimal(index, new AdultCat((Animal)this));
        
        
    }
}
