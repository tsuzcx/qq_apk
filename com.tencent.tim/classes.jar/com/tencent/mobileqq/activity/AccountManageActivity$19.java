package com.tencent.mobileqq.activity;

import acxu;
import aiza;
import aqgx;
import arod;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class AccountManageActivity$19
  implements Runnable
{
  AccountManageActivity$19(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    arod.a().WF(this.val$uin);
    if (this.aQY)
    {
      ProxyManager localProxyManager = this.this$0.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.transSaveToDatabase();
        acxu.f(this.this$0.app, this.val$uin, true);
        new aiza().Mf(this.val$uin);
        aqgx.a().h(this.this$0.app.getApp(), this.val$uin, false);
      }
    }
    this.this$0.runOnUiThread(new AccountManageActivity.19.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.19
 * JD-Core Version:    0.7.0.1
 */