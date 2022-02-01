import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;

public class acua
  extends acuk
{
  public acua(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = kL(getAttribute("gc"));
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("HomeWorkTroopPublishAction", 1, "doAction error: " + localException.getMessage());
      Ge("HomeWorkTroopPublishAction");
    }
    return false;
  }
  
  protected boolean kL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.context instanceof Activity))
    {
      PublishHomeWorkFragment.b((Activity)this.context, null, paramString);
      ((Activity)this.context).overridePendingTransition(2130772367, 2130772002);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acua
 * JD-Core Version:    0.7.0.1
 */