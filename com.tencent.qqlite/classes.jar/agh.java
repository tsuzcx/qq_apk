import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qphone.base.util.QLog;

public class agh
  extends MessageObserver
{
  public agh(Conversation paramConversation) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.a.b(new agk(this));
    }
  }
  
  protected void b()
  {
    TroopAssistantManager.a().c(this.a.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void c()
  {
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.a.b != 1000L) {
      this.a.b = 1000L;
    }
    this.a.b(new agi(this, paramBoolean));
  }
  
  public void c(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
  
  protected void d(boolean paramBoolean)
  {
    this.a.b(new agj(this, paramBoolean));
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    paramString = RecentDataListManager.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agh
 * JD-Core Version:    0.7.0.1
 */