import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.qphone.base.util.QLog;

class adra
  implements ArkAppPreloader.PreloadAppCallback
{
  adra(adqy paramadqy) {}
  
  public void beginAppload(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      adqt.ld(paramString);
    }
  }
  
  public void onAppLoaded(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      adqt.le(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preload app appname=", paramString, ",success=", Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void onReleaseAndReload(String paramString, int paramInt)
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload begin app = " + paramString);
    ArkAppMgr.getInstance().getAppPathByName(paramString, "", "0.0.0.1", null, new adrb(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adra
 * JD-Core Version:    0.7.0.1
 */