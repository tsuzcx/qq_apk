import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acut
  extends acuk
{
  public acut(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean aco()
  {
    Object localObject = toBase64Decode((String)this.attrs.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.context, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.context.startActivity((Intent)localObject);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = aco();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("OdAddFriendAction", 1, "doAction error: " + localException.getMessage());
      Ge("OdAddFriendAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acut
 * JD-Core Version:    0.7.0.1
 */