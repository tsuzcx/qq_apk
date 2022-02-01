package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;
import wki;
import ybl;

public class MultiForwardChatPie$6
  implements Runnable
{
  public MultiForwardChatPie$6(ybl paramybl, CharSequence paramCharSequence) {}
  
  public void run()
  {
    ybl.a(this.this$0).setVisibility(8);
    ybl.a(this.this$0).setVisibility(0);
    ybl.a(this.this$0).setVisibility(0);
    this.this$0.mTitleText.setText(this.this$0.mSourceName);
    ybl.a(this.this$0).a(ybl.a(this.this$0), this.M);
    this.this$0.stopTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.6
 * JD-Core Version:    0.7.0.1
 */