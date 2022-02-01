package com.tencent.qqmail.activity.compose;

import java.util.ArrayList;

class ComposeFeedbackActivity$10$1
  implements Runnable
{
  ComposeFeedbackActivity$10$1(ComposeFeedbackActivity.10 param10) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.this$1.val$attachInfo);
    ComposeFeedbackActivity localComposeFeedbackActivity = this.this$1.this$0;
    localComposeFeedbackActivity.attachHandlingCount -= 1;
    this.this$1.this$0.preProcessAttachInBackground(localArrayList);
    this.this$1.this$0.hasFinishCompressFeedbackFile = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.10.1
 * JD-Core Version:    0.7.0.1
 */