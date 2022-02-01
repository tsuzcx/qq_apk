package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.app.BaseActivity;
import stj;

class AIOImageProviderService$6
  implements Runnable
{
  AIOImageProviderService$6(AIOImageProviderService paramAIOImageProviderService, boolean paramBoolean, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    if (this.bjn)
    {
      stj.b(this.j.app, this.Ub, this.aWn, this.val$account, this.val$content);
      return;
    }
    stj.a(this.j, this.aWn, this.Ub, this.val$account, stj.es(this.ber), this.val$account);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.6
 * JD-Core Version:    0.7.0.1
 */