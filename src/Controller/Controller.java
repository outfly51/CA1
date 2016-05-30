package Controller;
import Model.User;
import View.*;

public class Controller {
	public MainFrame m;
	protected User presentUser;
	
	//temporary value;
	private String userName;
	private int petNum;
	private String petName;
	
	public Controller() {
		m = new MainFrame(this);
		m.gotoStartPage();  //startPage ȣ��.
	}
	
	//start page
	public void goUserSetting() {
		System.out.println("��ŸƮ ��ư�� ���ȴ°� ��Ʈ�ѷ����� �˾ҽ��ϴ�.");
		m.gotoUserSettingPage();
	}
	public void loadFile() {
	}
	public void gameExit() {
		System.out.println("��Ʈ�ѷ����� �˾����� : ���� ����.");
		System.exit(0);
	}
	
	//userSettingPage
	public void goPetSetting(String userName) {
		System.out.println("���� �̸� : " + userName + "�� �޾ҽ��ϴ�.");
		this.userName = userName;
		m.gotoPetSettingPage();
	}
	
	//petSettingPage
	public void goStartingPoint(int petNum, String petName)
	{
		System.out.println(petNum + ", " + petName + "�����͸� ����.");
		/*
		 * ������ pet�ʱ�ȭ �ϴ� �κ� �ʿ�.
		 * 
		 * 
		 */
		presentUser=new User(userName, petNum, petName);
		m.gotogameStartingPoint();
		this.viewLivingroomStatus();
		m.livingroomPage.createPetIcon(presentUser.getPet(0));
		m.setVisible(true);
	}
	
	public void viewLivingroomStatus()
	{
		m.livingroomPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());	
	}
	public void viewBathroomStatus()
	{
		m.bathroomPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());
	}
	public void viewShopStatus()
	{
		m.shopPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());
	}
	public void viewYardStatus()
	{
		m.yardPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());
	}
	
	public String[] appendClosetItemList()
	{
		String[] list=presentUser.getClothItemNameList();
		return list;
	}
	
	public String[] appendFoodItemList()
	{
		String[] list=presentUser.getFoodItemList();
		return list;
	}
	
	public User getPresentUser()
	{
		return this.presentUser;
	}
}
