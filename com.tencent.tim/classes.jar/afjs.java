import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.4;

public class afjs
  implements ablz.d
{
  public afjs(MessengerService.IncomingHandler.4 param4) {}
  
  public void Hu(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt);
    this.a.val$reqbundle.putBundle("response", localBundle);
    this.a.val$service.cp(this.a.val$reqbundle);
  }
  
  public void cDa()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    this.a.val$reqbundle.putBundle("response", localBundle);
    this.a.val$service.cp(this.a.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjs
 * JD-Core Version:    0.7.0.1
 */