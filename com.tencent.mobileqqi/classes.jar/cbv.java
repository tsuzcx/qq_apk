import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class cbv
  extends MessageObserver
{
  public cbv(ChatHistory paramChatHistory) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (!paramBoolean1)
    {
      int i = 1;
      if (paramBoolean2) {
        i = 7;
      }
      paramString = this.a.a.obtainMessage(i);
      this.a.a(paramString);
      return;
    }
    this.a.b.a().c();
    paramString = this.a.a.obtainMessage(0);
    this.a.a(paramString);
  }
  
  protected void a_(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(1);
      this.a.a(localMessage);
      return;
    }
    this.a.b.a().c();
    Message localMessage = this.a.a.obtainMessage(0);
    this.a.a(localMessage);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.a.m();
    if (!paramBoolean)
    {
      Message localMessage = this.a.a.obtainMessage(5);
      this.a.a(localMessage);
    }
  }
  
  protected void b_(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(1);
      this.a.a(localMessage);
      return;
    }
    this.a.b.a().c();
    Message localMessage = this.a.a.obtainMessage(0);
    this.a.a(localMessage);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(3);
      this.a.a(localMessage);
      return;
    }
    Message localMessage = this.a.a.obtainMessage(2);
    this.a.a(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbv
 * JD-Core Version:    0.7.0.1
 */