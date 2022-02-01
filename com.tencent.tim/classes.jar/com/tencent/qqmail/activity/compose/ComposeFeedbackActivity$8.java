package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

class ComposeFeedbackActivity$8
  implements QMGeneralCallback
{
  ComposeFeedbackActivity$8(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void onError()
  {
    this.this$0.runOnUiThread(new ComposeFeedbackActivity.8.2(this));
  }
  
  public void onSuccess()
  {
    this.this$0.runOnUiThread(new ComposeFeedbackActivity.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.8
 * JD-Core Version:    0.7.0.1
 */