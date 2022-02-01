package com.tencent.biz.qqstory.takevideo2;

import ram;
import rnq;

public class StoryPublishLauncher$1
  implements Runnable
{
  public StoryPublishLauncher$1(rnq paramrnq, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = rnq.As();
    ram.b("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(this.aJa), Boolean.valueOf(bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1
 * JD-Core Version:    0.7.0.1
 */