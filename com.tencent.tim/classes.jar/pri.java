import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class pri
{
  public static pri a;
  
  public static pri a()
  {
    if (a == null) {
      a = new pri();
    }
    return a;
  }
  
  private void b(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.c();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), jnl.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(prk paramprk, prl paramprl)
  {
    byte[] arrayOfByte = paramprk.encode();
    String str = paramprk.mg();
    long l = System.currentTimeMillis();
    b(paramprk.mg(), arrayOfByte, new prj(this, l, paramprk, str, paramprl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pri
 * JD-Core Version:    0.7.0.1
 */