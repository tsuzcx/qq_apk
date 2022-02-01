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

class ConvMailListFragment$20
  implements View.OnClickListener
{
  ConvMailListFragment$20(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ConvMailListFragment.access$900(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ConvMailListFragment.access$2700(this.this$0).length != 0) {
        break;
      }
      this.this$0.getTips().showSuccess(2131695646, 700L);
    }
    int j = ConvMailListFragment.access$3200(this.this$0);
    int i = j;
    Object localObject;
    if (Mail.addAttrs(new Long[] { Long.valueOf(this.this$0.aggregateType), Long.valueOf(2048L) }) != this.this$0.aggregateType)
    {
      if (ConvMailListFragment.access$2700(this.this$0).length != 1) {
        break label189;
      }
      localObject = QMMailManager.sharedInstance().readMail(ConvMailListFragment.access$2700(this.this$0)[0], true);
      localObject = QMFolderManager.sharedInstance().getFolder(((Mail)localObject).getInformation().getFolderId());
      i = j;
      if (localObject != null) {
        i = ((QMFolder)localObject).getId();
      }
    }
    for (;;)
    {
      localObject = MoveMailActivity.createIntent(ConvMailListFragment.access$3300(this.this$0), i, ConvMailListFragment.access$2700(this.this$0));
      this.this$0.startActivityForResult((Intent)localObject, 2);
      break;
      label189:
      j = ((QMConvMailCursor)ConvMailListFragment.access$500(this.this$0)).getParentMail().getInformation().getFolderId();
      i = j;
      if (j == 0) {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.20
 * JD-Core Version:    0.7.0.1
 */