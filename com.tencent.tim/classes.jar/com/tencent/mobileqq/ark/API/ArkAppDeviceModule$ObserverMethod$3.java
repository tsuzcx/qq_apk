package com.tencent.mobileqq.ark.API;

import admn;
import admn.c;
import admq;
import admr;
import adms;
import adnq.c;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import aqju;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppDeviceModule$ObserverMethod$3
  implements Runnable
{
  public ArkAppDeviceModule$ObserverMethod$3(admn.c paramc, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    aqju localaqju = new aqju(BaseActivity.sTopActivity, 2131756467);
    localaqju.setContentView(2131559128);
    localaqju.setTitle(BaseActivity.sTopActivity.getString(2131690465, new Object[] { this.buD }));
    ((ImageView)localaqju.findViewById(2131365822)).setImageDrawable(BaseActivity.sTopActivity.getResources().getDrawable(2130838753));
    ((TextView)localaqju.findViewById(2131365824)).setText(this.buD);
    ((TextView)localaqju.findViewById(2131365863)).setText(BaseActivity.sTopActivity.getString(2131690471));
    localaqju.setCanceledOnTouchOutside(false);
    ArkAppCacheMgr.getAppIcon(this.b.this$0.mAppName, new admq(this, localaqju));
    localaqju.setNegativeButton(2131721908, new admr(this, localaqju));
    localaqju.setPositiveButton(2131721897, new adms(this, localaqju));
    try
    {
      localaqju.show();
      label165:
      if (adnq.c.i(this.buD, "ark_authority_api_location", this.val$uin) == 0) {
        adnq.c.p(this.buD, "ark_authority_api_location", this.val$uin, 2);
      }
      return;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3
 * JD-Core Version:    0.7.0.1
 */