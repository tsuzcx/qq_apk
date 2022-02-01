import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class skn
  implements sli.a
{
  skn(skl paramskl, String paramString) {}
  
  public void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("retCode", 0);
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("errMsg", paramString2);
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("file", paramString1);
        }
        this.a.callJs(this.val$callback, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e(this.a.TAG, 1, paramString2, paramString1);
      }
      localJSONObject.put("retCode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skn
 * JD-Core Version:    0.7.0.1
 */