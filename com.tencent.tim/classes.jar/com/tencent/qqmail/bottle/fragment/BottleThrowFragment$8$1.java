package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.QMLocation;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BottleThrowFragment$8$1
  implements QMUIDialogAction.ActionListener
{
  BottleThrowFragment$8$1(BottleThrowFragment.8 param8) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    BottleThrowFragment.access$200(this.this$1.this$0, null);
    QMLocation.gotoEnableLocationPage(this.this$1.this$0.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.8.1
 * JD-Core Version:    0.7.0.1
 */