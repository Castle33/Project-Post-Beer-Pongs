package clui;

import exceptions.NumberOfArgumentsException;
import exceptions.InputMismatchException;
import system.Order;
import restaurant_structure.Item;

/**
 * AddItem2Order 3 "orderName" "itemName" "itemQuantity"
 * @author Pedro Le�n
 *
 */
public class AddItem2Order implements CommandProcessor{
	final int nArgs = 3;
	private Order orderFound;
	private Item itemFound;
	/* (non-Javadoc)
	 * @see clui.CommandProcessor#process(java.lang.String[])
	 */
	@Override
	public String process(String[] args) {
		try{
			if(args.length == nArgs){
				for(Order o : MyFoodora.listTempOrders){
					if(o.getName().equals(args[0])){
						orderFound = o;
					}
				}
				if(orderFound != null){
					itemFound = orderFound.getRestaurant().getItemByName(args[1]);
					if(itemFound != null){
						orderFound.addItem(itemFound, MyFoodora.stringCast.string2Integer(args[2]));
						return "Customer: -" + MyFoodora.core.getCurrentUser().getUsername() + "- added Item: -" + args[1] + "- to Order -" + args[0] + "-.";
					}else{
						return "Item: -" + args[1] + "- not in " + orderFound.getRestaurant().getName() + "'s menu.";
					}
				}else{
					return "Order: -" + args[0] + "- not created in MyFoodora.\nFor order creation use createOrder <restaurantUsername> <orderName>.";
				}
			}else{
				throw new NumberOfArgumentsException();
			}
		}catch(NumberOfArgumentsException e){
			return e.getMessage();
		}catch(InputMismatchException e){
			return e.getMessage();
		}
	}
}
