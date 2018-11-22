import java.util.concurrent.ThreadLocalRandom;
public class ETHAddressPubPrivKeyCycler {
	    public static void main ( String [] arguments )
	    {
	        String privkey = "";
	        
	        String digitHex;
	        int digit;
	        int fcounter = 0;
	        
	        //64 hex characters in an Ethereum private Key, with the constraint that it must 
	        //also be a valid value on the secp256k1 curve
	        //Valid private keys may range from
	        //0000000000000000000000000000000000000000000000000000000000000001
	        //to
	        //fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141
	        for(int i = 0; i<64; i++) {
	        	//edge case that f is (pseudo)randomly chosen 31 times in a row to 
	        	if(i == 31 && fcounter == 31) {  
	        		privkey = completer(privkey);
	        		break;
	        	}
	        	
	        	digit = ThreadLocalRandom.current().nextInt(0, 16);
	        	digitHex = Integer.toHexString(digit);
	        	privkey += digitHex;
	        	
	        	if(digitHex.equals("f")) fcounter++;
	        }
	        
	        //print privkey, and next 100 private keys in sequence, 
	        
	    }
	    
	    //complete edge case private key
	    private static String completer (String incompletePrivKey) {
	        String maximum = "ebaaedce6af48a03bbfd25e8cd0364141";
	        return "";        
	    }
}
