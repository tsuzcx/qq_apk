import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class vsx
{
  public static vsx a;
  
  public static vsx a()
  {
    if (a == null) {
      a = new vsx();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), nma.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(vsz paramvsz, vta paramvta)
  {
    byte[] arrayOfByte = paramvsz.a();
    String str = paramvsz.a();
    long l = System.currentTimeMillis();
    a(paramvsz.a(), arrayOfByte, new vsy(this, l, paramvsz, str, paramvta));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsx
 * JD-Core Version:    0.7.0.1
 */