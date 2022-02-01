package com.tencent.mobileqq.business.sougou;

import java.util.ArrayList;

class WordMatchManager$1
  implements Runnable
{
  WordMatchManager$1(WordMatchManager paramWordMatchManager, WordMatchManager.e parame) {}
  
  public void run()
  {
    if (this.b == null) {}
    do
    {
      return;
      if ((this.b != null) && (!this.this$0.vc.contains(this.b))) {
        this.this$0.vc.add(this.b);
      }
    } while (this.this$0.bSh);
    this.this$0.bSh = true;
    this.this$0.cVk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.1
 * JD-Core Version:    0.7.0.1
 */