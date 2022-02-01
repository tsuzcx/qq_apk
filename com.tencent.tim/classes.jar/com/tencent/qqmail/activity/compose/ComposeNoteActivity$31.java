package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class ComposeNoteActivity$31
  implements Action1<Boolean>
{
  ComposeNoteActivity$31(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptRecord(new double[0]);
      ComposeNoteActivity.access$3800(this.this$0);
      return;
    }
    KvHelper.eventPermissionDenyRecord(new double[0]);
    PermissionUtils.permissionWarn(this.this$0, 2131718909, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.31
 * JD-Core Version:    0.7.0.1
 */