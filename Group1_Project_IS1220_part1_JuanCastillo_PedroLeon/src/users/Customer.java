package users;

import java.io.Serializable;

import restaurant_structure.Meal;
import system.FidelityCard;
import system.FidelityCardBasic;
import system.FidelityCardPoint;
import system.FidelityCardLottery;
/**
 * 
 * @author Juan Castillo (programer)
 * @author Pedro Leon (tester)
 *
 */
public class Customer extends User implements Observer ,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1756158000342775367L;
	private String surname;
	private Address address;
	private String email;
	private String phoneNumber;
	private FidelityCard fidelityCard;
	private boolean beNotified;  // true = be notify -- false = NOT be notify
	/**
	 * tested: YES
	 * @param name
	 * @param username
	 * @param surname
	 * @param address
	 * @param email
	 * @param phoneNumber
	 * @param password
	 */
	public Customer(String name, String username, String surname, Address address, String email, 
			String phoneNumber, String password) {
		super(name, username, password);
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.fidelityCard = new FidelityCardBasic();
		this.beNotified = true;
	}
	
	@Override
	public String toString() {
		return "Customers [name=" + getName() + ", surname=" + surname + ", username=" + getUsername() + 
				", ID=" + getID() + ", address=" + address + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	/***************************************************************************************************/
	/*
	 * Fidelity Card: methods to get and set Fidelity Card Plan and change points of FidelityCardPoint
	 */
	
	public FidelityCard getFidelityCard() {
		return fidelityCard;
	}
	/**
	 * tested: YES
	 * @param fidelityCard
	 */
	public void setFidelityCard(FidelityCard fidelityCard) {
		if(!(fidelityCard.getClass().equals(this.fidelityCard.getClass()))){
			this.fidelityCard = fidelityCard;
		}	
	}
	/**
	 * tested: YES
	 */
	public void setFidelityCardtoBasic(){
		FidelityCardBasic basic = new FidelityCardBasic();
		setFidelityCard(basic);
	}
	/**
	 * tested: YES
	 */
	public void setFidelityCardtoPoints(){
		FidelityCardPoint points = new FidelityCardPoint();
		setFidelityCard(points);
	}
	/**
	 * tested: YES
	 */
	public void setFidelityCardtoLottery(){
		FidelityCardLottery lottery = new FidelityCardLottery();
		setFidelityCard(lottery);
	}
	/**
	 * tested: YES
	 * @return
	 */
	public int getNumberFidelityPoints(){
		if(this.fidelityCard instanceof FidelityCardPoint){
			return ((FidelityCardPoint) this.fidelityCard).getPoints();
		}
		return 0;
	}
	/**
	 * Adds fidelity points to the card
	 * tested: YES
	 * @param n
	 * number of points to add
	 */
	public void addFidelityPoints(int n){
		if(this.fidelityCard instanceof FidelityCardPoint){
			((FidelityCardPoint) this.fidelityCard).setPoints(((FidelityCardPoint) this.fidelityCard).getPoints()+n);
		} else {
			System.out.println("Fidelity Card is not of type Points");
		}
	}
	/**
	 * tested: YES
	 * @param b
	 */
	public void changeBeNotified(boolean b){
		setBeNotified(b);
	}
	/**
	 * tested: YES
	 * @param r
	 * @param m
	 * restaurant 'r' offers a new special meal 'm' 
	 */
	@Override
	public void update(Restaurant r, Meal m){
		if(beNotified){
			/*
			 * show in customer screen new notification
			 * TO DO
			 */
			System.out.println("User: " + this.getUsername() + " got restaurant: " + r.getName() + "'s new special offer " + m.getName() + " last price = " + m.getFullPrice() + ", new price = " + r.getPriceMeal(m));
		}
	}
	
	/***************************************************************************************************/
	/*
	 * Getters and Setters: no setters for ID and Counter
	 */

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the beNotifyed
	 */
	public boolean isBeNotified() {
		return beNotified;
	}

	/**
	 * @param beNotifyed the beNotifyed to set
	 */
	public void setBeNotified(boolean beNotifyed) {
		this.beNotified = beNotifyed;
	}
	
	
}