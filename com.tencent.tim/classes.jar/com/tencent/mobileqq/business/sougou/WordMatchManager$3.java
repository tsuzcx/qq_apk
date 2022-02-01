package com.tencent.mobileqq.business.sougou;

import com.tencent.mobileqq.app.QQAppInterface;

class WordMatchManager$3
  implements Runnable
{
  WordMatchManager$3(WordMatchManager paramWordMatchManager, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.initEnvironment();
    this.this$0.mApp.runOnUiThread(new WordMatchManager.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.3
 * JD-Core Version:    0.7.0.1
 */