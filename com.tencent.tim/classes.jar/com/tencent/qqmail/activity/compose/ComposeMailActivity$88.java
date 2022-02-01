package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class ComposeMailActivity$88
  implements BatchLoadCardListWatch
{
  ComposeMailActivity$88(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onBefore()
  {
    ComposeMailActivity.access$10300(this.this$0, new ComposeMailActivity.88.1(this));
  }
  
  public void onError(ArrayList<String> paramArrayList, QMNetworkError paramQMNetworkError)
  {
    ComposeMailActivity.access$10900(this.this$0, new ComposeMailActivity.88.3(this));
  }
  
  public void onSuccess(ArrayList<String> paramArrayList)
  {
    ComposeMailActivity.access$10800(this.this$0, new ComposeMailActivity.88.2(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.88
 * JD-Core Version:    0.7.0.1
 */