import com.tencent.TMG.sdk.AVVideoCtrl.SwitchCameraCompleteCallback;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.9;
import org.json.JSONObject;

public class abny
  extends AVVideoCtrl.SwitchCameraCompleteCallback
{
  public abny(CmGameAvHandler.9 param9) {}
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", i);
        localJSONObject.put("cameraPos", paramInt1);
        localJSONObject.put("errCode", paramInt2);
        abmt.a().callbackFromRequest(this.a.Od, 0, "cs.audioRoom_camera_switch.local", localJSONObject.toString());
        return;
      }
      catch (Exception localException) {}
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abny
 * JD-Core Version:    0.7.0.1
 */