import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import java.lang.ref.WeakReference;

public class afjb
  extends VasQuickUpdateManager.CallBacker
{
  public afjb(MessengerService.a parama) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    paramString2 = (MessengerService)this.this$0.gI.get();
    if (paramString2 == null) {}
    do
    {
      do
      {
        return;
      } while ((paramLong != 15L) || (!paramString1.startsWith("card.")));
      paramString1 = new Bundle();
    } while ((this == null) || (this.this$0.gI.get() == null) || (paramString2.aF == null));
    paramString2.aF.putString("cmd", "card_download");
    paramString1.putInt("result", paramInt1);
    paramString1.putString("message", paramString3);
    paramString2.aF.putBundle("response", paramString1);
    paramString2.cp(paramString2.aF);
    paramString2.aF = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjb
 * JD-Core Version:    0.7.0.1
 */