import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vnb
  implements View.OnClickListener
{
  public vnb(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.finish();
      continue;
      vnj.bv(this.this$0);
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
      Object localObject1 = (altq)this.this$0.app.getManager(36);
      Object localObject2 = ((altq)localObject1).getAppInfoByPath("101000.101001");
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
        anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
      }
      ((altq)localObject1).OS("101000.101001");
      continue;
      localObject1 = (String)paramView.getTag(-1);
      localObject2 = (String)paramView.getTag(-2);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PublicAccountListActivity", 2, "onClick - uin = " + (String)localObject1 + ", name = " + (String)localObject2);
        }
      }
      else
      {
        jqs.a(this.this$0.app, this.this$0, (String)localObject2, (String)localObject1, "IvrEnterpriseDetailEngineFalse");
        continue;
        vnj.x(this.this$0, (String)this.this$0.rS.getTag());
        kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
        continue;
        vnj.x(this.this$0, (String)this.this$0.rS.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnb
 * JD-Core Version:    0.7.0.1
 */