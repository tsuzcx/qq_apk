import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.39.1;
import com.tencent.mobileqq.activity.Conversation.39.2;
import com.tencent.mobileqq.activity.Conversation.39.3;
import com.tencent.mobileqq.activity.Conversation.39.4;
import com.tencent.mobileqq.activity.Conversation.39.5;
import com.tencent.mobileqq.activity.Conversation.39.6;
import com.tencent.mobileqq.app.QQAppInterface;

public class ust
  extends inh
{
  public ust(Conversation paramConversation) {}
  
  protected void aX(String paramString1, String paramString2)
  {
    super.aX(paramString1, paramString2);
    if (!this.this$0.mIsForeground) {
      return;
    }
    this.this$0.runOnUiThread(new Conversation.39.5(this));
  }
  
  protected void d(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = jll.cM(paramInt);
    this.this$0.n(8, Long.toString(paramLong1), paramInt);
    this.this$0.fK(paramLong1);
    this.this$0.runOnUiThread(new Conversation.39.1(this, paramLong1));
  }
  
  protected void e(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.this$0.app.getCurrentAccountUin()).longValue()) {
      this.this$0.runOnUiThread(new Conversation.39.2(this, paramLong1));
    }
  }
  
  protected void f(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.this$0.app.getCurrentAccountUin()).longValue()) {
      this.this$0.runOnUiThread(new Conversation.39.3(this, paramLong1));
    }
  }
  
  protected void i(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.n(8, paramString1, paramInt);
    this.this$0.runOnUiThread(new Conversation.39.4(this));
  }
  
  protected void i(boolean paramBoolean, String paramString) {}
  
  protected void jm(String paramString)
  {
    super.jm(paramString);
    this.this$0.runOnUiThread(new Conversation.39.6(this));
  }
  
  protected void t(int paramInt, long paramLong)
  {
    paramInt = jll.cM(paramInt);
    this.this$0.n(8, Long.toString(paramLong), paramInt);
  }
  
  protected void u(int paramInt, long paramLong)
  {
    paramInt = jll.cM(paramInt);
    this.this$0.n(8, Long.toString(paramLong), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ust
 * JD-Core Version:    0.7.0.1
 */