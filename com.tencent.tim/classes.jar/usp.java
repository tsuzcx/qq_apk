import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.35.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class usp
  extends acdv
{
  public usp(Conversation paramConversation) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.this$0.n(8, paramString, 3000);
    }
  }
  
  protected void V(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onQuitDiscussion");
      }
      this.this$0.n(8, paramString, 3000);
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    this.this$0.n(8, Long.toString(paramLong), 3000);
  }
  
  protected void bMN()
  {
    this.this$0.n(9, null, -2147483648);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "conversation onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.this$0.runOnUiThread(new Conversation.35.1(this, paramString));
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.this$0.fI(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usp
 * JD-Core Version:    0.7.0.1
 */