import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

class vht
  implements TVK_SDKMgr.OnLogListener
{
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    vmp.d("WS_PLAYER_SDK_" + paramString1, 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      vmp.a("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      vmp.c("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vht
 * JD-Core Version:    0.7.0.1
 */