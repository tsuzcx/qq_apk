package com.tencent.mobileqq.adapter;

import abfr;
import java.util.ArrayList;

public class RobotAdapter$5
  implements Runnable
{
  public RobotAdapter$5(abfr paramabfr, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    abfr.a(this.this$0).contains(this.bfz);
    abfr.a(this.this$0).remove(this.bfz);
    this.this$0.notifyDataSetChanged();
    if (!this.bgh) {
      this.this$0.showToast(this.val$code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.5
 * JD-Core Version:    0.7.0.1
 */