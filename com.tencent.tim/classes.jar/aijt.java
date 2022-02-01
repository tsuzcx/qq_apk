import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aijt
  implements jol.a
{
  aijt(aijs paramaijs) {}
  
  public void am(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.a.bOk))
    {
      paramBundle = paramBundle.getString("info");
      localJSONObject = new JSONObject();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("data", paramBundle);
        this.a.callJs(this.a.bOk, new String[] { localJSONObject.toString() });
        if (QLog.isColorLevel()) {
          QLog.d("PushApiPlugin", 2, new Object[] { "handleJsRequest callback:", paramBundle });
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("PushApiPlugin", 1, paramBundle, new Object[0]);
        return;
      }
    }
    QLog.d("PushApiPlugin", 2, "handleJsRequest callback is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijt
 * JD-Core Version:    0.7.0.1
 */