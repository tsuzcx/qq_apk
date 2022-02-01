import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import org.json.JSONException;
import org.json.JSONObject;

public class jrn
  implements jox
{
  public jrn(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.val$callback)) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.this$0.callJs(this.val$callback, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrn
 * JD-Core Version:    0.7.0.1
 */