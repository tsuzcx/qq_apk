package com.tencent.component.media.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;

class NewGifDrawable$1
  implements Runnable
{
  NewGifDrawable$1(NewGifDrawable paramNewGifDrawable) {}
  
  public void run()
  {
    NewGifDrawable.access$000(this.this$0);
    this.this$0.mExecutor.execute(new NewGifDrawable.1.1(this, this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.1
 * JD-Core Version:    0.7.0.1
 */