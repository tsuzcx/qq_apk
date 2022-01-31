import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.utils.SoUtil;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.mobileqq.apollo.tmg_opensdk.TMG_Downloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

public class ysd
  implements AVCallback
{
  public ysd(AVEngineWalper paramAVEngineWalper) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      if (!this.a.a())
      {
        FileUtils.d(TMG_Downloader.a() + "libqav_graphics.so", TMG_Downloader.a() + "libtmg_graphics.so");
        boolean bool = SoUtil.loadSo("tmg_graphics");
        QLog.e("AVEngineWalper", 1, "first check failed, rename bLoad = " + bool);
        if (!this.a.a())
        {
          QLog.e("AVEngineWalper", 1, "Second check failed, stop engine~~~");
          AVEngineWalper.a(this.a, false);
          this.a.a();
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(paramInt, paramString);
      }
      return;
      AVEngineWalper.a(this.a, true);
      QLog.e("AVEngineWalper", 1, "start successfully second try~~~~");
      continue;
      AVEngineWalper.a(this.a, true);
      QLog.e("AVEngineWalper", 1, "start successfully~~~~");
      continue;
      QLog.e("AVEngineWalper", 1, "AVCallback result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysd
 * JD-Core Version:    0.7.0.1
 */