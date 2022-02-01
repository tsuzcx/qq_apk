import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aiit
  implements skj.a
{
  aiit(aiis paramaiis, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.a.isDestroy) {}
    do
    {
      return;
      paramBundle = String.format("{\"result\":%d, \"errMsg\":\"%s\", \"uin\":\"%s\"}", new Object[] { Integer.valueOf(paramBundle.getInt("result", -1)), paramBundle.getString("errMsg"), paramBundle.getString("retUin") });
      this.a.callJs(this.val$callback, new String[] { paramBundle });
    } while (!QLog.isColorLevel());
    QLog.e("ConnectApiPlugin", 2, new Object[] { "handleJsRequest callback:", paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiit
 * JD-Core Version:    0.7.0.1
 */