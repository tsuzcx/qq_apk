package com.tencent.qqmail.activity.compose;

import android.widget.EditText;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import moai.oss.KvHelper;

class ComposeMailActivity$56
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$56(ComposeMailActivity paramComposeMailActivity, EditText paramEditText, AttachInfo paramAttachInfo) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (!"".equals(this.val$editText.getText().toString().trim()))
    {
      paramQMUIDialog = FileUtil.getFileNameSuffix(this.val$info.getAttachName());
      if (!"".equals(paramQMUIDialog)) {
        break label112;
      }
    }
    label112:
    for (paramQMUIDialog = "";; paramQMUIDialog = "." + paramQMUIDialog)
    {
      if (QMAttachUtils.renameAttachInfo(this.val$editText.getText().toString().trim() + paramQMUIDialog, this.val$info, this.this$0.composeView)) {
        ComposeMailActivity.access$5400(this.this$0).notifyDataSetChanged();
      }
      KvHelper.eventComposeAttachRename(new double[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.56
 * JD-Core Version:    0.7.0.1
 */