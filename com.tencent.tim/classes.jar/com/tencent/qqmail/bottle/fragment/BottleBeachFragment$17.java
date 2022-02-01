package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleBeachController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BottleBeachFragment$17
  implements QMUIDialogAction.ActionListener
{
  BottleBeachFragment$17(BottleBeachFragment paramBottleBeachFragment, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    BottleBeachFragment.access$1600(this.this$0).logEvent("Event_Bottle_Beach_Spam");
    BottleBeachFragment.access$200(this.this$0).spam(this.val$bottleId, new BottleBeachFragment.17.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.17
 * JD-Core Version:    0.7.0.1
 */