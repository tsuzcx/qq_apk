import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;

public class usw
  extends ackx
{
  public usw(Conversation paramConversation) {}
  
  protected void AC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "onRegPrxyUpdateLoginDevStatus int iState = ", Integer.valueOf(paramInt) });
    }
    if (paramInt == 1)
    {
      this.this$0.a.gm(27, 2);
      this.this$0.a.d(-1, null);
      return;
    }
    this.this$0.a.cus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usw
 * JD-Core Version:    0.7.0.1
 */