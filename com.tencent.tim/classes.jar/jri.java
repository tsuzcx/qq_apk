import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;

public class jri
  implements skj.a
{
  public jri(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("music");
      this.this$0.callJs(this.val$callback, new String[] { paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jri
 * JD-Core Version:    0.7.0.1
 */