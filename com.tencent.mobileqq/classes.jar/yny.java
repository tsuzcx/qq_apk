import com.tencent.qphone.base.util.QLog;
import com.tencent.tgpa.vendorpd.GameCallback;
import org.json.JSONObject;

public final class yny
  implements GameCallback
{
  public yny(JSONObject paramJSONObject) {}
  
  public int getPreDownloadVersionInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterCheck", 2, "checkGameRes.getGameVersionUpdateInfo res =" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("ret") == 0)
      {
        paramString = paramString.optJSONObject("data");
        bicy.a().a(paramString, this.a);
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("GameCenterCheck", 1, "checkGameRes.getPreDownloadVersionInfo e=" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yny
 * JD-Core Version:    0.7.0.1
 */