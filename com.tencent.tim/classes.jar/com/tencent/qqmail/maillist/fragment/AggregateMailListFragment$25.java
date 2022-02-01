package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.QMConvMailCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.movemail.MoveMailActivity;
import com.tencent.qqmail.utilities.ui.QMTips;

class AggregateMailListFragment$25
  implements View.OnClickListener
{
  AggregateMailListFragment$25(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (AggregateMailListFragment.access$800(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AggregateMailListFragment.access$2800(this.this$0).length != 0) {
        break;
      }
      this.this$0.getTips().showSuccess(2131695646, 700L);
    }
    Object localObject;
    if (Mail.addAttrs(new Long[] { Long.valueOf(AggregateMailListFragment.access$2200(this.this$0)), Long.valueOf(2048L) }) != AggregateMailListFragment.access$2200(this.this$0))
    {
      if (AggregateMailListFragment.access$2800(this.this$0).length != 1) {
        break label170;
      }
      localObject = QMMailManager.sharedInstance().readMail(AggregateMailListFragment.access$2800(this.this$0)[0], true);
      i = QMFolderManager.sharedInstance().getFolder(((Mail)localObject).getInformation().getFolderId()).getId();
    }
    for (;;)
    {
      localObject = MoveMailActivity.createIntent(AggregateMailListFragment.access$3300(this.this$0), i, AggregateMailListFragment.access$2800(this.this$0));
      this.this$0.startActivityForResult((Intent)localObject, 2);
      break;
      label170:
      int j = ((QMConvMailCursor)AggregateMailListFragment.access$500(this.this$0)).getParentMail().getInformation().getFolderId();
      i = j;
      if (j == 0) {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.25
 * JD-Core Version:    0.7.0.1
 */