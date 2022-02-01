package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;
import java.util.Arrays;
import java.util.List;
import moai.oss.KvHelper;

class AccountListFragment$29
  implements ItemScrollListView.OnRightViewClickListener
{
  AccountListFragment$29(AccountListFragment paramAccountListFragment) {}
  
  private void handleRightViewClickDelete(int paramInt)
  {
    AccountListUI localAccountListUI = AccountListFragment.access$300(this.this$0).getItemAtIndex(paramInt);
    int i = localAccountListUI.mFolder.getId();
    if (QMFolderManager.isAppFolder(localAccountListUI.mFolder))
    {
      QMLog.log(2, "AccountListFragment", "hide app folder:" + i);
      ListViewRemoveItemAnimator.animateRemoval(AccountListFragment.access$1200(this.this$0), Arrays.asList(new Integer[] { Integer.valueOf(paramInt) }), new AccountListFragment.29.3(this, localAccountListUI, i));
      switch (i)
      {
      default: 
        if (localAccountListUI.mFolder.getType() == 130) {
          DataCollector.logEvent("Event_Popularize_Click_Hide");
        }
        break;
      }
    }
    while ((localAccountListUI.mFolder.getType() != 5) && (localAccountListUI.mFolder.getType() != 6) && (localAccountListUI.mFolder.getId() != -12)) {
      for (;;)
      {
        return;
        DataCollector.logEvent("Event_Addressbook_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Bottle_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Calendar_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Ftn_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Note_Click_Hide");
      }
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131691517)).setMessage(2131697041).addAction(2131691246, new AccountListFragment.29.5(this))).addAction(0, 2131691839, 2, new AccountListFragment.29.4(this, localAccountListUI))).create().show();
  }
  
  private void handleRightViewClickRead(View paramView, int paramInt)
  {
    AccountListUI localAccountListUI1 = AccountListFragment.access$300(this.this$0).getItemAtIndex(paramInt);
    if (localAccountListUI1 == null) {
      QMLog.log(5, "AccountListFragment", "onRightViewClick data null");
    }
    int i;
    do
    {
      AccountListUI localAccountListUI2;
      do
      {
        return;
        localAccountListUI2 = AccountListFragment.access$300(this.this$0).getItemAtIndex(paramInt);
      } while ((localAccountListUI2.mFolder != null) && (localAccountListUI2.mFolder.getId() == -10));
      if (localAccountListUI1.mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT)
      {
        i = localAccountListUI1.mAccount.getId();
        QMLog.log(2, "AccountListFragment", "onRightViewClick, View id:" + paramView.getId() + ", position:" + paramInt + ", accountId:" + i);
        if (localAccountListUI1.accUnreadCount > 0) {
          DataCollector.logEvent("Event_Account_Mark_Read_When_Unread");
        }
        for (;;)
        {
          AccountListFragment.access$3100(this.this$0, new AccountListFragment.29.1(this, i));
          return;
          DataCollector.logEvent("Event_Account_Mark_Read");
        }
      }
    } while (localAccountListUI1.mType != AccountListUI.ITEMTYPE.ITEM);
    int j = localAccountListUI1.mFolder.getId();
    if (localAccountListUI1.mAccount == null)
    {
      i = 0;
      QMLog.log(2, "AccountListFragment", "onRightViewClick, View id:" + paramView.getId() + ", position:" + paramInt + ", accountId:" + i + ", folderId:" + j);
      if (QMFolderManager.sharedInstance().getDisplayUnreadCount(localAccountListUI1.mFolder) <= 0) {
        break label302;
      }
      DataCollector.logEvent("Event_Folder_Mark_Read_When_Unread");
    }
    for (;;)
    {
      AccountListFragment.access$3200(this.this$0, new AccountListFragment.29.2(this, i, j));
      return;
      i = localAccountListUI1.mAccount.getId();
      break;
      label302:
      DataCollector.logEvent("Event_Folder_Mark_Read");
    }
  }
  
  private void handleRightViewClickTop(int paramInt)
  {
    AccountListUI localAccountListUI = AccountListFragment.access$300(this.this$0).getItemAtIndex(paramInt);
    AccountListFragment.access$300(this.this$0).getData().remove(paramInt);
    AccountListFragment.access$300(this.this$0).notifyDataSetChanged();
    FolderDataManager.sharedInstance().deleteFolderDataById(localAccountListUI.mData);
    KvHelper.eventFolderSwipeNotShowMailBoxClick(new double[0]);
  }
  
  public void onRightViewClick(View paramView, int paramInt)
  {
    AccountListFragment.access$1200(this.this$0).reset();
    if ((paramView != null) && (paramView.getId() == 2131377336)) {
      handleRightViewClickRead(paramView, paramInt);
    }
    do
    {
      return;
      if ((paramView != null) && (paramView.getId() == 2131377335))
      {
        handleRightViewClickDelete(paramInt);
        return;
      }
    } while ((paramView == null) || (paramView.getId() != 2131377337));
    handleRightViewClickTop(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.29
 * JD-Core Version:    0.7.0.1
 */