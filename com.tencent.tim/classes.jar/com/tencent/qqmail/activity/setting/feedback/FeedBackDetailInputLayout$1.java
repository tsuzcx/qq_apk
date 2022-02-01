package com.tencent.qqmail.activity.setting.feedback;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class FeedBackDetailInputLayout$1
  implements View.OnFocusChangeListener
{
  FeedBackDetailInputLayout$1(FeedBackDetailInputLayout paramFeedBackDetailInputLayout) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (FeedBackDetailInputLayout.access$000(this.this$0) != null) {
      FeedBackDetailInputLayout.access$000(this.this$0).onInputFoucChange(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.FeedBackDetailInputLayout.1
 * JD-Core Version:    0.7.0.1
 */