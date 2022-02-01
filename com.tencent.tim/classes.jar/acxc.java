import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acxc
  extends acuk
{
  public acxc(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acS()
  {
    try
    {
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      if (TextUtils.isEmpty(aetq.a().tV())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = aetq.a().tV())
      {
        this.context.startActivity(localIntent.putExtra("url", str));
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acS();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TeamWorkListAction", 1, "doAction error: " + localException.getMessage());
      Ge("TeamWorkListAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxc
 * JD-Core Version:    0.7.0.1
 */