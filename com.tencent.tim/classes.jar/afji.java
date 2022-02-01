import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;

public class afji
  implements abto.b
{
  public afji(MessengerService.a parama, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    if (paramBoolean)
    {
      paramString.putInt("apollo_result", 0);
      paramString.putInt("apollo_roleId", paramInt1);
      paramString.putInt("apollo_fromSelf", this.cRk);
      paramString.putIntArray("apollo_dressIds", paramArrayOfInt);
      this.val$reqbundle.putBundle("response", paramString);
      this.val$service.cp(this.val$reqbundle);
      return;
    }
    paramString.putInt("apollo_result", 1);
    paramString.putInt("apollo_fromSelf", this.cRk);
    this.val$reqbundle.putBundle("response", paramString);
    this.val$service.cp(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afji
 * JD-Core Version:    0.7.0.1
 */