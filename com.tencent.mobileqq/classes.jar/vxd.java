import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

public class vxd
  implements TVK_SDKMgr.OnLogListener
{
  public int a;
  
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.contains("INFO_TRY_AGAIN_LATER"))) {}
    try
    {
      this.a = Integer.parseInt(paramString2.substring(paramString2.lastIndexOf("=") + 1));
      label32:
      if (QLog.isColorLevel()) {
        QLog.w(paramString1, 2, paramString2);
      }
      return 0;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxd
 * JD-Core Version:    0.7.0.1
 */