import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class itj
{
  private static jjx.a a;
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVPushReport", 2, "onAvReportPush : rspType = " + paramInt + ",rspBody = " + paramString);
    }
    if (a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVPushReport", 2, "ReportTask is running.");
      }
      return;
    }
    String str;
    if (vl()) {
      str = "https://play.mobile.qq.com/avreport_test/cgi-bin/report";
    }
    try
    {
      for (;;)
      {
        paramString = new JSONObject(paramString).optJSONObject("attach");
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("uin", paramVideoAppInterface.getLongAccountUin());
          localJSONObject.put("skey", paramVideoAppInterface.getSKey());
          localJSONObject.put("qqversion", "3.4.4");
          localJSONObject.put("time", System.currentTimeMillis());
          if (paramString != null) {
            localJSONObject.put("attach", paramString);
          }
        }
        catch (JSONException paramVideoAppInterface)
        {
          for (;;)
          {
            paramVideoAppInterface.printStackTrace();
          }
        }
        a = new itk(str, localJSONObject.toString(), null);
        a.execute(new Void[0]);
        return;
        str = "https://play.mobile.qq.com/avreport/cgi-bin/report";
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static boolean vl()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itj
 * JD-Core Version:    0.7.0.1
 */