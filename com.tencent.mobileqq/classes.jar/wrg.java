import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class wrg
{
  public static wrg a;
  
  public static wrg a()
  {
    if (a == null) {
      a = new wrg();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), nkl.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(wri paramwri, wrj paramwrj)
  {
    byte[] arrayOfByte = paramwri.a();
    String str = paramwri.a();
    long l = System.currentTimeMillis();
    a(paramwri.a(), arrayOfByte, new wrh(this, l, paramwri, str, paramwrj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrg
 * JD-Core Version:    0.7.0.1
 */