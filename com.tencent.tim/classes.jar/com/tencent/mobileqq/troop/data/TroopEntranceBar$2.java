package com.tencent.mobileqq.troop.data;

import acfp;
import android.content.Context;
import android.content.Intent;
import anot;
import apbk;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import ocp;

public class TroopEntranceBar$2
  implements Runnable
{
  public TroopEntranceBar$2(apbk paramapbk) {}
  
  public void run()
  {
    Object localObject2 = "";
    Object localObject1 = "";
    Object localObject4 = ocp.a(this.this$0.app, this.this$0.sessionInfo.aTl);
    if (localObject4 != null)
    {
      localObject3 = ((AccountDetail)localObject4).uin;
      localObject4 = ((AccountDetail)localObject4).name;
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (((String)localObject4).endsWith(acfp.m(2131715661)))
        {
          localObject1 = ((String)localObject4).substring(0, ((String)localObject4).length() - 3);
          localObject2 = localObject3;
        }
      }
    }
    localObject1 = String.format("https://buluo.qq.com/mobile/relativegroup.html?from=%s&scode=%s&keyword=%s&channel=1&_wv=1027&_bid=128", new Object[] { "qun_aio", this.this$0.sessionInfo.aTl, localObject1 });
    Object localObject3 = new Intent(this.this$0.context, QQBrowserActivity.class);
    ((Intent)localObject3).putExtra("url", (String)localObject1);
    this.this$0.context.startActivity((Intent)localObject3);
    anot.a(this.this$0.app, "dc00899", "Grp_tribe", "", "clk_tribechat_aio", "exp_tribechat_aio", 0, 0, this.this$0.sessionInfo.aTl, (String)localObject2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.2
 * JD-Core Version:    0.7.0.1
 */