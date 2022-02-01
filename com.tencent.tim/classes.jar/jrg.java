import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;

public class jrg
  implements skj.a
{
  public jrg(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("state");
      this.this$0.callJs(this.val$callback, new String[] { i + "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrg
 * JD-Core Version:    0.7.0.1
 */