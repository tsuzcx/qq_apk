package com.tencent.qqmail.namelist.fragment;

import android.widget.EditText;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class NameListAddFragment$8
  implements QMUIDialogAction.ActionListener
{
  NameListAddFragment$8(NameListAddFragment paramNameListAddFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    NameListAddFragment.access$200(this.this$0).requestFocus();
    NameListAddFragment.access$200(this.this$0).postDelayed(new NameListAddFragment.8.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAddFragment.8
 * JD-Core Version:    0.7.0.1
 */