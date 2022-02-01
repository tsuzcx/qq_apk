package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.card.QMCardManager;
import java.util.ArrayList;

class ComposeMailActivity$19
  implements Runnable
{
  ComposeMailActivity$19(ComposeMailActivity paramComposeMailActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    ComposeMailActivity.access$2800(this.this$0).batchSyncCardByCardIds(this.val$cardIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.19
 * JD-Core Version:    0.7.0.1
 */