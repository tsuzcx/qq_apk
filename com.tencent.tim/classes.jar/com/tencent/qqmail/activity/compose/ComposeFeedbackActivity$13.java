package com.tencent.qqmail.activity.compose;

import android.view.Window;
import android.widget.EditText;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ComposeFeedbackActivity$13
  implements QMUIDialogAction.ActionListener
{
  ComposeFeedbackActivity$13(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = this.this$0.getWindow().getAttributes();
    paramQMUIDialog.softInputMode = 256;
    this.this$0.getWindow().setAttributes(paramQMUIDialog);
    ComposeFeedbackActivity.access$200(this.this$0).requestFocus();
    ComposeFeedbackActivity.access$200(this.this$0).requestFocusFromTouch();
    this.this$0.setCurrentFocusView(ComposeFeedbackActivity.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.13
 * JD-Core Version:    0.7.0.1
 */