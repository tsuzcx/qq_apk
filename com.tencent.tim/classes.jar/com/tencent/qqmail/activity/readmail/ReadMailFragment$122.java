package com.tencent.qqmail.activity.readmail;

import android.widget.EditText;
import android.widget.Toast;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadMailFragment$122
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$122(ReadMailFragment paramReadMailFragment, EditText paramEditText) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    String str = this.val$editText.getText().toString().trim();
    if ("".equals(str))
    {
      Toast.makeText(this.this$0.getActivity(), this.this$0.getString(2131721675), 0).show();
      return;
    }
    ReadMailFragment.access$4800(this.this$0);
    ReadMailFragment.access$19500(this.this$0, str);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.122
 * JD-Core Version:    0.7.0.1
 */