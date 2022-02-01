package com.tencent.qqmail.bottle.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.qqmail.bottle.controller.BottleConversationCursor;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottlerController;
import com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;

class BottleConversationFragment$22
  extends QMListPopupWindow
{
  BottleConversationFragment$22(BottleConversationFragment paramBottleConversationFragment, Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.isAttachedToActivity()) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAdapterView = BottleConversationFragment.access$1600(this.this$0).getCursor();
      if ((paramAdapterView != null) && (paramAdapterView.getUin() != null))
      {
        paramAdapterView = BottleConversationFragment.access$600(this.this$0).getBottlerController().getBottler(paramAdapterView.getUin());
        BottleConversationFragment.access$1700(this.this$0, paramAdapterView);
        return;
      }
      QMLog.log(5, "BottleConversationFragment", "showBottlerDetail null");
      return;
    case 1: 
      BottleConversationFragment.access$1800(this.this$0);
      return;
    }
    BottleConversationFragment.access$900(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.22
 * JD-Core Version:    0.7.0.1
 */