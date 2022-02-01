package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$148
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$148(ReadMailFragment paramReadMailFragment, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131721918))) {
      if (ReadMailFragment.access$23100(this.this$0)) {}
    }
    do
    {
      return;
      if (!QMActivityManager.shareInstance().finishTopActivityExclusiveComposeMailActivity())
      {
        paramView = ComposeMailActivity.createIntentWithContact(0L, "", this.val$mailAddress, ReadMailFragment.access$200(this.this$0));
        this.this$0.startActivity(paramView);
      }
      DataCollector.logEvent("Event_Content_Recognize_Compose_Mail");
      paramQMBottomDialog.dismiss();
      return;
      if (paramString.equals(this.this$0.getString(2131692324)))
      {
        this.this$0.copy(this.val$mailAddress);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$0.getString(2131691485)))
      {
        DataCollector.logEvent("Event_WeCall_Contact_Check");
        paramView = ContactsFragmentActivity.createContactDetailIntent(0L, ReadMailFragment.access$200(this.this$0), this.val$mailAddress, "", 2);
        this.this$0.startActivity(paramView);
        paramQMBottomDialog.dismiss();
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131692342)));
    paramQMBottomDialog.dismiss();
    DataCollector.logEvent("Event_Contact_AddTo_Normal");
    paramQMBottomDialog = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
    paramQMBottomDialog.setOnSheetItemClickListener(new ReadMailFragment.148.1(this));
    paramQMBottomDialog.addItem(this.this$0.getString(2131692000));
    paramQMBottomDialog.addItem(this.this$0.getString(2131692008));
    paramQMBottomDialog.build().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.148
 * JD-Core Version:    0.7.0.1
 */