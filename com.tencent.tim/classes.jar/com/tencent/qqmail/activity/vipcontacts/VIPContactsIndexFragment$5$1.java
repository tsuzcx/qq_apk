package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class VIPContactsIndexFragment$5$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  VIPContactsIndexFragment$5$1(VIPContactsIndexFragment.5 param5, MailContact paramMailContact) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    boolean bool = true;
    paramView = QMContactManager.sharedInstance();
    paramString = Lists.newArrayList(new MailContact[] { this.val$mailContact });
    if (!this.val$mailContact.isVip()) {}
    for (;;)
    {
      paramView.setVip(paramString, bool);
      paramQMBottomDialog.dismiss();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.5.1
 * JD-Core Version:    0.7.0.1
 */