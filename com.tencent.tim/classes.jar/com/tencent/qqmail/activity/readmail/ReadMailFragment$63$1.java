package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.readmail.ReadMailHelper.AfterValidateMail;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;

class ReadMailFragment$63$1
  implements ReadMailHelper.AfterValidateMail
{
  ReadMailFragment$63$1(ReadMailFragment.63 param63) {}
  
  public void action()
  {
    if (!ReadMailFragment.access$12500(this.this$1.this$0)) {
      ReadMailFragment.access$12600(this.this$1.this$0, ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_DRAFT, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.63.1
 * JD-Core Version:    0.7.0.1
 */