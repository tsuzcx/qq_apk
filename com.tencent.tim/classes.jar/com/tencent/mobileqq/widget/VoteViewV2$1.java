package com.tencent.mobileqq.widget;

import android.view.View;
import arjp;
import arjt;

public class VoteViewV2$1
  implements Runnable
{
  VoteViewV2$1(VoteViewV2 paramVoteViewV2) {}
  
  public void run()
  {
    if (VoteViewV2.a(this.this$0))
    {
      this.this$0.findViewById(2131370147).setVisibility(0);
      arjp.g(this.this$0);
      this.this$0.findViewById(2131370147).setOnClickListener(new arjt(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2.1
 * JD-Core Version:    0.7.0.1
 */