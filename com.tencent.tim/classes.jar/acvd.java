import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acvd
  extends acuk
{
  public acvd(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      i = Integer.parseInt(this.ctj);
      switch (i)
      {
      default: 
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("QQFavAction", 1, "doAction error NumberFormatException: " + localNumberFormatException.getMessage());
        int i = -1;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131691039));
      boolean bool = avja.a((Activity)this.context, this.app.getAccount(), localIntent, -1, false);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQFavAction", 1, "doAction error: " + localException.getMessage());
      Ge("QQFavAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvd
 * JD-Core Version:    0.7.0.1
 */