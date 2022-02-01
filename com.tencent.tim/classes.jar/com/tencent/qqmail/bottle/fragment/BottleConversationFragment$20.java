package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BottleConversationFragment$20
  implements QMUIDialogAction.ActionListener
{
  BottleConversationFragment$20(BottleConversationFragment paramBottleConversationFragment, BottleConversation paramBottleConversation) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    BottleConversationFragment.access$600(this.this$0).getBottleThrowController().resendBottle(this.val$bottle.getBottleId(), this.val$bottle.getMsgId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.20
 * JD-Core Version:    0.7.0.1
 */