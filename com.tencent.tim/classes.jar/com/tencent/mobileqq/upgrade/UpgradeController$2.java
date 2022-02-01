package com.tencent.mobileqq.upgrade;

import accy;
import android.content.Intent;
import aqap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$2
  implements Runnable
{
  public UpgradeController$2(aqap paramaqap, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((aqap.a(this.this$0) == null) || (aqap.a(this.this$0).b == null) || (aqap.a(this.this$0).b.dialog == null)) {
      QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }
    Intent localIntent;
    do
    {
      return;
      Object localObject = aqap.a(this.this$0).b.dialog;
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((NewUpgradeConfig.a)localObject).title);
      localIntent.putExtra("StrUpgradeDesc", ((NewUpgradeConfig.a)localObject).content);
      if (this.cTs) {
        localIntent.putExtra("strDesc", ((NewUpgradeConfig.a)localObject).desc);
      }
      localIntent.putExtra("lBtnText", ((NewUpgradeConfig.a)localObject).cse);
      localIntent.putExtra("rBtnText", ((NewUpgradeConfig.a)localObject).csf);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", aqap.a(this.this$0).a.iUpgradeType);
      localIntent.putExtra("iTipsType", aqap.a(this.this$0).a.iTipsType);
      localIntent.putExtra("strConfirmBtnText", aqap.a(this.this$0).a.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", aqap.a(this.this$0).a.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", aqap.a(this.this$0).a.iUpgradeSdkId);
      if ((aqap.a(this.this$0).b != null) && (aqap.a(this.this$0).b.dialog != null)) {
        localIntent.putExtra("rate", aqap.a(this.this$0).b.dialog.aCm);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = accy.ay(this.val$app.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.val$app.W = localIntent;
        return;
      }
      this.val$app.W = null;
    } while (BaseActivity.sTopActivity == null);
    BaseActivity.sTopActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.2
 * JD-Core Version:    0.7.0.1
 */