import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import java.util.List;
import mqq.observer.BusinessObserver;

public class daz
  implements BusinessObserver
{
  public daz(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("update_type");
      if (paramInt != 2) {}
    }
    do
    {
      return;
      if (paramInt == 1) {
        PublicAccountChatActivity.a(this.a).a();
      }
      paramBundle = PublicAccountChatActivity.a(this.a).a(this.a.b, this.a.c());
      PublicAccountChatActivity.a(this.a, paramBundle);
    } while ((paramBundle == null) || (paramBundle.isEmpty()));
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     daz
 * JD-Core Version:    0.7.0.1
 */