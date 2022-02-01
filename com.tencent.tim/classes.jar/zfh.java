import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.3.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class zfh
  implements achs.a
{
  public zfh(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment) {}
  
  public void K(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatHistoryC2CDateFragment.access$100(), 2, "onGetRoamMsgForDate " + paramBoolean);
    }
    this.this$0.bpm();
    if (paramBoolean)
    {
      ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CDateFragment.3.1(this));
      return;
    }
    this.this$0.showTipsDialog(this.this$0.getString(2131691418));
  }
  
  public void a(achs.a parama) {}
  
  public void k(int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfh
 * JD-Core Version:    0.7.0.1
 */