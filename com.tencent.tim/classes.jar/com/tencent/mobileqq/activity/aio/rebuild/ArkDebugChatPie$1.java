package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.ArkDebugger;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import xwl;
import xwm;

public class ArkDebugChatPie$1
  implements Runnable
{
  public ArkDebugChatPie$1(xwl paramxwl) {}
  
  public void run()
  {
    ArkDebugger.Create();
    ArkDebugger.SetCallback(new xwm(this));
    xwl.a(this.this$0, ArkAppCenter.sO());
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.sO());
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1
 * JD-Core Version:    0.7.0.1
 */