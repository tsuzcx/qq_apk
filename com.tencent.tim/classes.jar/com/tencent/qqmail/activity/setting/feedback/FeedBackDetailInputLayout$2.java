package com.tencent.qqmail.activity.setting.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FeedBackDetailInputLayout$2
  implements View.OnClickListener
{
  FeedBackDetailInputLayout$2(FeedBackDetailInputLayout paramFeedBackDetailInputLayout) {}
  
  public void onClick(View paramView)
  {
    if (FeedBackDetailInputLayout.access$000(this.this$0) != null) {
      FeedBackDetailInputLayout.access$000(this.this$0).onClickAddImageBtn();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.FeedBackDetailInputLayout.2
 * JD-Core Version:    0.7.0.1
 */