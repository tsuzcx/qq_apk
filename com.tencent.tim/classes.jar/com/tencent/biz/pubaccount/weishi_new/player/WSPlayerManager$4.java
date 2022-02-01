package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ola;
import ole;
import olf;

class WSPlayerManager$4
  implements Runnable
{
  WSPlayerManager$4(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).mVideoView != null))
    {
      if (WSPlayerManager.a(this.this$0).b != null) {
        WSPlayerManager.a(this.this$0).b.d(WSPlayerManager.a(this.this$0));
      }
      if (WSPlayerManager.a(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((olf)localIterator.next()).d(WSPlayerManager.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.4
 * JD-Core Version:    0.7.0.1
 */