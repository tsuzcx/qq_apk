package com.tencent.mobileqq.activity.aio.rebuild;

import acfp;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;
import xwl;
import xwm;

public class ArkDebugChatPie$1$1$3
  implements Runnable
{
  public ArkDebugChatPie$1$1$3(xwm paramxwm, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.val$appId, this.val$path);
    QQToast.a(this.a.a.this$0.mContext, acfp.m(2131702804), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */