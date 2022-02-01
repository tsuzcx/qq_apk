package com.tencent.mobileqq.copyprompt;

import aewn;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(aewn paramaewn) {}
  
  public void run()
  {
    if ((aewn.a(this.this$0) != null) && (aewn.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aewn.a(this.this$0).findViewById(2131364469)).removeView(aewn.a(this.this$0));
      aewn.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */