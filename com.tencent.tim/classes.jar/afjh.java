import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;

public class afjh
  implements abto.d
{
  public afjh(MessengerService.a parama, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void aR(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("apollo_apolloVipFlag", this.cRh);
      localBundle.putInt("apollo_apolloVipLevel", this.cRi);
      localBundle.putInt("apollo_result", 0);
      localBundle.putInt("apollo_partnerRoleId", this.cRj);
      localBundle.putString("apollo_json", this.val$json);
      localBundle.putInt("apollo_previewAction", this.cRg);
      localBundle.putBoolean("apollo_previewOnFrame", this.bYq);
      localBundle.putString("apollo_id", this.bgz);
      localBundle.putString("title", this.val$title);
      localBundle.putString("subTitle", this.bDt);
      localBundle.putBoolean("apollo_is_super_yellow", abhh.Yc());
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.cp(this.val$reqbundle);
      return;
    }
    localBundle.putInt("apollo_result", 1);
    localBundle.putInt("apollo_audioId", paramInt);
    localBundle.putString("apollo_json", this.val$json);
    this.val$reqbundle.putBundle("response", localBundle);
    this.val$service.cp(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjh
 * JD-Core Version:    0.7.0.1
 */