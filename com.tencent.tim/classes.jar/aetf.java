import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aetf
{
  private String bBd = "";
  private boolean bWh;
  
  public static aetf a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      paramArrayOfaeic = null;
    }
    aetf localaetf;
    for (;;)
    {
      return paramArrayOfaeic;
      localaetf = new aetf();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[0].content);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localaetf.bBd = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localaetf.bBd);
          }
        }
        paramArrayOfaeic = localaetf;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localaetf.bWh = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaeic = localaetf;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localaetf.bWh);
            return localaetf;
          }
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        paramArrayOfaeic.printStackTrace();
      }
    }
    return localaetf;
  }
  
  public boolean ahN()
  {
    return this.bWh;
  }
  
  public String tL()
  {
    if (TextUtils.isEmpty(this.bBd)) {
      return null;
    }
    return this.bBd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetf
 * JD-Core Version:    0.7.0.1
 */