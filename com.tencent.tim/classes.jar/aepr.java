import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aepr
  implements aehx<String>
{
  public String bAw = "{}";
  public boolean bVt;
  
  public void lR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.bAw = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("dialogSwitch")) {
        this.bVt = paramString.getBoolean("dialogSwitch");
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepr
 * JD-Core Version:    0.7.0.1
 */