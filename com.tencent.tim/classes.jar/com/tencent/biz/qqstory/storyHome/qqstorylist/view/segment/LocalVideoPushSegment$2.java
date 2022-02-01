package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import qzc;
import qzc.c;
import ram;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(qzc paramqzc) {}
  
  public void run()
  {
    ram.d("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    qzc.c localc = qzc.a(this.this$0);
    if (localc != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localc));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */