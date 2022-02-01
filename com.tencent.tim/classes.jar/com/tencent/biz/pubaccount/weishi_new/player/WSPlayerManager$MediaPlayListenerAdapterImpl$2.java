package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ola;
import ole;
import olf;

class WSPlayerManager$MediaPlayListenerAdapterImpl$2
  implements Runnable
{
  public void run()
  {
    if ((WSPlayerManager.a(this.b.this$0) != null) && (WSPlayerManager.a(this.b.this$0).b != null)) {
      WSPlayerManager.a(this.b.this$0).b.j(WSPlayerManager.a(this.b.this$0));
    }
    if (WSPlayerManager.a(this.b.this$0) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.b.this$0).iterator();
      while (localIterator.hasNext()) {
        ((olf)localIterator.next()).n(WSPlayerManager.a(this.b.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2
 * JD-Core Version:    0.7.0.1
 */