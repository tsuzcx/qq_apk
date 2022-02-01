import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class zdp
  implements afhv.a
{
  zdp(zdf paramzdf, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + zdf.b(this.this$0));
    }
    if (!zdf.b(this.this$0))
    {
      zdf.b(this.this$0, paramList);
      zdf.a(this.this$0, this.cdb, paramFloat);
    }
  }
  
  public void hg(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + zdf.b(this.this$0));
    }
    if (!zdf.b(this.this$0))
    {
      zdf.a(this.this$0).removeMessages(11);
      zdf.a(this.this$0, this.cdb, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdp
 * JD-Core Version:    0.7.0.1
 */