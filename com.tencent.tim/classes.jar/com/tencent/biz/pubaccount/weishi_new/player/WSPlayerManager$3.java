package com.tencent.biz.pubaccount.weishi_new.player;

import olh;
import ooz;

class WSPlayerManager$3
  implements Runnable
{
  WSPlayerManager$3(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if (WSPlayerManager.a(this.this$0) != null)
    {
      WSPlayerManager.a(this.this$0).start();
      ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] subThread videoPlayer.start!");
      if ((!WSPlayerManager.a(this.this$0)) && (WSPlayerManager.a(this.this$0) != null))
      {
        WSPlayerManager.a(this.this$0).pause();
        ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] activity become onPause after videoPlayer.start(), so we need to pause it!");
      }
      WSPlayerManager.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.3
 * JD-Core Version:    0.7.0.1
 */