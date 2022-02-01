package com.tencent.qqmail.sendmaillist;

import android.content.Intent;
import android.view.View;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;

class SendMailListFragment$10
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  SendMailListFragment$10(SendMailListFragment paramSendMailListFragment, QMSendMailTask paramQMSendMailTask, View paramView) {}
  
  private void convertAllNormalAttach2BigAttach()
  {
    Object localObject = this.val$selectedTask.getMail();
    if (localObject != null)
    {
      localObject = ((ComposeMailUI)localObject).getAddAttachInfoList();
      if (localObject != null) {
        break label22;
      }
    }
    for (;;)
    {
      return;
      label22:
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AttachInfo localAttachInfo = (AttachInfo)((Iterator)localObject).next();
        if (localAttachInfo.isBinaryAttach())
        {
          localAttachInfo.setNeedFtnUpload(true);
          localAttachInfo.setBigAttach(true);
        }
      }
    }
  }
  
  private void goToSmtpSetting()
  {
    Object localObject = this.val$selectedTask.getMail();
    String str;
    int i;
    if (localObject != null)
    {
      str = ((ComposeMailUI)localObject).getErrMsg();
      i = ((ComposeMailUI)localObject).getInformation().getAccountId();
      localObject = LoginFragmentActivity.createIntentForSettingProtocol(i, true);
      if (!str.equals(this.this$0.getString(2131697375))) {
        break label62;
      }
      localObject = LoginFragmentActivity.createIntentForSmtpError(i, true);
    }
    for (;;)
    {
      this.this$0.startActivity((Intent)localObject);
      return;
      label62:
      if (str.equals(this.this$0.getString(2131697367))) {
        localObject = LoginFragmentActivity.createIntentForSmtpError(i, false);
      }
    }
  }
  
  private void resendMail()
  {
    this.val$selectedTask.setVerify(null);
    ComposeMailUI localComposeMailUI = this.val$selectedTask.getMail();
    if ((localComposeMailUI.getClockSendTime() > 0L) && (localComposeMailUI.getClockSendTime() - System.currentTimeMillis() <= 18000L))
    {
      SendMailListFragment.access$1800(this.this$0, this.val$selectedTask);
      return;
    }
    if (this.val$selectedTask.getVerifyKey() != null)
    {
      QMLog.log(6, "SendMailListFragment", "need verify code accountId: " + this.val$selectedTask.getAccountId() + " taskId: " + this.val$selectedTask.getId() + " verifyKey: " + this.val$selectedTask.getVerifyKey());
      QMCalendarManager.getInstance().getVerifyImage(this.val$selectedTask.getAccountId(), this.val$selectedTask.getId(), this.val$selectedTask.getVerifyKey());
      return;
    }
    QMTaskManager.sharedInstance(1).restart(this.val$selectedTask.getId());
  }
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    QMLog.log(4, "SendMailListFragment", "click " + paramString);
    paramQMBottomDialog.dismiss();
    if (paramString == null) {}
    do
    {
      return;
      if (paramString.equals(this.this$0.getString(2131694375)))
      {
        goToSmtpSetting();
        return;
      }
      if (paramString.equals(this.this$0.getString(2131692498)))
      {
        SendMailListFragment.access$1600(this.this$0, this.val$selectedTask);
        return;
      }
      if (paramString.equals(this.this$0.getString(2131691256)))
      {
        ((MailListItemView)((HorizontalScrollItemView)this.val$sendMailListView).getContentView()).getItemData().statusId = 6;
        DataCollector.logEvent("Event_Send_Mail_ProgressBar_Click_To_Cancel");
        QMTaskManager.sharedInstance(1).cancel(this.val$selectedTask.getId());
        return;
      }
      if (paramString.equals(this.this$0.getString(2131718838)))
      {
        resendMail();
        return;
      }
      if (paramString.equals(this.this$0.getString(2131692322)))
      {
        convertAllNormalAttach2BigAttach();
        resendMail();
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131718665)));
    this.val$selectedTask.setVerify(null);
    SendMailListFragment.access$1700(this.this$0, this.val$selectedTask.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.10
 * JD-Core Version:    0.7.0.1
 */