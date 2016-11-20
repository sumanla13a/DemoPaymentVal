package cs544.paymentvalidator.cardvalidation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.grp11.util.ResponseObj;

@Controller
@RequestMapping("/card_validation")
public class CreditCardValidation {
	public static final String regexp = "6(?:011|5[0-9]{2})[0-9]{12}";
	/*public static void main(String[] args) {
		System.out.println("6011111111111117".matches(regexp));
	}*/
	@RequestMapping(value = "/isvalid", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseObj isValid(@RequestParam("cardNumber") String cardNumber) {
		System.out.println("in validation");
		ResponseObj r = new ResponseObj();
		if(cardNumber.matches(regexp)) {
			r.setDescription("card is valid");
			r.setSuccess(true);
			r.setValid(true);
		} else {
			r.setDescription("card is invalid");
			r.setSuccess(true);
			r.setValid(false);
		}
		return r;
	}
	
	@RequestMapping(value = "/hasbalance", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseObj hasBalance(@RequestParam("cardNumber") String cardNumber) {
		//TODO: figure this part later
		System.out.println("in validation");
		ResponseObj r = new ResponseObj();
		r.setDescription("card has balance");
		r.setSuccess(true);
		r.setValid(true);
		return r;
	}
}
