import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acuq
  extends acuk
{
  public acuq(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acn()
  {
    arhz localarhz = new arhz(this.context, 0, 2131558750, 17);
    localarhz.setMessage(this.context.getString(2131690520));
    localarhz.getWindow().setDimAmount(0.0F);
    localarhz.show();
    localarhz.setCanceledOnTouchOutside(true);
    String str1 = (String)this.attrs.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.attrs.get("meta");
    String str3 = (String)this.attrs.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.app.getManager(121);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new acur(this, localarhz, str3, str2, str1));
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acn();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("LightAppOpenAction", 1, "doAction error: " + localException.getMessage());
      Ge("LightAppOpenAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acuq
 * JD-Core Version:    0.7.0.1
 */