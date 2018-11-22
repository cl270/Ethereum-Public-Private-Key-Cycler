import java.util.concurrent.ThreadLocalRandom;
import org.ethereum.crypto.ECKey;

public class ETHAddressPubPrivKeyCycler {
	    public static void main ( String [] arguments )
	    {
	    	display100();
	    }
	    
	    private static void display100() {
	    	for(int i = 0; i<100; i++) {displayKeys();}
	    }
	    
	    private static void displayKeys() {
	        String privkey = createRandomPrivateKey();
	        
	        
	        //find the ECDSA public key using the SECP256k1 elliptic curve (i.e. y2 = x3 + 7)
	        String pubkey = ECDSA(privkey);
	        
	        //Ethereum public keys take the form of 32 hex characters (128 bits)
	        //The addresses are keccak256 hashes of the public key 
	        //(which are colloquially known in the Ethereum community
	        //as public keys despite it being a misnomer) are 40 hex characters.
	        String address = keccak256(pubkey);
	        
	        //print private key/public key/address trio, 
	        System.out.println("Private: 0x" + privkey + ", Public: 0x" + pubkey + ", Address: 0x" + address);
	    }
	    
	    private static String keccak256(String publicKey) {
	    	return publicKey;
	    }
	    
	    private static String ECDSA(String privateKey) {
	    	return privateKey;
	    }

		private static String createRandomPrivateKey() {
			String privkey = "";
	        String pubkey;
	        String address;
	        
	        String digitHex;
	        int digit;
	        int fcounter = 0;
	        
	        //64 hex characters (256 bits) in an Ethereum private Key, with the constraint that it must 
	        //also be a valid value on the secp256k1 curve
	        //Valid private keys may range from
	        //0000000000000000000000000000000000000000000000000000000000000001
	        //to
	        //fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141
	        for(int i = 0; i<64; i++) {
	        	//edge case that 0xf is (pseudo)randomly chosen 31 times in a row 
	        	if(i == 31 && fcounter == 31) {  
	        		privkey = completer(privkey);
	        		break;
	        	}
	        	
	        	digit = ThreadLocalRandom.current().nextInt(0, 16);
	        	digitHex = Integer.toHexString(digit);
	        	privkey += digitHex;
	        	
	        	if(digitHex.equals("f")) fcounter++;
	        }
			return privkey;
		}
	    
	    //Finish Edge case private key
	    private static String completer (String incompletePrivKey) {
	        String maximum = "ebaaedce6af48a03bbfd25e8cd0364141";
	        String getMaxHex;
	        int digit;
	        
	        for(int i = 0; i<33; i++) {
	        	getMaxHex = Character.toString(maximum.charAt(i));
	        	digit = ThreadLocalRandom.current().nextInt(0, Integer.parseInt(getMaxHex,16)+1);
	        	incompletePrivKey += Integer.toHexString(digit);
	        }
	        
	        return incompletePrivKey;        
	    }
}
