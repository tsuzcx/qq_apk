import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class kzq
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoSingleModeConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    if ((String)paramString.get("readinjoy_single_video_switch") != null) {
      awit.abC((String)paramString.get("readinjoy_single_video_switch"));
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    awit.abC(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzq
 * JD-Core Version:    0.7.0.1
 */