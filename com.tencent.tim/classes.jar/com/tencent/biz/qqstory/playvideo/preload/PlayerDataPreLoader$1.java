package com.tencent.biz.qqstory.playvideo.preload;

import qoh;
import qoh.a;
import ram;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(qoh paramqoh) {}
  
  public void run()
  {
    qoh.a locala = qoh.a(this.this$0, qoh.a(this.this$0), qoh.a(this.this$0), qoh.a(this.this$0), 5, 5, 5, 20);
    qoh.a(this.this$0, locala.nv);
    qoh.b(this.this$0, locala.lb);
    try
    {
      qoh.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      ram.e("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */