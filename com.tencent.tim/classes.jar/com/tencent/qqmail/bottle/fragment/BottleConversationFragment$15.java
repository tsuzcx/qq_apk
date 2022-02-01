package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleConversationController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BottleConversationFragment$15
  implements QMUIDialogAction.ActionListener
{
  BottleConversationFragment$15(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    BottleManager localBottleManager = BottleConversationFragment.access$600(this.this$0);
    if (BottleConversationFragment.access$1100(this.this$0)) {}
    for (paramQMUIDialog = "Event_Bottle_Beach_Delete";; paramQMUIDialog = "Event_Bottle_Delete")
    {
      localBottleManager.logEvent(paramQMUIDialog);
      BottleConversationFragment.access$700(this.this$0).remove(BottleConversationFragment.access$500(this.this$0), BottleConversationFragment.access$1500(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.15
 * JD-Core Version:    0.7.0.1
 */