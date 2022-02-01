package com.tencent.mobileqq.activity.pendant;

import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

class AvatarPendantActivity$AnimationScrollListener$1
  implements Runnable
{
  AvatarPendantActivity$AnimationScrollListener$1(AvatarPendantActivity.b paramb) {}
  
  public void run()
  {
    if (this.a.this$0.mScrollState == 0)
    {
      URLDrawable.resume();
      this.a.this$0.a.scrolling = false;
      this.a.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener.1
 * JD-Core Version:    0.7.0.1
 */