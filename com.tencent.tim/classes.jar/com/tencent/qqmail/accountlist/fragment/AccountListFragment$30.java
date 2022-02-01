package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.mobeta.android.dslv.DragSortListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.accountlist.adapter.AccountListDragAdapter;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class AccountListFragment$30
  implements AdapterView.OnItemClickListener
{
  AccountListFragment$30(AccountListFragment paramAccountListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    paramInt -= AccountListFragment.access$1600(this.this$0).getHeaderViewsCount();
    Object localObject1 = AccountListFragment.access$3400(this.this$0).getItemAtIndex(paramInt);
    if (((AccountListUI)localObject1).mType == AccountListUI.ITEMTYPE.BTN)
    {
      QMAccountHelper.saveAccountAndFolderToConfig(AccountListFragment.access$3500(this.this$0), AccountListFragment.access$1100(this.this$0));
      if (((AccountListUI)localObject1).mSectionName.equals(this.this$0.getString(2131689644))) {
        AccountListFragment.access$3600(this.this$0);
      }
    }
    Object localObject2;
    do
    {
      do
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
      } while ((((AccountListUI)localObject1).mType != AccountListUI.ITEMTYPE.ITEM) || (((AccountListUI)localObject1).mData == null));
      localObject1 = new ArrayList();
      localObject2 = AccountListFragment.access$3500(this.this$0).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AccountListUI localAccountListUI = (AccountListUI)((Iterator)localObject2).next();
        if ((localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM) && (localAccountListUI.mData.isShouldShow()) && (!QMFolderManager.isAppFolder(localAccountListUI.mFolder))) {
          ((ArrayList)localObject1).add(Integer.valueOf(localAccountListUI.mData.getFolderId()));
        }
      }
      localObject2 = (AccountListUI)AccountListFragment.access$3500(this.this$0).get(paramInt);
    } while ((((ArrayList)localObject1).size() == 1) && (((Integer)((ArrayList)localObject1).get(0)).intValue() == ((AccountListUI)localObject2).mData.getFolderId()));
    localObject1 = new StringBuilder().append("AccountList edit onclick  id : ").append(((AccountListUI)localObject2).mData.getFolderId()).append(" folder: ").append(((AccountListUI)localObject2).mData.getName()).append(" should show: ");
    boolean bool1;
    if (!((AccountListUI)localObject2).mData.isShouldShow())
    {
      bool1 = true;
      label324:
      QMLog.log(4, "AccountListFragment", bool1 + ", pos: " + paramInt);
      if (!AccountListFragment.access$3700(this.this$0).containsKey(Integer.valueOf(((AccountListUI)localObject2).mData.getId()))) {
        AccountListFragment.access$3700(this.this$0).put(Integer.valueOf(((AccountListUI)localObject2).mData.getId()), Boolean.valueOf(((AccountListUI)localObject2).mData.isShouldShow()));
      }
      localObject1 = ((AccountListUI)localObject2).mData;
      bool1 = bool2;
      if (!((AccountListUI)localObject2).mData.isShouldShow()) {
        bool1 = true;
      }
      ((FolderData)localObject1).setShouldShow(bool1);
      if (((AccountListUI)localObject2).mData.getFolderId() == -19)
      {
        if (!((AccountListUI)localObject2).mData.isShouldShow()) {
          break label527;
        }
        QMSettingManager.sharedInstance().setStarAttachDisplay(1);
        AccountListFragment.access$3808(this.this$0);
      }
      label477:
      if (((AccountListUI)localObject2).mData.getFolderId() == -3)
      {
        if (!((AccountListUI)localObject2).mData.isShouldShow()) {
          break label545;
        }
        QMSettingManager.sharedInstance().setAddrVipDisplay(1);
      }
    }
    for (;;)
    {
      AccountListFragment.access$3400(this.this$0).notifyDataSetChanged();
      break;
      bool1 = false;
      break label324;
      label527:
      QMSettingManager.sharedInstance().setStarAttachDisplay(2);
      AccountListFragment.access$3810(this.this$0);
      break label477;
      label545:
      QMSettingManager.sharedInstance().setAddrVipDisplay(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.30
 * JD-Core Version:    0.7.0.1
 */