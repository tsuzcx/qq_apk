import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.QLog;

public class afhb
  implements afgw.a
{
  public afhb(CameraEmoSingleSend paramCameraEmoSingleSend) {}
  
  public void c(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    boolean bool = true;
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onAddEmoFinish, result:", Integer.valueOf(paramInt), " emoId:", Integer.valueOf(paramCameraEmotionData.emoId), " originalId:", Integer.valueOf(CameraEmoSingleSend.a(this.this$0).emoId) });
    if (paramInt == 0) {}
    for (;;)
    {
      CameraEmoSingleSend.a(this.this$0, bool, paramInt);
      this.this$0.ew(String.valueOf(paramInt), 2);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhb
 * JD-Core Version:    0.7.0.1
 */