package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;

class SchemaCompose$1
  implements MailManagerDelegate.EventCallback
{
  SchemaCompose$1(SchemaCompose paramSchemaCompose, Mail paramMail, int paramInt) {}
  
  public void run(Object paramObject)
  {
    paramObject = new MailUI(this.val$composeMail);
    paramObject = ComposeMailActivity.createIntentForSchema(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD, 1, paramObject);
    if (paramObject != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      paramObject.putExtra("animationType", this.val$anim);
      this.this$0.context.startActivity(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaCompose.1
 * JD-Core Version:    0.7.0.1
 */