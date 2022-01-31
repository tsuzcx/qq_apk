import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.service.message.MessageCache;

public class crm
  extends MessageObserver
{
  public crm(DataLineHandler paramDataLineHandler) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.b()))
    {
      this.a.a(true);
      DataLineHandler.a(this.a, MessageCache.a());
      this.a.a.a().a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     crm
 * JD-Core Version:    0.7.0.1
 */