package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.UpdateInnerHtmlCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeNoteActivity$LocalDraftHandler$1
  implements QMUIRichEditor.UpdateInnerHtmlCallback
{
  ComposeNoteActivity$LocalDraftHandler$1(ComposeNoteActivity.LocalDraftHandler paramLocalDraftHandler, ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void success()
  {
    ComposeNoteActivity.access$4500(this.val$activity, ComposeNoteActivity.access$1000(this.val$activity));
    LocalDraftUtils.saveLocalDraftInBackground(ComposeNoteActivity.access$1000(this.val$activity));
    QMLog.log(4, "ComposeNoteActivity", "Timing task is saveing note local draft");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.LocalDraftHandler.1
 * JD-Core Version:    0.7.0.1
 */