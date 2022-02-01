package com.tencent.qqmail.schema;

import android.app.Activity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class SchemaUtil$1$1$1
  implements Runnable
{
  SchemaUtil$1$1$1(SchemaUtil.1.1 param1) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity != null) {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(localActivity).setTitle(2131696354)).setMessage(2131721590).addAction(2131694717, new SchemaUtil.1.1.1.2(this))).addAction(2131694378, new SchemaUtil.1.1.1.1(this, localActivity))).create().show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaUtil.1.1.1
 * JD-Core Version:    0.7.0.1
 */