import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;

public class afje
  implements abto.b
{
  public afje(MessengerService.a parama, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    if (paramBoolean)
    {
      paramString.putInt("apollo_result", 0);
      paramString.putIntArray("apollo_dressIds", paramArrayOfInt);
      this.val$reqbundle.putBundle("response", paramString);
      this.val$service.cp(this.val$reqbundle);
      return;
    }
    paramString.putInt("apollo_result", 1);
    this.val$reqbundle.putBundle("response", paramString);
    this.val$service.cp(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afje
 * JD-Core Version:    0.7.0.1
 */