package com.tencent.mobileqq.activity;

import acxu;
import aiza;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class AssociatedAccountManageActivity$7
  implements Runnable
{
  AssociatedAccountManageActivity$7(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
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
    this.this$0.runOnUiThread(new AssociatedAccountManageActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7
 * JD-Core Version:    0.7.0.1
 */