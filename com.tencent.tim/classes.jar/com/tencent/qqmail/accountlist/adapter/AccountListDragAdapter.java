package com.tencent.qqmail.accountlist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.view.PopularizeFolderSubItems;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.List;

public class AccountListDragAdapter
  extends AccountBaseAdapter
  implements DragSortListView.DropListener
{
  private static final String TAG = AccountListDragAdapter.class.getSimpleName();
  private DataChangeListener mDataChangeListener;
  
  public AccountListDragAdapter(Context paramContext, List<AccountListUI> paramList)
  {
    super(paramContext, paramList);
  }
  
  public void drop(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      AccountListUI localAccountListUI = (AccountListUI)this.mData.remove(paramInt1);
      this.mData.add(paramInt2, localAccountListUI);
      if (this.mDataChangeListener != null) {
        this.mDataChangeListener.onDataChange(this.mData, paramInt1, paramInt2);
      }
      notifyDataSetChanged();
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    int j = getItemViewType(paramInt);
    if (j == 0)
    {
      Log.v(TAG, "itemViewType: " + j);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    ((KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView()).setNeedPostPress(false);
    AccountListUI localAccountListUI = getItemAtIndex(paramInt);
    int i;
    label109:
    AccountBaseAdapter.ViewHolder localViewHolder;
    if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 130))
    {
      i = 1;
      localViewHolder = (AccountBaseAdapter.ViewHolder)paramView.getTag();
      if (localAccountListUI.mType != AccountListUI.ITEMTYPE.BTN) {
        break label212;
      }
      localViewHolder.checkbox.setVisibility(4);
      localViewHolder.handler.setVisibility(8);
      localViewHolder.arrow.setVisibility(8);
    }
    for (;;)
    {
      if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 1)) {
        localViewHolder.subitems.setVisibility(8);
      }
      if (i == 0) {
        localViewHolder.itemUnread.setVisibility(8);
      }
      break;
      i = 0;
      break label109;
      label212:
      if ((localAccountListUI.mFolder != null) && ((QMFolderManager.isAppFolder(localAccountListUI.mFolder)) || (localAccountListUI.mFolder.getId() == -20) || (localAccountListUI.mFolder.getId() == -10)))
      {
        if (localAccountListUI.mFolder.getId() == -20) {
          localViewHolder.handler.setVisibility(8);
        }
        for (;;)
        {
          localViewHolder.checkbox.setVisibility(8);
          localViewHolder.arrow.setVisibility(8);
          break;
          localViewHolder.handler.setVisibility(0);
        }
      }
      switch (j)
      {
      }
      for (;;)
      {
        if (localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM_ACCOUNT) {
          break label411;
        }
        localViewHolder.checkbox.setVisibility(8);
        localViewHolder.handler.setVisibility(0);
        localViewHolder.arrow.setVisibility(8);
        break;
        QMUIHelper.setBackgroundResource(paramView, 2131166586);
        continue;
        QMUIHelper.setBackgroundResource(paramView, 2131166586);
      }
      label411:
      if (localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM)
      {
        localViewHolder.checkbox.setVisibility(0);
        localViewHolder.checkbox.setChecked(localAccountListUI.mData.isShouldShow());
        localViewHolder.handler.setVisibility(0);
        localViewHolder.arrow.setVisibility(8);
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AccountListUI localAccountListUI = getItemAtIndex(paramInt);
    AccountListUI.ITEMTYPE localITEMTYPE = localAccountListUI.mType;
    if ((localITEMTYPE == AccountListUI.ITEMTYPE.BTN) && (localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getId() == -10)) {}
    while (((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 140)) || (localITEMTYPE == AccountListUI.ITEMTYPE.SECTION)) {
      return false;
    }
    return true;
  }
  
  public void setDataChangeListener(DataChangeListener paramDataChangeListener)
  {
    this.mDataChangeListener = paramDataChangeListener;
  }
  
  public static abstract interface DataChangeListener
  {
    public abstract void onDataChange(List<? extends Object> paramList, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.adapter.AccountListDragAdapter
 * JD-Core Version:    0.7.0.1
 */