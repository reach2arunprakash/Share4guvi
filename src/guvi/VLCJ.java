package guvi;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;

public class VLCJ {
	
	public static void main(String[] args) {
	    Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
	  }

}
