import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rz
  implements LoadedBack
{
  public rz(OfflinePlugin paramOfflinePlugin) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 9)
    {
      try
      {
        localObject = new JSONObject(paramString);
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          localJSONException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(OfflinePlugin.a(this.a), 2, "checkUp loaded err:" + paramString);
          }
          paramString = null;
        }
      }
      localObject = this.a.a.obtainMessage();
      ((Message)localObject).arg1 = 3;
      ((Message)localObject).obj = paramString;
      this.a.a.sendMessage((Message)localObject);
    }
    while (paramInt != -1) {
      return;
    }
    paramString = this.a.a.obtainMessage();
    paramString.arg1 = 2;
    this.a.a.sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     rz
 * JD-Core Version:    0.7.0.1
 */