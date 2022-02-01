import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aetl
{
  private boolean bWj;
  private int cPa = 1;
  
  public static aetl a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aetl localaetl = new aetl();
    try
    {
      a(localaetl, new JSONObject(paramArrayOfaeic[0].content));
      return localaetl;
    }
    catch (JSONException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
    return localaetl;
  }
  
  public static void a(aetl paramaetl, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramaetl == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramaetl.bWj = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramaetl.cPa = paramJSONObject.optInt("dialogShowMaxTimes");
  }
  
  public int Cs()
  {
    return this.cPa;
  }
  
  public boolean ahO()
  {
    return this.bWj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetl
 * JD-Core Version:    0.7.0.1
 */