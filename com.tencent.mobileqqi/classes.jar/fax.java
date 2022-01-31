import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.service.message.MessageCache;

public class fax
  extends MessageObserver
{
  public fax(DataLineHandler paramDataLineHandler) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      if (this.a.b())
      {
        this.a.a(true);
        DataLineHandler.a(this.a, MessageCache.a());
        this.a.a.a().f();
      }
    }
    while (paramInt1 != 0) {
      return;
    }
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fax
 * JD-Core Version:    0.7.0.1
 */