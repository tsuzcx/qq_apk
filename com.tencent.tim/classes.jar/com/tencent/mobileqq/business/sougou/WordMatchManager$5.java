package com.tencent.mobileqq.business.sougou;

import com.tencent.mobileqq.app.ThreadManager;

class WordMatchManager$5
  implements Runnable
{
  WordMatchManager$5(WordMatchManager paramWordMatchManager, int paramInt) {}
  
  public void run()
  {
    if (this.cLu == 2) {
      this.this$0.u(this.this$0.mApp, 1);
    }
    do
    {
      return;
      if (this.cLu == 1)
      {
        if (this.this$0.bSi)
        {
          ThreadManager.post(new WordMatchManager.TaskHttpDownload(this.this$0, 3), 8, null, true);
          return;
        }
        this.this$0.GU(true);
        return;
      }
      if (this.cLu == 3)
      {
        if (this.this$0.bSi)
        {
          ThreadManager.post(new WordMatchManager.TaskHttpDownload(this.this$0, 4), 8, null, true);
          return;
        }
        this.this$0.GU(true);
        return;
      }
    } while (this.cLu != 4);
    this.this$0.GU(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.5
 * JD-Core Version:    0.7.0.1
 */