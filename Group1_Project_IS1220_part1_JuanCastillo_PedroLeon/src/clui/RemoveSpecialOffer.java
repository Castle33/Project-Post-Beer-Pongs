package clui;

import exceptions.AccessDeniedException;
import exceptions.NumberOfArgumentsException;
import restaurant_structure.Item;
import restaurant_structure.Meal;
/**
 * RemoveSpecialOffer 1 <mealName>
 * @author Pedro Le�n
 *
 */
public class RemoveSpecialOffer implements CommandProcessor {
	final int nArgs = 1;
	Item item;
	/* (non-Javadoc)
	 * @see clui.CommandProcessor#process(java.lang.String[])
	 */
	@Override
	public String process(String[] args) throws NumberOfArgumentsException {
		try{
			if(args[nArgs] == null){
				for( Meal m : MyFoodora.listTempMeals){
					if(m.getName() == args[1]){
						MyFoodora.core.removeSpecialMeal(m);
						return "Meal: " + m.getName() + " removed from " + MyFoodora.core.getCurrentUser().getName() + "'s list of special offer.";
					}
				}
			}else{
				throw new NumberOfArgumentsException();
			}
		}catch(NumberOfArgumentsException e){
			System.out.println(e.getMessage());
			return null;
		}catch(AccessDeniedException e){
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}