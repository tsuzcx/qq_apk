package com.tencent.qqmini.proxyimpl;

import aeay;
import aqju;
import asuh;
import asui;
import asuk;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class ColorNotePlugin$1
  implements Runnable
{
  public ColorNotePlugin$1(asuh paramasuh, aeay paramaeay, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    aqju localaqju = new aqju(asuh.a(this.this$0).getAttachedActivity(), 2131756467);
    localaqju.setContentView(2131559580);
    localaqju.setMessage("是否将" + asuh.a(this.this$0).name + "添加到彩签？");
    localaqju.setPositiveButton("确定", new asui(this));
    localaqju.setNegativeButton("取消", new asuk(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */