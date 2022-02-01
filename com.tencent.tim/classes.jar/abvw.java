import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.utils.SoUtil;
import com.tencent.qphone.base.util.QLog;

class abvw
  implements AVCallback
{
  abvw(abvq paramabvq) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      if (!this.b.Zm())
      {
        aqhq.copyFile(abwe.getSoDir() + "libqav_graphics.so", abwe.getSoDir() + "libtmg_graphics.so");
        boolean bool = SoUtil.loadSo("tmg_graphics");
        QLog.e("AVEngineWalper", 1, "first check failed, rename bLoad = " + bool);
        if (!this.b.Zm())
        {
          QLog.e("AVEngineWalper", 1, "Second check failed, stop engine~~~");
          abvq.a(this.b, false);
          this.b.cFM();
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if (this.b.b != null) {
        this.b.b.bM(paramInt, paramString);
      }
      return;
      abvq.a(this.b, true);
      QLog.e("AVEngineWalper", 1, "start successfully second try~~~~");
      continue;
      abvq.a(this.b, true);
      QLog.e("AVEngineWalper", 1, "start successfully~~~~");
      continue;
      QLog.e("AVEngineWalper", 1, "AVCallback result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvw
 * JD-Core Version:    0.7.0.1
 */