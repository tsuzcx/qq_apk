package com.tencent.mobileqq.nearby.now;

import akbc;
import android.app.Activity;

class StoryPlayController$9
  implements Runnable
{
  StoryPlayController$9(StoryPlayController paramStoryPlayController) {}
  
  public void run()
  {
    if ((StoryPlayController.a(this.this$0) != null) && (StoryPlayController.a(this.this$0).isShowing()))
    {
      if (((this.this$0.mContext instanceof Activity)) && ((StoryPlayController.b(this.this$0)) || (((Activity)this.this$0.mContext).isFinishing()))) {
        StoryPlayController.a(this.this$0, null);
      }
    }
    else {
      return;
    }
    StoryPlayController.a(this.this$0).dismiss();
    StoryPlayController.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.9
 * JD-Core Version:    0.7.0.1
 */