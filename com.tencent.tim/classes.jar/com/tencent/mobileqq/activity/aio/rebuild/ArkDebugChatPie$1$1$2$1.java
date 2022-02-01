package com.tencent.mobileqq.activity.aio.rebuild;

import acfp;
import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.widget.QQToast;
import xwl;
import xwm;

class ArkDebugChatPie$1$1$2$1
  implements Runnable
{
  ArkDebugChatPie$1$1$2$1(ArkDebugChatPie.1.1.2 param2) {}
  
  public void run()
  {
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.sO());
    QQToast.a(this.a.a.a.this$0.mContext, acfp.m(2131702801), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2.1
 * JD-Core Version:    0.7.0.1
 */