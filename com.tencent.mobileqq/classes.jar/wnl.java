import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class wnl
{
  public static wnl a;
  
  public static wnl a()
  {
    if (a == null) {
      a = new wnl();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), niq.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(wnn paramwnn, wno paramwno)
  {
    byte[] arrayOfByte = paramwnn.a();
    String str = paramwnn.a();
    long l = System.currentTimeMillis();
    a(paramwnn.a(), arrayOfByte, new wnm(this, l, paramwnn, str, paramwno));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnl
 * JD-Core Version:    0.7.0.1
 */