package View;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Animal;
import Model.Waste;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import java.awt.Color;

public class BathroomPage extends Place
{	
	protected JButton btnGoShop;
	protected JButton btnGoYard;
	protected JButton btnGoLivingroom;
	protected JButton closetBtn;
	protected JButton toiletBtn;
	protected JLabel UsersClothItem;
	protected JPanel clothItemInfo;
	protected JPanel petInfo;
	
	protected JTextArea petItemList;
	protected JTextArea statArea;
	
	protected PetLabel petIcon[];
	public JLabel simpleUserInfo;
	protected JLabel petStat;
	
	protected JButton []cloth;
	protected JLabel emptyLabel;
	/**
	 * Create the panel.
	 */
	public BathroomPage(Controller c) {
		super(c);
		waste=new Waste[5];
        super.setPlaceName("Bathroom");
        
        super.setPlaceName("Bathroom");
        petIcon = new PetLabel[5];
		for (int i = 0; i < petIcon.length; i++)
			petIcon[i] = null;

		setBounds(100, 100, 900, 540);
		setLayout(null);
		
		btnGoShop = new JButton("Go Shop");
		btnGoShop.setBounds(0, 0, 300, 50);
		add(btnGoShop);
		
		btnGoYard = new JButton("Go Yard");
		btnGoYard.setBounds(300, 0, 300, 50);
		add(btnGoYard);
		
		btnGoLivingroom = new JButton("Go Livingroom");
		btnGoLivingroom.setBounds(600, 0, 300, 50);
		add(btnGoLivingroom);
		
		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(621, 60, 247, 43);
		add(simpleUserInfo);
		
		closetBtn = new JButton("Closet");
		closetBtn.setBounds(73, 96, 100, 100);
		add(closetBtn);
		
		toiletBtn = new JButton("Toilet");
		toiletBtn.setBounds(347, 96, 100, 100);
		add(toiletBtn);
		
		/*
		JButton petBtn = new JButton("Pet");
		petBtn.setBounds(347, 243, 100, 100);
		add(petBtn);
		*/

		//����
		clothItemInfo = new JPanel();
		clothItemInfo.setBounds(41, 216, 192, 230);
		add(clothItemInfo);
		clothItemInfo.setLayout(null);
		
		//����
		UsersClothItem = new JLabel("User's cloth item");
		UsersClothItem.setFont(new Font("����", Font.BOLD, 20));
		UsersClothItem.setBounds(12, 10, 192, 15);
		clothItemInfo.add(UsersClothItem);
		
		cloth=new JButton[3];
		
		cloth[0] = new JButton("0");
		cloth[0].setBounds(48, 56, 97, 23);
		cloth[0].setVisible(false);
		clothItemInfo.add(cloth[0]);
		
		cloth[1] = new JButton("1");
		cloth[1].setBounds(48, 115, 97, 23);
		cloth[1].setVisible(false);
		clothItemInfo.add(cloth[1]);
		
		cloth[2] = new JButton("2");
		cloth[2].setBounds(48, 179, 97, 23);
		cloth[2].setVisible(false);
		clothItemInfo.add(cloth[2]);
		
		emptyLabel = new JLabel("Empty!");
		emptyLabel.setForeground(Color.RED);
		emptyLabel.setFont(new Font("����", Font.BOLD, 29));
		emptyLabel.setBounds(39, 71, 129, 53);
		emptyLabel.setVisible(false);
		clothItemInfo.add(emptyLabel);
		
		clothItemInfo.setVisible(false);
		
		//����2
		petInfo = new JPanel();
		petInfo.setBounds(673, 216, 195, 230);
		add(petInfo);
		petInfo.setLayout(null);
		
		petInfo.setVisible(false);
		
		//����2
		petStat = new JLabel("Pet stat");
		petStat.setFont(new Font("����", Font.BOLD, 20));
		petStat.setBounds(61, 10, 134, 25);
		petStat.setVisible(false);
		petInfo.add(petStat);
		
		statArea = new JTextArea();
		statArea.setBounds(12, 37, 171, 183);
		statArea.setEditable(false);
		statArea.setVisible(false);
		petInfo.add(statArea);
		
		/*
		//����3
		JPanel petClick = new JPanel();
		petClick.setBounds(500, 243, 113, 119);
		add(petClick);
		
		//����3
		JButton changePetPlaceBtn = new JButton("Change pet place");
		petClick.add(changePetPlaceBtn);
		
		//����3
		JButton ridDrappingsBtn = new JButton("Rid drappings");
		petClick.add(ridDrappingsBtn);
		
		//����3
		JButton undressBtn = new JButton("Undress");
		petClick.add(undressBtn);
		
		//����3
		JButton checkPetStatBtn = new JButton("Check Pet Stat");
		petClick.add(checkPetStatBtn);
		
		petClick.setVisible(false);
		*/
	}
	
	public void createPetIcon(Animal pet) {
		for (int i = 0; i < petIcon.length; i++) {
			if (petIcon[i] == null) {
				petIcon[i] = new PetLabel(pet, this);
				
				try {
					petIcon[i].setIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_cat\\ordinary.png"))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				petIcon[i].setBounds(336, 342, 100, 100);
				//petIcon[i].addMouseListener(this);
				this.add(petIcon[i]);
				petIcon[i].setVisible(true);
				
				petIcon[i].behaviorItem7.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						String []list=pet.getPetStatList();
						c.m.showAnimalStat(list);
					}
				});
				
				break;
			}

			if (i == petIcon.length - 1)
				System.out.println("���� �� �߰��� �� �����ϴ�.");
		}
	}

	@Override
	public void delectIcon(Animal pet) {
		for(int i = 0; i < petIcon.length; i++) {
			if(petIcon[i] != null) {
				if(petIcon[i].pet == pet) {
					System.out.println(i + "??");
					petIcon[i].setVisible(false);
					petIcon[i] = null;
				}
			}
		}
	}
}