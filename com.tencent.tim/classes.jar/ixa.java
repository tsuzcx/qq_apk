import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ixa
{
  public static String TAG = "AIOTopRightButtonConfig";
  private static ixa a;
  private int avl = -1;
  private Object mLock = new Object();
  
  public static ixa a()
  {
    try
    {
      if (a == null) {
        a = new ixa();
      }
      return a;
    }
    finally {}
  }
  
  public void bj(String paramString)
  {
    synchronized (this.mLock)
    {
      this.avl = 1;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("AVFromRightCornerEnable")) && (!paramString.getBoolean("AVFromRightCornerEnable"))) {
        this.avl = 0;
      }
      return;
      paramString = finally;
      throw paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.w(TAG, 1, "updateConfig, JSONException", paramString);
      }
    }
  }
  
  public boolean cD(String paramString)
  {
    if (this.avl == -1) {
      bj(igl.b(192).content);
    }
    return this.avl == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixa
 * JD-Core Version:    0.7.0.1
 */