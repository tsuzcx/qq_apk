package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$107$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$107$1(ReadMailFragment.107 param107, MailGroupContact paramMailGroupContact) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$1.this$0.getString(2131691899)))
    {
      this.val$groupContact.setAddress(this.val$groupContact.getGid());
      paramView = new ComposeMailUI();
      paramView.getInformation().setAccountId(ReadMailFragment.access$200(this.this$1.this$0));
      paramView.setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP);
      paramView.getStatus().setGroupMail(true);
      paramView.getInformation().setGroupContact(this.val$groupContact);
      paramView = ComposeMailActivity.createIntentForGroupMail(paramView);
      this.this$1.this$0.startActivity(paramView);
      paramQMBottomDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.107.1
 * JD-Core Version:    0.7.0.1
 */