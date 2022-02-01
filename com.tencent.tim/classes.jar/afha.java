import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class afha
  implements axfn.a
{
  public afha(CameraEmoSingleSend paramCameraEmoSingleSend, axfn paramaxfn, long paramLong) {}
  
  public void HS(String paramString)
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateSuccess, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.this$0).emoId) });
    CameraEmoSingleSend.a(this.this$0, true, paramString);
    this.a.eJm();
    paramString = new HashMap();
    paramString.put("sucFlag", "1");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "CamEmoCreateGIF", true, System.currentTimeMillis() - this.Xu, 0L, paramString, null);
  }
  
  public void cZr()
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateFail, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.this$0).emoId) });
    CameraEmoSingleSend.a(this.this$0, false, null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sucFlag", "0");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "CamEmoCreateGIF", false, System.currentTimeMillis() - this.Xu, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afha
 * JD-Core Version:    0.7.0.1
 */