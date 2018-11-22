import java.util.concurrent.ThreadLocalRandom;
public class ETHAddressPubPrivKeyCycler {
	    public static void main ( String [] arguments )
	    {
	        String privkey = "";
	        
	        int digit;
	        
	        //64 hex characters in an Ethereum private Key, with the constraint that it must 
	        //also be a valid value on the secp256k1 curve
	        //Valid private keys may range from
	        //0000000000000000000000000000000000000000000000000000000000000001
	        //to
	        //fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141
	        for(int i = 0; i<64; i++) {
	        	digit = ThreadLocalRandom.current().nextInt(0, 16);
	        	privkey += Integer.toHexString(digit);
	        }

	    }
}
