package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import java.util.ArrayList;

class QMGroupChoserActivity$6
  implements View.OnClickListener
{
  QMGroupChoserActivity$6(QMGroupChoserActivity paramQMGroupChoserActivity) {}
  
  public void onClick(View paramView)
  {
    if (QMGroupChoserActivity.access$800(this.this$0) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = QMGroupChoserActivity.access$800(this.this$0).getSelectedItem();
    Object localObject;
    if ((QMGroupChoserActivity.access$100(this.this$0) != null) && (QMGroupChoserActivity.access$100(this.this$0).getGroupContacts() != null))
    {
      localObject = (MailContact)QMGroupChoserActivity.access$100(this.this$0).getGroupContacts().get(i);
      if (localObject == null) {}
    }
    for (long l = ((MailContact)localObject).getId();; l = 0L)
    {
      if (l == 0L) {
        QMLog.log(6, "QMGroupChoserActivity", "choose position " + i);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("ARG_GROUP_CONTACT_ID", l);
      this.this$0.returnWithData(-1, (Intent)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity.6
 * JD-Core Version:    0.7.0.1
 */