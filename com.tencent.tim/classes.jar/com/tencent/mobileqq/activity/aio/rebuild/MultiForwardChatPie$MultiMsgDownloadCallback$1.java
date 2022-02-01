package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;
import wki;
import ybl;
import ybl.b;

public class MultiForwardChatPie$MultiMsgDownloadCallback$1
  implements Runnable
{
  public MultiForwardChatPie$MultiMsgDownloadCallback$1(ybl.b paramb, ybl paramybl, CharSequence paramCharSequence) {}
  
  public void run()
  {
    ybl.a(this.a).setVisibility(8);
    ybl.a(this.a).setVisibility(0);
    ybl.a(this.a).setVisibility(0);
    this.a.mTitleText.setText(this.a.mSourceName);
    ybl.a(this.a).a(ybl.a(this.a), this.M);
    this.a.stopTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.1
 * JD-Core Version:    0.7.0.1
 */