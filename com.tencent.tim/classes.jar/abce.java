import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abce
  extends aogh.a
{
  abce(abcb paramabcb, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
    throws RemoteException
  {
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: " + paramString + "," + paramInt);
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 2);
      paramString.put("errorCode", paramInt);
      this.a.callJs(this.bfl, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: ", paramString);
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
    throws RemoteException
  {
    int i = (int)(100.0F * (float)paramLong1 / (float)paramLong2);
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 1);
      paramString.put("progress", i);
      this.a.callJs(this.bfl, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abce
 * JD-Core Version:    0.7.0.1
 */