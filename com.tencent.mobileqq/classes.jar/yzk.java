import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.service.message.MessageCache;

public class yzk
  extends MessageObserver
{
  public yzk(DataLineHandler paramDataLineHandler) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.a()))
    {
      this.a.a(true);
      DataLineHandler.a(this.a, MessageCache.a());
      this.a.b.a().a(0).b();
    }
    this.a.a.a(this.a);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.b()))
    {
      this.a.b(true);
      DataLineHandler.b(this.a, MessageCache.a());
      this.a.b.a().a(1).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yzk
 * JD-Core Version:    0.7.0.1
 */