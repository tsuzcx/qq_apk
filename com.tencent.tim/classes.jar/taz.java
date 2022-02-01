import com.tencent.tgpa.vendorpd.GameCallback;
import org.json.JSONObject;

public final class taz
  implements GameCallback
{
  public taz(JSONObject paramJSONObject) {}
  
  public int getPreDownloadVersionInfo(String paramString)
  {
    asbt.i("GameCenterCheck", "checkGameRes.getGameVersionUpdateInfo res =" + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("ret") == 0)
      {
        paramString = paramString.optJSONObject("data");
        awot.a().g(paramString, this.aN);
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        asbt.i("GameCenterCheck", "checkGameRes.getPreDownloadVersionInfo e=" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     taz
 * JD-Core Version:    0.7.0.1
 */