import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;

public class afjk
  implements ablz.b
{
  public afjk(MessengerService.a parama, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void Ht(int paramInt)
  {
    this.aH.putInt("result", paramInt);
    this.val$reqbundle.putBundle("response", this.aH);
    this.val$service.cp(this.val$reqbundle);
  }
  
  public void cCZ()
  {
    this.aH.putInt("result", 0);
    this.val$reqbundle.putBundle("response", this.aH);
    this.val$service.cp(this.val$reqbundle);
  }
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjk
 * JD-Core Version:    0.7.0.1
 */