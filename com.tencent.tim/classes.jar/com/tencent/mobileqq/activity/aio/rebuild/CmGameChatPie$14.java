package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.apollo.view.FrameGifView;
import xxh;

public class CmGameChatPie$14
  implements Runnable
{
  public CmGameChatPie$14(xxh paramxxh, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.bky)
    {
      if (xxh.a(this.this$0).getState() == 3)
      {
        xxh.a(this.this$0).cGV();
        return;
      }
      xxh.a(this.this$0).setImageResource(2130839445);
      return;
    }
    xxh.a(this.this$0).stop();
    xxh.a(this.this$0).setImageResource(2130839443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.14
 * JD-Core Version:    0.7.0.1
 */