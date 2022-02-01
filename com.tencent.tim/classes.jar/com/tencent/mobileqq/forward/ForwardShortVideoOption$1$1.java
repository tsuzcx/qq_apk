package com.tencent.mobileqq.forward;

import aqju;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class ForwardShortVideoOption$1$1
  implements Runnable
{
  ForwardShortVideoOption$1$1(ForwardShortVideoOption.1 param1) {}
  
  public void run()
  {
    this.a.s.setBounds(0, 0, this.a.s.getIntrinsicWidth(), this.a.s.getIntrinsicHeight());
    this.a.av.setPreviewImage(this.a.s, true, 0, true);
    if (this.a.chu)
    {
      if ((this.a.val$size != 0) && (this.a.val$duration != 0))
      {
        this.a.av.setVideoFormat(true, false, ShortVideoUtils.g(this.a.this$0.mAppContext, this.a.val$size), ShortVideoUtils.stringForTime(this.a.val$duration * 1000));
        return;
      }
      this.a.av.setVideoFormat(true, false, null, null);
      return;
    }
    this.a.av.setVideoFormat(true, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.1.1
 * JD-Core Version:    0.7.0.1
 */