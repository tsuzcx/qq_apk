import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.1;
import org.json.JSONObject;

public final class tlf
{
  public static void as(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject;
    if (paramJSONObject != null)
    {
      localJSONObject = paramJSONObject;
      if (paramJSONObject != JSONObject.NULL) {}
    }
    else
    {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("ct", System.currentTimeMillis());
      paramJSONObject = localJSONObject.toString().getBytes();
      AdThreadManager.INSTANCE.post(new GdtReportForAntiSpam.1(paramJSONObject), 4);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        tkw.e("GdtReportForAntiSpam", "reportAntiSpamForClick", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlf
 * JD-Core Version:    0.7.0.1
 */