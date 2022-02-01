package com.tencent.qqmail.accountlist.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment;
import com.tencent.qqmail.attachment.activity.AttachFolderListFragment;
import com.tencent.qqmail.bottle.fragment.BottleFragmentActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.fragment.CardFragmentActivity;
import com.tencent.qqmail.folderlist.AppFolderListFragment;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.sendmaillist.SendMailListFragment;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.fragment.base.BaseFragment;
import rx.Observable;

class AccountListFragment$26
  implements AdapterView.OnItemClickListener
{
  AccountListFragment$26(AccountListFragment paramAccountListFragment) {}
  
  @SuppressLint({"ShowToast"})
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (AccountListUI)AccountListFragment.access$1200(this.this$0).getItemAtPosition(paramInt);
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      paramView.setSelected(true);
      QMLog.log(4, "AccountListFragment", "account list on item click itemDate type:" + ((AccountListUI)localObject).mType);
      if (((AccountListUI)localObject).mType == AccountListUI.ITEMTYPE.ITEM)
      {
        int i = ((AccountListUI)localObject).mFolder.getId();
        int j = ((AccountListUI)localObject).mFolder.getAccountId();
        int k = ((AccountListUI)localObject).mFolder.getType();
        QMLog.log(4, "AccountListFragment", "account list on item click folderId:" + i + ",type:" + k);
        if (i == -5)
        {
          DataCollector.logEvent("Event_Click_Ftn_Box");
          localObject = FtnListActivity.createIntent();
          this.this$0.startActivityForResult((Intent)localObject, 9);
        }
        else if (i == -4)
        {
          if (FolderLockDialog.isFolderLock(i))
          {
            if (AccountListFragment.access$2500(this.this$0) != null) {
              AccountListFragment.access$2500(this.this$0).dismissTips();
            }
            localObject = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
            if ((localObject != null) && (this.this$0.getActivity() != null))
            {
              this.this$0.mIsGoingToComposeNote = false;
              AccountListFragment.access$2502(this.this$0, new FolderLockDialog(this.this$0.getActivity(), i, ((QQMailAccount)localObject).getId(), this.this$0.mUnlockFolderPwd));
              AccountListFragment.access$2500(this.this$0).createDialog(1);
              AccountListFragment.access$2500(this.this$0).showDialog();
            }
          }
          else
          {
            DataCollector.logEvent("Event_Click_Note_Box");
            localObject = NoteListActivity.createIntent();
            this.this$0.startActivity((Intent)localObject);
          }
        }
        else if (i == -18)
        {
          QMCalendarManager.logEvent("Event_Click_Calendar");
          if (QMCalendarManager.getInstance().isShowSystemCalendar())
          {
            RxPermissions.getInstance(this.this$0.getActivity()).request(new String[] { "android.permission.WRITE_CALENDAR" }).subscribe(new AccountListFragment.26.1(this));
          }
          else
          {
            localObject = CalendarFragmentActivity.createIntent();
            this.this$0.startActivity((Intent)localObject);
          }
        }
        else if (i == -19)
        {
          DataCollector.logEvent("Event_Click_Attach_Box");
          localObject = new AttachFolderListFragment(j, i);
          this.this$0.startFragment((BaseFragment)localObject);
        }
        else if (i == -10)
        {
          localObject = new SendMailListFragment();
          this.this$0.startFragment((BaseFragment)localObject);
        }
        else if (i == -3)
        {
          DataCollector.logEvent("Event_Click_Vip_Box");
          if (!QMMailManager.sharedInstance().hasVip())
          {
            localObject = new VIPContactsIndexFragment(j, false);
            this.this$0.startFragment((BaseFragment)localObject);
          }
          else
          {
            AccountListFragment.access$2800(this.this$0, i, j);
          }
        }
        else if (i == -16)
        {
          localObject = BottleFragmentActivity.createIntent();
          this.this$0.startActivity((Intent)localObject);
        }
        else if (i == -23)
        {
          localObject = CardFragmentActivity.createIntentToGallery(QMCardManager.shareInstance().getJumpCardDefaulType(), false);
          this.this$0.startActivity((Intent)localObject);
          DataCollector.logEvent("Event_Card_Click_Card_Item");
        }
        else if (k == 130)
        {
          localObject = PopularizeManager.sharedInstance().getPopularizeById(i);
          if ((localObject != null) && (((Popularize)localObject).getOpenUrl() != null)) {
            PopularizeUIHelper.handleActionAndGotoLink(this.this$0.getActivity(), (Popularize)localObject);
          } else {
            QMLog.log(6, "AccountListFragment", "folderList getPopularizeItemData null");
          }
        }
        else if (k == 140)
        {
          PopularizeUIHelper.handleMyAppAction();
          localObject = new AppFolderListFragment();
          this.this$0.startFragment((BaseFragment)localObject);
        }
        else if (i == -22)
        {
          localObject = ContactsFragmentActivity.createContactsListIntent();
          this.this$0.startActivity((Intent)localObject);
        }
        else if (FolderLockDialog.isFolderLock(i))
        {
          if (QMFolderManager.sharedInstance().getFolder(i) != null)
          {
            if (AccountListFragment.access$2500(this.this$0) != null) {
              AccountListFragment.access$2500(this.this$0).dismissTips();
            }
            AccountListFragment.access$2502(this.this$0, new FolderLockDialog(this.this$0.getActivity(), i, j, this.this$0.mUnlockFolderPwd));
            AccountListFragment.access$2500(this.this$0).createDialog(1);
            AccountListFragment.access$2500(this.this$0).showDialog();
          }
        }
        else
        {
          DataCollector.logPerformanceBegin("Performance_Click_Maillist", j, "Performance_Click_Maillist" + j);
          if (((AccountListUI)localObject).mFolder.getId() == -1) {
            DataCollector.logEvent("Event_Click_All_Inbox");
          }
          for (;;)
          {
            AccountListFragment.access$2800(this.this$0, i, j);
            break;
            if (((AccountListUI)localObject).mFolder.getType() == 1) {
              DataCollector.logEvent("Event_Click_Inbox");
            }
          }
        }
      }
      else if (((AccountListUI)localObject).mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT)
      {
        if ("-1".equals(((AccountListUI)localObject).mAccount.getPwd()))
        {
          String str = ((AccountListUI)localObject).mAccount.getEmail();
          AccountType localAccountType = AccountType.domainOf(str);
          switch (AccountListFragment.41.$SwitchMap$com$tencent$qqmail$account$model$AccountType[localAccountType.ordinal()])
          {
          default: 
            localObject = LoginFragmentActivity.createIntentToAddAccount(localAccountType.name(), str);
          }
          for (;;)
          {
            this.this$0.startActivity((Intent)localObject);
            break;
            localObject = LoginFragmentActivity.createIntentForVerifyPswError(((AccountListUI)localObject).mAccount.getId(), ((AccountListUI)localObject).mAccount.getEmail());
            this.this$0.startActivity((Intent)localObject);
          }
        }
        AccountListFragment.access$2900(this.this$0, ((AccountListUI)localObject).mAccount.getId());
      }
      else if ((((AccountListUI)localObject).mType == AccountListUI.ITEMTYPE.BTN) && (((AccountListUI)localObject).mFolder == null))
      {
        this.this$0.launchAddAccount();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.26
 * JD-Core Version:    0.7.0.1
 */