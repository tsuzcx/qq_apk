import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class thq
{
  private static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new thr(this));
  private ths jdField_a_of_type_Ths;
  private boolean jdField_a_of_type_Boolean;
  
  public thq()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void c()
  {
    TVK_SDKMgr.setOnLogListener(new thu(null));
    try
    {
      if (!b)
      {
        TVK_SDKMgr.setDebugEnable(true);
        TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        tlo.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
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
  
  public void a(ths paramths)
  {
    this.jdField_a_of_type_Ths = paramths;
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ths = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thq
 * JD-Core Version:    0.7.0.1
 */