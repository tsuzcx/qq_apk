import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

public class ylt
  implements TVK_SDKMgr.OnLogListener
{
  public ylt(TribeVideoPlugin paramTribeVideoPlugin) {}
  
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TribeVideoPlugin", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoPlugin", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TribeVideoPlugin", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylt
 * JD-Core Version:    0.7.0.1
 */