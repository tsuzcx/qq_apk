import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.14;
import com.tencent.qphone.base.util.QLog;

public class aouw
  implements pog.e
{
  public aouw(TroopBarPublishActivity.14 param14) {}
  
  public void g(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("tribe_publish_TroopBarPublishActivity", 2, "compositeVideo: errorCode = " + paramInt);
      }
      this.a.this$0.bh(null, this.a.aqB);
      return;
    }
    this.a.this$0.a.width = this.a.this$0.k.videoWidth;
    this.a.this$0.a.height = this.a.this$0.k.videoHeight;
    this.a.this$0.a.duration = ((int)this.a.this$0.k.videoDuration);
    this.a.this$0.bh(paramString2, this.a.aqB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouw
 * JD-Core Version:    0.7.0.1
 */