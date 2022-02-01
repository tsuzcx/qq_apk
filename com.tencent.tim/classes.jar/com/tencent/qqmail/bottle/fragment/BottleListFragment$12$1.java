package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.trd.guava.Lists;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class BottleListFragment$12$1
  implements QMUIDialogAction.ActionListener
{
  BottleListFragment$12$1(BottleListFragment.12 param12) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    BottleListFragment.access$1000(this.this$1.this$0).logEvent("Event_Bottle_Delete");
    paramQMUIDialog = Lists.newArrayList();
    Iterator localIterator = BottleListFragment.access$400(this.this$1.this$0).values().iterator();
    while (localIterator.hasNext()) {
      paramQMUIDialog.add((String)localIterator.next());
    }
    BottleListFragment.access$800(this.this$1.this$0).remove(paramQMUIDialog, new BottleListFragment.12.1.1(this, paramQMUIDialog));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.12.1
 * JD-Core Version:    0.7.0.1
 */