
public class GlobalEvents {
	public GLOBALEVENTTYPES currEvent;
	
	public String msg = "nan"; 
	public MAPS map = MAPS.Err;
	
	GlobalEvents(){
		currEvent = GLOBALEVENTTYPES.Nan;
	}
	
	public void clear() {
		this.currEvent = GLOBALEVENTTYPES.Nan;
		this.msg = "";
	}
}
