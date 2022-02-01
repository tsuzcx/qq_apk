package com.tencent.mobileqq.activity.miniaio;

import java.util.ArrayList;
import zni;

class MiniMultiForwardFragment$1$1
  implements Runnable
{
  MiniMultiForwardFragment$1$1(MiniMultiForwardFragment.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.a.this$0.a != null) && (this.nj != null))
    {
      this.a.this$0.a.a(this.nj, null, 0);
      this.a.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment.1.1
 * JD-Core Version:    0.7.0.1
 */