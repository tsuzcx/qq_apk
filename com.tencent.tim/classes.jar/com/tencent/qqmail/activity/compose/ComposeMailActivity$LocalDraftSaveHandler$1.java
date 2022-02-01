package com.tencent.qqmail.activity.compose;

class ComposeMailActivity$LocalDraftSaveHandler$1
  implements Runnable
{
  ComposeMailActivity$LocalDraftSaveHandler$1(ComposeMailActivity.LocalDraftSaveHandler paramLocalDraftSaveHandler, ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    ComposeMailActivity.access$7700(this.val$activity, this.val$activity.composeMail, true);
    LocalDraftUtils.saveLocalDraft(this.val$activity.composeMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.LocalDraftSaveHandler.1
 * JD-Core Version:    0.7.0.1
 */