import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class vhl
  implements SDKInitListener, vha
{
  private vhb a;
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    vmp.e("WS_VIDEO_PLAYER", "[SuperPlayerSdkMgr.java][initSDK]");
    bapt.a(BaseApplicationImpl.getContext(), this);
  }
  
  public void a(Context paramContext, vhb paramvhb)
  {
    this.a = paramvhb;
    bapt.a(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean a(Context paramContext)
  {
    return bapt.a();
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
 * Qualified Name:     vhl
 * JD-Core Version:    0.7.0.1
 */