import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.qphone.base.util.QLog;

public class acww
  extends acuk
{
  public acww(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean acR()
  {
    SmallVideoFragment.launch(this.context, this.source);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acR();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("IdentifierWebJumpAction", 1, "doAction error: " + localException.getMessage());
      Ge("IdentifierWebJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acww
 * JD-Core Version:    0.7.0.1
 */