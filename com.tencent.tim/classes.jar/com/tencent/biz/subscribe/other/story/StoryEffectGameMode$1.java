package com.tencent.biz.subscribe.other.story;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import sff;

public class StoryEffectGameMode$1
  implements Runnable
{
  public void run()
  {
    if (!sff.a(this.this$0)) {
      return;
    }
    ThreadManager.getUIHandler().post(new StoryEffectGameMode.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.StoryEffectGameMode.1
 * JD-Core Version:    0.7.0.1
 */