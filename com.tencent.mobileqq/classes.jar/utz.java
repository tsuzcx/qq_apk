import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class utz
{
  public static utz a;
  
  public static utz a()
  {
    if (a == null) {
      a = new utz();
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
  
  public void a(uub paramuub, uuc paramuuc)
  {
    byte[] arrayOfByte = paramuub.a();
    String str = paramuub.a();
    long l = System.currentTimeMillis();
    a(paramuub.a(), arrayOfByte, new uua(this, l, paramuub, str, paramuuc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     utz
 * JD-Core Version:    0.7.0.1
 */