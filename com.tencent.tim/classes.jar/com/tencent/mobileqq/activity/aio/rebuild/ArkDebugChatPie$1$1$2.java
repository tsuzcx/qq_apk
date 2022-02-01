package com.tencent.mobileqq.activity.aio.rebuild;

import acfp;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;
import xwl;
import xwm;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(xwm paramxwm, int paramInt) {}
  
  public void run()
  {
    xwl.a(this.a.a.this$0);
    String str = "";
    if (this.val$errorCode == 1) {
      str = acfp.m(2131702800);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.a(this.a.a.this$0.mContext, String.format(acfp.m(2131702808), new Object[] { str }), 0).show();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */