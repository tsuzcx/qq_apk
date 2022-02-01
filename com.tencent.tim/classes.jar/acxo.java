import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acxo
  extends acuk
{
  public acxo(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    boolean bool = false;
    try
    {
      if ("openPlayer".equals(this.attrs.get("action"))) {
        bool = okj.a().a(this.context, this.attrs);
      }
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("WeishiPublicAccountVideoAction", 1, "doAction error: " + localException.getMessage());
      Ge("WeishiPublicAccountVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxo
 * JD-Core Version:    0.7.0.1
 */