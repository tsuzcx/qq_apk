package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ConvMailListFragment$23
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ConvMailListFragment$23(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new ConvMailListFragment.23.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.23
 * JD-Core Version:    0.7.0.1
 */