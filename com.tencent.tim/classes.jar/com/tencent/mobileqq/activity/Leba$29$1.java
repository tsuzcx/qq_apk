package com.tencent.mobileqq.activity;

import java.util.List;
import vfg;
import zjo;

public class Leba$29$1
  implements Runnable
{
  public Leba$29$1(vfg paramvfg, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.a.this$0) != null)
    {
      Leba.a(this.a.this$0).clear();
      Leba.a(this.a.this$0).addAll(this.jr);
      if (Leba.a(this.a.this$0) != null) {
        Leba.a(this.a.this$0).notifyDataSetChanged();
      }
      Leba.c(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.29.1
 * JD-Core Version:    0.7.0.1
 */