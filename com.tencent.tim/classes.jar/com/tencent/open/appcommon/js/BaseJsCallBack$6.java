package com.tencent.open.appcommon.js;

import android.os.Bundle;
import avgx;
import cooperation.qappcenter.remote.SendMsg;

class BaseJsCallBack$6
  implements Runnable
{
  BaseJsCallBack$6(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.abK.equals("1")) {
      bool = true;
    }
    if (BaseJsCallBack.access$000(this.this$0) != null)
    {
      SendMsg localSendMsg = new SendMsg("changeLoadingTip");
      localSendMsg.extraData.putBoolean("showLoadingView", bool);
      BaseJsCallBack.access$000(this.this$0).a(localSendMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack.6
 * JD-Core Version:    0.7.0.1
 */