import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class acpa
  extends aquy
{
  public acpa(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if ((paramaquz.errCode == 0) && (this.a.a.app != null))
    {
      str = paramaquz.getParams().getString("path");
      if ((this.a.a.app != null) && (!TextUtils.isEmpty(str)))
      {
        if (!kdm.Yp.equals(str)) {
          break label142;
        }
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", paramaquz.lastModifiedTime).commit();
        ((kec)this.a.a.app.getBusinessHandler(88)).aBJ();
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "download report json success.");
        }
      }
    }
    label142:
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (!kdm.Yq.equals(str));
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", paramaquz.lastModifiedTime).commit();
      } while (!QLog.isColorLevel());
      QLog.i("Ecshop", 2, "download behaviors json success.");
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acpa
 * JD-Core Version:    0.7.0.1
 */