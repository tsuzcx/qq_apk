package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleConversationController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BottleConversationFragment$11
  implements QMUIDialogAction.ActionListener
{
  BottleConversationFragment$11(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    BottleManager localBottleManager = BottleConversationFragment.access$600(this.this$0);
    if (BottleConversationFragment.access$1100(this.this$0)) {}
    for (paramQMUIDialog = "Event_Bottle_Beach_Spam";; paramQMUIDialog = "Event_Bottle_Spam")
    {
      localBottleManager.logEvent(paramQMUIDialog);
      BottleConversationFragment.access$700(this.this$0).spam(BottleConversationFragment.access$500(this.this$0), BottleConversationFragment.access$1200(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.11
 * JD-Core Version:    0.7.0.1
 */