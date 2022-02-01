package com.tencent.qqmail.schema;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class SchemaUtil$1$1$1$2
  implements QMUIDialogAction.ActionListener
{
  SchemaUtil$1$1$1$2(SchemaUtil.1.1.1 param1) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "SchemaUtil", "click cancel");
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaUtil.1.1.1.2
 * JD-Core Version:    0.7.0.1
 */