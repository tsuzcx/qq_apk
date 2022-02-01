package com.tencent.tim.activity.profile.host;

import android.view.View;
import android.widget.TextView;
import aqnm;

class HostProfileFragment$2
  implements Runnable
{
  HostProfileFragment$2(HostProfileFragment paramHostProfileFragment, TextView paramTextView, String paramString) {}
  
  public void run()
  {
    float f = ((View)this.val$tv.getParent()).getWidth() - aqnm.dpToPx(15.0F);
    ((EllipsizeWithImageSpanTextView)this.val$tv).setTextIncludingSpan(this.cGD, HostProfileFragment.a(this.this$0), f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.host.HostProfileFragment.2
 * JD-Core Version:    0.7.0.1
 */