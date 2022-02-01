package com.tencent.biz.pubaccount.weishi_new.player;

import olj;
import ooz;

public class WSVideoPluginInstall$2
  implements Runnable
{
  public WSVideoPluginInstall$2(olj paramolj) {}
  
  public void run()
  {
    ooz.bY("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread.");
    if (!olj.access$100()) {
      olj.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */