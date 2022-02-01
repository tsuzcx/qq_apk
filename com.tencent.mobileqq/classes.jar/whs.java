import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class whs
{
  public static whs a;
  
  public static whs a()
  {
    if (a == null) {
      a = new whs();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), nta.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(whu paramwhu, whv paramwhv)
  {
    byte[] arrayOfByte = paramwhu.a();
    String str = paramwhu.a();
    long l = System.currentTimeMillis();
    a(paramwhu.a(), arrayOfByte, new wht(this, l, paramwhu, str, paramwhv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whs
 * JD-Core Version:    0.7.0.1
 */