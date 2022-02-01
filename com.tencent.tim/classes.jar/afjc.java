import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class afjc
  extends VasQuickUpdateManager.CallBacker
{
  public afjc(MessengerService.a parama, MessengerService paramMessengerService) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (this.val$service.aC != null)
      {
        paramString1 = new Bundle();
        this.val$service.aC.putString("cmd", "card_download_wzry_template");
        paramString1.putInt("result", paramInt1);
        paramString1.putString("message", paramString3);
        this.val$service.aC.putBundle("response", paramString1);
        this.val$service.cp(this.val$service.aC);
        this.val$service.aC = null;
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjc
 * JD-Core Version:    0.7.0.1
 */