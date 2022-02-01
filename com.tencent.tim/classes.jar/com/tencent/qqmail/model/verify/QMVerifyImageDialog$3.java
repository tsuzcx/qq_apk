package com.tencent.qqmail.model.verify;

import android.widget.EditText;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class QMVerifyImageDialog$3
  implements QMUIDialogAction.ActionListener
{
  QMVerifyImageDialog$3(QMVerifyImageDialog paramQMVerifyImageDialog, EditText paramEditText, QMVerifyImageDialog.SendVeifyCallBack paramSendVeifyCallBack) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = new QMVerify();
    paramQMUIDialog.setImageUrl(QMVerifyImageDialog.access$500(this.this$0));
    paramQMUIDialog.setVerifyCode(this.val$editText.getText().toString());
    paramQMUIDialog.setVerifyKey(QMVerifyImageDialog.access$400(this.this$0));
    paramQMUIDialog.setVerifySession(QMVerifyImageDialog.access$600(this.this$0));
    paramQMUIDialog.setAuthImagesId(QMVerifyImageDialog.access$700(this.this$0));
    if (this.val$sendVeifyCallBack != null) {
      this.val$sendVeifyCallBack.sendWithVerify(paramQMUIDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.verify.QMVerifyImageDialog.3
 * JD-Core Version:    0.7.0.1
 */