package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class AggregateMailListFragment$27
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  AggregateMailListFragment$27(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new AggregateMailListFragment.27.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.27
 * JD-Core Version:    0.7.0.1
 */