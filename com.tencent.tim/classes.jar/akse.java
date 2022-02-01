import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.AccountPanel.20.1;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class akse
  extends aktr
{
  akse(akrv paramakrv) {}
  
  public void V(boolean paramBoolean, Bundle paramBundle)
  {
    super.V(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      akrv.a(this.this$0, akrv.a(this.this$0).getOnlineStatus());
      akrv.b(this.this$0, -1L);
      if (akrv.a(this.this$0) != null) {
        akrv.a(this.this$0).a(akrv.a(this.this$0));
      }
    }
  }
  
  public void s(boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null) {
      i = (int)paramBundle.getLong("onlineStatus", 0L);
    }
    paramBundle = AppRuntime.Status.build(i);
    if ((paramBoolean) && (akrv.a(this.this$0) != null)) {
      akrv.a(this.this$0).a(paramBundle);
    }
    ThreadManager.getUIHandler().post(new AccountPanel.20.1(this, paramBoolean, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akse
 * JD-Core Version:    0.7.0.1
 */