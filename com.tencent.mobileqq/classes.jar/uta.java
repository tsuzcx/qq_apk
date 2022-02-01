import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class uta
  implements SDKInitListener, usp
{
  private usq a;
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    uya.e("WS_VIDEO_PLAYER", "[SuperPlayerSdkMgr.java][initSDK]");
    azjl.a(BaseApplicationImpl.getContext(), this);
  }
  
  public void a(Context paramContext, usq paramusq)
  {
    this.a = paramusq;
    azjl.a(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean a(Context paramContext)
  {
    return azjl.a();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a();
      return;
    }
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uta
 * JD-Core Version:    0.7.0.1
 */