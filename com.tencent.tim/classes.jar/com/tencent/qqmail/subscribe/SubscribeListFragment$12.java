package com.tencent.qqmail.subscribe;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class SubscribeListFragment$12
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  SubscribeListFragment$12(SubscribeListFragment paramSubscribeListFragment, Runnable paramRunnable) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131692498)))
    {
      if (this.val$deleteAction != null) {
        this.val$deleteAction.run();
      }
      paramQMBottomDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.12
 * JD-Core Version:    0.7.0.1
 */