package com.tencent.qqmail.accountlist.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.util.List;

class AddFolderAccountListActivity$2
  extends ArrayAdapter<Account>
{
  AddFolderAccountListActivity$2(AddFolderAccountListActivity paramAddFolderAccountListActivity, Context paramContext, int paramInt1, int paramInt2, List paramList)
  {
    super(paramContext, paramInt1, paramInt2, paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = (ViewGroup)super.getView(paramInt, paramView, paramViewGroup);
    ((TextView)localViewGroup.findViewById(2131367376)).setText(((Account)getItem(paramInt)).getEmail());
    ((ImageView)localViewGroup.findViewById(2131367367)).setVisibility(8);
    if ((getCount() == 1) || (paramInt == 0)) {
      QMUIHelper.setBackgroundResource(localViewGroup, 2130845610);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localViewGroup;
      QMUIHelper.setBackgroundResource(localViewGroup, 2130845603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AddFolderAccountListActivity.2
 * JD-Core Version:    0.7.0.1
 */