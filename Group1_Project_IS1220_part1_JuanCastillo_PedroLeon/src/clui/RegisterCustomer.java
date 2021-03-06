package clui;

import exceptions.*;
import users.Customer;
/**
 * RegisterCustomer 7 "firstName" "lastName" "username" "address" "password" "phoneNumber" "email"
 * @author Pedro Le�n
 *
 */
public class RegisterCustomer implements CommandProcessor{
	final int nArgs = 7;
	
	/* (non-Javadoc)
	 * @see clui.CommandProcessor#process(java.lang.String[])
	 */
	@Override
	public String process(String[] args) {
		try{
			if(args.length == nArgs){
				MyFoodora.core.addUser(new Customer(args[0],args[2],args[1],MyFoodora.stringCast.string2Address(args[3]),args[6],args[5],args[4]));
				return ("Customer: -" + args[2] + "- registered.");
			}else{
				throw new NumberOfArgumentsException();
			}
		}catch(InputMismatchException e){
			return e.getMessage();
		}catch(UsernameAlreadyRegisteredException e){
			return e.getMessage();
		}catch(NumberOfArgumentsException e){
			return e.getMessage();
		}catch(AccessDeniedException e){
			return e.getMessage();
		}
	}
}
