import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class zqn
  extends DownloadListener
{
  public zqn(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a == 0) && (EcShopFirstRunMsgConfigs.a(this.a).b != null))
    {
      str = paramDownloadTask.a().getString("path");
      if ((EcShopFirstRunMsgConfigs.b(this.a).b != null) && (!TextUtils.isEmpty(str)))
      {
        if (!EcShopAssistantManager.e.equals(str)) {
          break label142;
        }
        EcShopFirstRunMsgConfigs.c(this.a).b.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", paramDownloadTask.i).commit();
        ((EcshopReportHandler)EcShopFirstRunMsgConfigs.d(this.a).b.a(88)).b();
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
        } while (!EcShopAssistantManager.f.equals(str));
        EcShopFirstRunMsgConfigs.e(this.a).b.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", paramDownloadTask.i).commit();
      } while (!QLog.isColorLevel());
      QLog.i("Ecshop", 2, "download behaviors json success.");
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqn
 * JD-Core Version:    0.7.0.1
 */