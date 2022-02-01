package com.tencent.biz.pubaccount.weishi_new.player;

import ola;
import ole;

class WSPlayerManager$1
  implements Runnable
{
  WSPlayerManager$1(WSPlayerManager paramWSPlayerManager, ole paramole) {}
  
  public void run()
  {
    if (this.e.b != null)
    {
      this.e.b.c(this.e);
      if (!this.this$0.isPause()) {
        break label53;
      }
      this.e.b.e(this.e);
    }
    label53:
    do
    {
      return;
      if (this.this$0.GZ())
      {
        this.e.b.h(this.e);
        return;
      }
    } while (!this.this$0.isCompleted());
    this.e.b.j(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */