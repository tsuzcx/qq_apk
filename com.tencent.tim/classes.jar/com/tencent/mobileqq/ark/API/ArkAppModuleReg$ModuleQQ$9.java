package com.tencent.mobileqq.ark.API;

import adnq.c;
import adoe;
import adof;
import adog;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import aqju;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppModuleReg$ModuleQQ$9
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$9(adnq.c paramc, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    aqju localaqju = new aqju(BaseActivity.sTopActivity, 2131756467);
    localaqju.setContentView(2131559128);
    localaqju.setTitle(BaseActivity.sTopActivity.getString(2131690465, new Object[] { this.buD }));
    ((ImageView)localaqju.findViewById(2131365822)).setImageDrawable(BaseActivity.sTopActivity.getResources().getDrawable(2130838753));
    ((TextView)localaqju.findViewById(2131365824)).setText(this.buD);
    ((TextView)localaqju.findViewById(2131365863)).setText(BaseActivity.sTopActivity.getString(2131690477));
    localaqju.setCanceledOnTouchOutside(false);
    ArkAppCacheMgr.getAppIcon(this.this$0.mAppName, new adoe(this, localaqju));
    localaqju.setNegativeButton(2131721908, new adof(this, localaqju));
    localaqju.setPositiveButton(2131721897, new adog(this, localaqju));
    try
    {
      localaqju.show();
      label162:
      if (adnq.c.i(this.buD, "ark_authority_api_user_info", this.val$uin) == 0) {
        adnq.c.p(this.buD, "ark_authority_api_user_info", this.val$uin, 2);
      }
      return;
    }
    catch (Exception localException)
    {
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9
 * JD-Core Version:    0.7.0.1
 */