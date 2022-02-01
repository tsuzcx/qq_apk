package com.tencent.mobileqq.copyprompt;

import aewi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(aewi paramaewi) {}
  
  public void run()
  {
    if ((aewi.a(this.this$0) != null) && (aewi.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aewi.a(this.this$0).mAIORootView.findViewById(2131364469)).removeView(aewi.a(this.this$0));
      aewi.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */