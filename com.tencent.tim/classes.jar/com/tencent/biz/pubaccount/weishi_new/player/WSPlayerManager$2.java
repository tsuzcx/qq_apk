package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import ole;
import olh;
import ooz;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, ole paramole, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.f.c = WSPlayerManager.b(this.this$0);
    if ((this.f.c != null) && (WSPlayerManager.a(this.this$0) != null))
    {
      this.f.c.setTag(this.f.a);
      WSPlayerManager.a(this.this$0).put(this.f.c, WSPlayerManager.a(this.this$0));
      WSPlayerManager.a(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    ooz.e("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + this.f.c + ", mUIHandler:" + WSPlayerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */