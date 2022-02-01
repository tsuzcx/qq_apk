import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aepp
  implements aehx<String>
{
  public String bAu = "";
  public String bAv = "";
  public String bAw = "{}";
  public boolean bVs;
  
  public void lR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.bAw = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("actionSwitch")) {
        this.bVs = paramString.getBoolean("actionSwitch");
      }
      if (paramString.has("actionHint")) {
        this.bAu = paramString.getString("actionHint");
      }
      if (paramString.has("actionYYBDownloadUrl")) {
        this.bAv = paramString.getString("actionYYBDownloadUrl");
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepp
 * JD-Core Version:    0.7.0.1
 */