import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class ule
{
  private static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new ulf(this));
  private ulg jdField_a_of_type_Ulg;
  private boolean jdField_a_of_type_Boolean;
  
  public ule()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void c()
  {
    TVK_SDKMgr.setOnLogListener(new uli(null));
    try
    {
      if (!b)
      {
        TVK_SDKMgr.setDebugEnable(true);
        TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        uqf.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new WSVideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(ulg paramulg)
  {
    this.jdField_a_of_type_Ulg = paramulg;
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ulg = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ule
 * JD-Core Version:    0.7.0.1
 */