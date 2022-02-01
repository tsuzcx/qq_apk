package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import psx;
import ptf;
import qzf;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(qzf paramqzf, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    ptf localptf = (ptf)psx.a(2);
    String str = localptf.i(Long.toString(qzf.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localptf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */