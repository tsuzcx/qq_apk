import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acty
  extends acuk
{
  public acty(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acj()
  {
    String str1 = (String)this.attrs.get("roomcode");
    String str2 = (String)this.attrs.get("fromid");
    String str3 = (String)this.attrs.get("isgroupcode");
    String str4 = (String)this.attrs.get("backtype");
    String str5 = (String)this.attrs.get("open_type");
    String str6 = (String)this.attrs.get("extra");
    aicu localaicu = (aicu)this.app.getManager(236);
    try
    {
      i = Integer.parseInt(str3);
      QLog.i("GroupVideoAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localaicu.a(this.context, str1, this.app.getCurrentUin(), i, "download", str2, str4, str5, str6);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  private boolean acl()
  {
    Object localObject = (String)this.attrs.get("fromid");
    localObject = (aicu)this.app.getManager(236);
    QLog.i("GroupVideoAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((aicu)localObject).b(null, 10L);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      if (this.ctj.equals("openroom")) {
        return acj();
      }
      if (this.ctj.equals("preload"))
      {
        boolean bool = acl();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("GroupVideoAction", 1, "doAction error: " + localException.getMessage());
      Ge("GroupVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acty
 * JD-Core Version:    0.7.0.1
 */