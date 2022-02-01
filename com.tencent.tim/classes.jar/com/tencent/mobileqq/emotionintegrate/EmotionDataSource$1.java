package com.tencent.mobileqq.emotionintegrate;

import afrl;
import afro;
import afro.a;
import java.util.List;

public class EmotionDataSource$1
  implements Runnable
{
  public EmotionDataSource$1(afro paramafro, boolean paramBoolean, afro.a parama, afrl paramafrl) {}
  
  public void run()
  {
    List localList = this.this$0.s(this.val$forceUpdate);
    if (this.a != null) {
      this.a.a(localList, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */