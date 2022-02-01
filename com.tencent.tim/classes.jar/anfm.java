import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class anfm
{
  int dFh;
  int dFi;
  int dFj;
  int dFk;
  
  public static anfm a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        anfm localanfm = new anfm();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localanfm.dFj = localJSONObject.optInt("showRed", 0);
          localanfm.dFk = localJSONObject.optInt("version", 0);
          return localanfm;
        }
        paramString = localanfm;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localanfm.dFh = localJSONObject.optInt("showRed", 0);
        localanfm.dFi = localJSONObject.optInt("version", 0);
        return localanfm;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoAndHotPicRedDotConfProcessor", 2, "handleGetPtvHotPicConfig Exception :", paramString);
      }
      paramString = null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfm
 * JD-Core Version:    0.7.0.1
 */