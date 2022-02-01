package com.tencent.qqmail.thirdpartycall;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Date;
import moai.fragment.base.BaseFragment;
import org.apache.commons.lang3.StringUtils;

final class ThirdPartyCallDialogHelpler$1
  implements AdapterView.OnItemClickListener
{
  ThirdPartyCallDialogHelpler$1(long paramLong, QMBaseFragment paramQMBaseFragment, int paramInt, boolean paramBoolean) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject1;
    if (this.val$mailId != 0L) {
      if (paramInt == 0)
      {
        DataCollector.logEvent("Event_Local_File_Match_Attach_Read");
        localObject1 = QMMailManager.sharedInstance().getMailFromMailId(this.val$mailId);
        if (localObject1 == null) {
          Toast.makeText(ThirdPartyCallDialogHelpler.access$000().getContext(), "获取邮件出错", 0).show();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int j = ((Mail)localObject1).getInformation().getFolderId();
      Object localObject2 = ((Mail)localObject1).getInformation();
      MailStatus localMailStatus = ((Mail)localObject1).getStatus();
      MailContact localMailContact = ((MailInformation)localObject2).getFrom();
      boolean bool;
      if ((localMailStatus.isGroupMail()) || (!StringUtils.isEmpty(((MailInformation)localObject2).getGroupId())))
      {
        bool = true;
        label118:
        localObject2 = new ReadMailFragment(((MailInformation)localObject2).getAccountId(), j, ((MailInformation)localObject2).getId(), ((MailInformation)localObject2).getSubject(), localMailContact.getNick(), localMailContact.getAddress(), bool, null);
        this.val$fragment.startFragment((BaseFragment)localObject2);
        ((ReadMailFragment)localObject2).reuseMailData((Mail)localObject1);
        long l = new Date().getTime();
        DataCollector.logPerformanceBegin("Performance_List_Read_Mail", this.val$accountId, "Performance_List_Read_Mail" + l);
        QMLog.log(4, "TPCDialogHelpler", "read mail logPerformanceBegin key:" + l + ", time:" + l);
      }
      for (;;)
      {
        if (i == 0) {
          break label405;
        }
        if (!this.val$isAbandon) {
          break label407;
        }
        ThirdPartyCallDialogHelpler.access$400(this.val$fragment, ThirdPartyCallDialogHelpler.access$000(), true, null, new ThirdPartyCallDialogHelpler.1.1(this));
        break;
        bool = false;
        break label118;
        if (paramInt == 1)
        {
          DataCollector.logEvent("Event_Local_File_New_Compose");
          localObject1 = ComposeMailActivity.createIntetnFromThirdParty();
          this.val$fragment.startActivity((Intent)localObject1);
        }
        else if (paramInt == 2)
        {
          DataCollector.logEvent("Event_Local_File_Reply_Or_Forward");
          ThirdPartyCallDialogHelpler.access$100(ThirdPartyCallDialogHelpler.access$000(), this.val$fragment);
          i = 1;
          continue;
          if (paramInt == 0)
          {
            DataCollector.logEvent("Event_Local_File_New_Compose");
            localObject1 = ComposeMailActivity.createIntetnFromThirdParty();
            this.val$fragment.startActivity((Intent)localObject1);
          }
          else if (paramInt == 1)
          {
            DataCollector.logEvent("Event_Local_File_Reply_Or_Forward");
            ThirdPartyCallDialogHelpler.access$000().setVisibility(0);
            ThirdPartyCallDialogHelpler.access$100(ThirdPartyCallDialogHelpler.access$000(), this.val$fragment);
            i = 1;
          }
        }
      }
      label405:
      continue;
      label407:
      ThirdPartyCallDialogHelpler.access$400(this.val$fragment, ThirdPartyCallDialogHelpler.access$000(), true, null, new ThirdPartyCallDialogHelpler.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.1
 * JD-Core Version:    0.7.0.1
 */