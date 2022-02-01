import com.tencent.av.share.AVSchema;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.qphone.base.util.QLog;

public class iuz
  implements ChatActivityUtils.c
{
  public iuz(AVSchema paramAVSchema, long paramLong) {}
  
  public void aqM()
  {
    QLog.w(this.this$0.TAG, 1, "joinVideoChat.onBeforeStartActivity, isDetached[" + this.this$0.isDetached() + "], seq[" + this.kQ + "]");
  }
  
  public void aqN()
  {
    QLog.w(this.this$0.TAG, 1, "joinVideoChat.onAfterStartActivity, isDetached[" + this.this$0.isDetached() + "], seq[" + this.kQ + "]");
    this.this$0.finish();
  }
  
  public void onCancel()
  {
    QLog.w(this.this$0.TAG, 1, "joinVideoChat.onCancel, isDetached[" + this.this$0.isDetached() + "], seq[" + this.kQ + "]");
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iuz
 * JD-Core Version:    0.7.0.1
 */