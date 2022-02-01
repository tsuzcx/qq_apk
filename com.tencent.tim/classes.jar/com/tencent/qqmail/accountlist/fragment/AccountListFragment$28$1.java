package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import moai.oss.KvHelper;

class AccountListFragment$28$1
  implements Runnable
{
  AccountListFragment$28$1(AccountListFragment.28 param28, int paramInt) {}
  
  public void run()
  {
    AccountListUI localAccountListUI = AccountListFragment.access$300(this.this$1.this$0).getItemAtIndex(this.val$position);
    if (localAccountListUI == null) {}
    label100:
    do
    {
      do
      {
        do
        {
          return;
        } while (!AccountListFragment.access$300(this.this$1.this$0).canRightScroll(this.val$position));
        if (localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT)
        {
          if (localAccountListUI.accUnreadCount > 0)
          {
            DataCollector.logEvent("Event_Account_Slide_Mark_Read_When_Unread");
            return;
          }
          DataCollector.logEvent("Event_Account_Slide_Mark_Read");
          return;
        }
      } while (localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM);
      if (QMFolderManager.sharedInstance().getDisplayUnreadCount(localAccountListUI.mFolder) <= 0) {
        break;
      }
      DataCollector.logEvent("Event_Folder_Slide_Mark_Read_When_Unread");
    } while (localAccountListUI.mFolder == null);
    switch (localAccountListUI.mFolder.getId())
    {
    }
    for (;;)
    {
      if (localAccountListUI.mFolder.getType() == 130) {
        DataCollector.logEvent("Event_Popularize_Slide_Hide");
      }
      if (localAccountListUI.mData.isPersistence()) {
        break;
      }
      KvHelper.eventFolderSwipeNotShowMailBox(new double[0]);
      return;
      DataCollector.logEvent("Event_Folder_Slide_Mark_Read");
      break label100;
      DataCollector.logEvent("Event_Addressbook_Slide_Hide");
      continue;
      DataCollector.logEvent("Event_Bottle_Slide_Hide");
      continue;
      DataCollector.logEvent("Event_Calendar_Slide_Hide");
      continue;
      DataCollector.logEvent("Event_Ftn_Slide_Hide");
      continue;
      DataCollector.logEvent("Event_Note_Slide_Hide");
      continue;
      DataCollector.logEvent("Event_Card_Slip_Hide");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.28.1
 * JD-Core Version:    0.7.0.1
 */