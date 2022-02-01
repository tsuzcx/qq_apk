package com.tencent.mobileqq.ark;

import adrh;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(adrh paramadrh) {}
  
  public void run()
  {
    if (adrh.a(this.this$0)) {
      return;
    }
    adrh.a(this.this$0, true);
    if (adrh.a(this.this$0) == adrh.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      adrh.a(this.this$0, adrh.f(this.this$0));
      return;
      if (adrh.a(this.this$0) == adrh.c(this.this$0)) {
        this.this$0.Stop();
      } else if (adrh.a(this.this$0) == adrh.d(this.this$0)) {
        this.this$0.Resume();
      } else if (adrh.a(this.this$0) == adrh.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */