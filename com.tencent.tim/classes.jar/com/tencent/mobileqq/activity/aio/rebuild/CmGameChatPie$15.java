package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.apollo.view.FrameGifView;
import xxh;

public class CmGameChatPie$15
  implements Runnable
{
  public CmGameChatPie$15(xxh paramxxh, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.bky)
    {
      if (xxh.b(this.this$0).getState() == 3)
      {
        xxh.b(this.this$0).cGV();
        return;
      }
      xxh.b(this.this$0).setImageResource(2130839446);
      return;
    }
    xxh.b(this.this$0).stop();
    xxh.b(this.this$0).setImageResource(2130839444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.15
 * JD-Core Version:    0.7.0.1
 */