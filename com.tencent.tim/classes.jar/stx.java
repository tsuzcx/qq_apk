import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class stx
  implements jox
{
  stx(stw paramstw) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp. result: " + paramString + ", code: " + paramInt);
    }
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
            QLog.i("OfflinePluginQQ", 2, "-->offline:checkUp loaded err:" + paramString);
          }
          paramString = null;
        }
      }
      localObject = this.this$0.mCheckupHandler.obtainMessage();
      ((Message)localObject).arg1 = 3;
      ((Message)localObject).obj = paramString;
      this.this$0.mCheckupHandler.sendMessage((Message)localObject);
    }
    while (paramInt != -1) {
      return;
    }
    paramString = this.this$0.mCheckupHandler.obtainMessage();
    paramString.arg1 = 2;
    this.this$0.mCheckupHandler.sendMessage(paramString);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stx
 * JD-Core Version:    0.7.0.1
 */