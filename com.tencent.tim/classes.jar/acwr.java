import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acwr
  extends acuk
{
  public acwr(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acP()
  {
    String str1 = this.app.getCurrentUin();
    String str2 = this.app.getCurrentNickname();
    String str3 = avpq.getQUA3();
    avqq.a(this.context, str1, null, 0, str2, str3);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acP();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneRedpocketShareAction", 1, "doAction error: " + localException.getMessage());
      Ge("QzoneRedpocketShareAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwr
 * JD-Core Version:    0.7.0.1
 */