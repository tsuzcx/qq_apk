import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class vhr
  implements TVK_SDKMgr.InstallListener, vha
{
  private vhb a;
  
  public void a()
  {
    TVK_SDKMgr.setOnLogListener(new vht(null));
  }
  
  public void a(Context paramContext)
  {
    TVK_SDKMgr.setDebugEnable(true);
    TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public void a(Context paramContext, vhb paramvhb)
  {
    this.a = paramvhb;
    if (paramContext != null) {
      TVK_SDKMgr.installPlugin(paramContext, this);
    }
  }
  
  public boolean a(Context paramContext)
  {
    return TVK_SDKMgr.isInstalled(paramContext);
  }
  
  public void onInstallProgress(float paramFloat)
  {
    if (this.a != null) {
      this.a.a(paramFloat);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhr
 * JD-Core Version:    0.7.0.1
 */