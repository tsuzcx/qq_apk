package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;

final class LocalDraftUtils$1
  implements Runnable
{
  LocalDraftUtils$1(ComposeMailUI paramComposeMailUI) {}
  
  public void run()
  {
    LocalDraftUtils.saveLocalDraft(this.val$composeMailUI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.LocalDraftUtils.1
 * JD-Core Version:    0.7.0.1
 */