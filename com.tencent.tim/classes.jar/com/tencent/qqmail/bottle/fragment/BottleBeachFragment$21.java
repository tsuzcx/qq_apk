package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class BottleBeachFragment$21
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  BottleBeachFragment$21(BottleBeachFragment paramBottleBeachFragment, BottleBeach paramBottleBeach) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131690961)))
    {
      BottleBeachFragment.access$1800(this.this$0, this.val$bottle.getBottleid());
      paramQMBottomDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.21
 * JD-Core Version:    0.7.0.1
 */