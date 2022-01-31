import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class upq
{
  public static upq a;
  
  public static upq a()
  {
    if (a == null) {
      a = new upq();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), mzx.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ups paramups, upt paramupt)
  {
    byte[] arrayOfByte = paramups.a();
    String str = paramups.a();
    long l = System.currentTimeMillis();
    a(paramups.a(), arrayOfByte, new upr(this, l, paramups, str, paramupt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upq
 * JD-Core Version:    0.7.0.1
 */