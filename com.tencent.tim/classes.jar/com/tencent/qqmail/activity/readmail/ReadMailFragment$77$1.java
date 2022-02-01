package com.tencent.qqmail.activity.readmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.NoteSender;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment.NullFolderException;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.movemail.MoveMailActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMReadMailView;
import java.util.Calendar;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

class ReadMailFragment$77$1
  implements DialogInterface.OnDismissListener
{
  ReadMailFragment$77$1(ReadMailFragment.77 param77, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.this$1.this$0.isAttachedToActivity()) {
      QMLog.log(5, "ReadMailFragment", "showMoreActionsPopup onListItemClick fragment not attach.");
    }
    long l;
    do
    {
      return;
      l = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getId();
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131721792)))
      {
        if ((ReadMailFragment.access$000(this.this$1.this$0) != null) && (ReadMailFragment.access$000(this.this$1.this$0).getInformation() != null))
        {
          paramDialogInterface = QMFolderManager.sharedInstance().getFolder(ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFolderId());
          if (paramDialogInterface != null) {
            try
            {
              paramDialogInterface = new MailListFragment(paramDialogInterface.getAccountId(), paramDialogInterface.getId());
              this.this$1.this$0.startFragment(paramDialogInterface);
              return;
            }
            catch (MailListFragment.NullFolderException paramDialogInterface)
            {
              Toast.makeText(this.this$1.this$0.getActivity(), "打开文件夹失败", 1).show();
              paramDialogInterface.printStackTrace();
              return;
            }
          }
          Toast.makeText(this.this$1.this$0.getActivity(), "打开文件夹失败", 1).show();
          return;
        }
        Toast.makeText(this.this$1.this$0.getActivity(), "打开文件夹失败", 1).show();
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131696757)))
      {
        ReadMailFragment.access$13900(this.this$1.this$0);
        DataCollector.logEvent("Event_Share_Email_Content");
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131721274)))
      {
        KvHelper.eventNewActionSheetTranslateOn(new double[0]);
        if (this.this$1.this$0.isPopupMoreThroughTranslateBubble) {
          DataCollector.logEvent("Event_Translate_Translate_From_Tips");
        }
        if (((!ReadMailFragment.access$14000(this.this$1.this$0)) || (ReadMailFragment.access$14100(this.this$1.this$0))) && (QMSettingManager.sharedInstance().getIsShowTranslateProtocolMailTips()))
        {
          ReadMailFragment.access$14200(this.this$1.this$0);
          return;
        }
        ReadMailFragment.access$14300(this.this$1.this$0);
        return;
      }
      if (!this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131691558))) {
        break;
      }
      KvHelper.eventNewActionSheetTranslateOff(new double[0]);
      if (ReadMailFragment.access$2400(this.this$1.this$0) != null) {
        ReadMailFragment.access$2400(this.this$1.this$0).setTranslateStatus(0);
      }
      if (ReadMailFragment.access$2300(this.this$1.this$0) != null) {
        ReadMailFragment.access$10902(this.this$1.this$0, ReadMailFragment.access$2300(this.this$1.this$0).getScrollY());
      }
    } while (ReadMailFragment.access$10700(this.this$1.this$0) == null);
    ReadMailFragment.access$10800(this.this$1.this$0, ReadMailFragment.access$10700(this.this$1.this$0).getOriginalMailContent(), ReadMailFragment.access$10700(this.this$1.this$0).getOriginalMailSubj());
    ReadMailFragment.access$9100(this.this$1.this$0, true);
    return;
    if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131697042)))
    {
      ReadMailFragment.access$12900(this.this$1.this$0);
      return;
    }
    if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131695632))) {
      if (!ReadMailFragment.access$000(this.this$1.this$0).getStatus().isConversationChild()) {
        break label2284;
      }
    }
    label990:
    label1507:
    label2284:
    for (boolean bool1 = true;; bool1 = false)
    {
      ReadMailFragment.access$5000(this.this$1.this$0).spamMail(ReadMailFragment.access$200(this.this$1.this$0), ReadMailFragment.access$500(this.this$1.this$0), new long[] { l }, bool1);
      if (!ReadMailFragment.access$7100(this.this$1.this$0, ReadMailFragment.access$200(this.this$1.this$0))) {
        break;
      }
      ReadMailFragment.access$13200(this.this$1.this$0, true);
      return;
      int i;
      int j;
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131695630)))
      {
        paramDialogInterface = QMFolderManager.sharedInstance();
        i = paramDialogInterface.getInboxFolderId(this.this$1.val$accountId);
        j = paramDialogInterface.getSpamFolderId(this.this$1.val$accountId);
        ReadMailFragment.access$5000(this.this$1.this$0).moveMail(ReadMailFragment.access$200(this.this$1.this$0), j, l, i);
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.val$rejectTitle))
      {
        paramDialogInterface = this.this$1.this$0;
        String str;
        if (ReadMailFragment.access$14000(this.this$1.this$0))
        {
          i = 1;
          ReadMailFragment.access$7402(paramDialogInterface, i);
          ReadMailFragment.access$7502(this.this$1.this$0, 1);
          str = ReadMailFragment.access$14500(this.this$1.this$0);
          if ((ReadMailFragment.access$000(this.this$1.this$0).getStatus().isGroupMail()) || (!StringUtils.isEmpty(ReadMailFragment.access$000(this.this$1.this$0).getInformation().getGroupId()))) {
            str = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFrom().getName();
          }
          if (ReadMailFragment.access$7400(this.this$1.this$0) != 3) {
            break label1078;
          }
          paramDialogInterface = ReadMailFragment.access$5000(this.this$1.this$0);
          i = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getAccountId();
          j = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFolderId();
          l = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getId();
          if (ReadMailFragment.access$7400(this.this$1.this$0) == 3) {
            break label1066;
          }
          bool1 = true;
          if (ReadMailFragment.access$7500(this.this$1.this$0) != 3) {
            break label1072;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          paramDialogInterface.rejectMail(i, j, new long[] { l }, bool1, bool2);
          return;
          if ((this.this$1.val$isRejectedMail) && (ReadMailFragment.access$14400(this.this$1.this$0, this.this$1.val$accountId)))
          {
            i = 3;
            break;
          }
          i = 2;
          break;
          bool1 = false;
          break label990;
        }
        if (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isSubscribeMail())
        {
          paramDialogInterface = String.format(this.this$1.this$0.getString(2131695622), new Object[] { str });
          ReadMailFragment.access$7502(this.this$1.this$0, 3);
          QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity());
          ReadMailFragment localReadMailFragment = this.this$1.this$0;
          if ((!this.this$1.val$isRejectedMail) || (!ReadMailFragment.access$14400(this.this$1.this$0, this.this$1.val$accountId))) {
            break label1474;
          }
          i = 2131695639;
          paramDialogInterface = (QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localMessageDialogBuilder.setTitle(String.format(localReadMailFragment.getString(i), new Object[] { str }))).setMessage(paramDialogInterface).addAction(2131691246, new ReadMailFragment.77.1.2(this));
          if ((!this.this$1.val$isRejectedMail) || (!ReadMailFragment.access$14400(this.this$1.this$0, this.this$1.val$accountId))) {
            break label1507;
          }
          i = 2131691996;
        }
        for (;;)
        {
          ((QMUIDialog.MessageDialogBuilder)paramDialogInterface.addAction(i, new ReadMailFragment.77.1.1(this))).create().show();
          return;
          if (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isGroupMail())
          {
            paramDialogInterface = String.format(this.this$1.this$0.getString(2131695625), new Object[] { str });
            ReadMailFragment.access$7502(this.this$1.this$0, 2);
            break;
          }
          if ((this.this$1.val$isRejectedMail) && (ReadMailFragment.access$14400(this.this$1.this$0, this.this$1.val$accountId)))
          {
            paramDialogInterface = String.format(this.this$1.this$0.getString(2131695637), new Object[] { str });
            break;
          }
          paramDialogInterface = this.this$1.this$0;
          if (ReadMailFragment.access$14000(this.this$1.this$0)) {}
          for (i = 2131695621;; i = 2131695626)
          {
            paramDialogInterface = String.format(paramDialogInterface.getString(i), new Object[] { str });
            break;
          }
          if (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isSubscribeMail())
          {
            i = 2131695623;
            break label1197;
          }
          i = 2131695628;
          break label1197;
          if (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isSubscribeMail()) {
            i = 2131691990;
          } else {
            i = 2131691989;
          }
        }
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131696007)))
      {
        i = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFolderId();
        paramDialogInterface = MoveMailActivity.createIntent(ReadMailFragment.access$200(this.this$1.this$0), i, new long[] { l });
        this.this$1.this$0.startActivityForResult(paramDialogInterface, 105);
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.val$title_not_ad))
      {
        if (this.this$1.val$isAdMail)
        {
          ReadMailFragment.access$14600(this.this$1.this$0, this.this$1.val$title_not_ad, this.this$1.val$isConversationMail, true);
          return;
        }
        ReadMailFragment.access$14700(this.this$1.this$0, this.this$1.val$title_not_ad, this.this$1.val$isConversationMail, false);
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.val$title_is_ad))
      {
        if (this.this$1.val$isAdMail)
        {
          ReadMailFragment.access$14600(this.this$1.this$0, this.this$1.val$title_is_ad, this.this$1.val$isConversationMail, false);
          return;
        }
        ReadMailFragment.access$14700(this.this$1.this$0, this.this$1.val$title_is_ad, this.this$1.val$isConversationMail, true);
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131695199)))
      {
        if (FolderLockDialog.isFolderLock(-4))
        {
          paramDialogInterface = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
          if ((this.this$1.this$0.getActivity() == null) || (paramDialogInterface == null)) {
            break;
          }
          ReadMailFragment.access$9002(this.this$1.this$0, new FolderLockDialog(this.this$1.this$0.getActivity(), -4, paramDialogInterface.getId(), ReadMailFragment.access$14800(this.this$1.this$0)));
          ReadMailFragment.access$9000(this.this$1.this$0).createDialog(1);
          ReadMailFragment.access$9000(this.this$1.this$0).showDialog();
          ReadMailFragment.access$9402(this.this$1.this$0, true);
          return;
        }
        QMNotification.registNotification("save_mail_as_note_done", this.this$1.this$0.mSaveMailSucc);
        Toast.makeText(QMApplicationContext.sharedInstance(), this.this$1.this$0.getString(2131718967), 0).show();
        new NoteSender(l, "", "", "folder").buildData();
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131695201)))
      {
        paramDialogInterface = Calendar.getInstance();
        paramDialogInterface.setTimeInMillis(System.currentTimeMillis());
        if (paramDialogInterface.get(11) >= 23)
        {
          paramDialogInterface.add(11, 1);
          paramDialogInterface.set(12, 0);
          paramDialogInterface.set(13, 0);
        }
        for (;;)
        {
          KvHelper.calendarRemindClick(new double[0]);
          ReadMailFragment.access$15000(this.this$1.this$0, null, paramDialogInterface.getTimeInMillis(), ReadMailFragment.access$14900(this.this$1.this$0));
          return;
          paramDialogInterface.add(11, 1);
          paramDialogInterface.set(12, 0);
          paramDialogInterface.set(13, 0);
        }
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131718613)))
      {
        DataCollector.logEvent("Event_Mail_Revoke_Click");
        ReadMailFragment.access$15100(this.this$1.this$0);
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131717247)))
      {
        DataCollector.logEvent("Event_Mail_Revoke_Result");
        ReadMailFragment.access$13600(this.this$1.this$0, 1);
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131695635)))
      {
        KvHelper.creditCardBillClick(new double[0]);
        ReadMailFragment.access$15200(this.this$1.this$0);
        return;
      }
      if (!this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131695636))) {
        break;
      }
      ReadMailFragment.access$15300(this.this$1.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.77.1
 * JD-Core Version:    0.7.0.1
 */