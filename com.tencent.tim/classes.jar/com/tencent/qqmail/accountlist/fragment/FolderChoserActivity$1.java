package com.tencent.qqmail.accountlist.fragment;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.List;

class FolderChoserActivity$1
  extends ArrayAdapter<Pair<QMFolder, boolean[]>>
{
  FolderChoserActivity$1(FolderChoserActivity paramFolderChoserActivity, Context paramContext, int paramInt1, int paramInt2, List paramList)
  {
    super(paramContext, paramInt1, paramInt2, paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = (ViewGroup)super.getView(paramInt, paramView, paramViewGroup);
    if (localViewGroup != null)
    {
      if ((localViewGroup instanceof KeepPressedRelativeLayout)) {
        ((KeepPressedRelativeLayout)localViewGroup).setNeedPostPress(false);
      }
      localViewGroup.findViewById(2131367364).setVisibility(8);
      localViewGroup.findViewById(2131367367).setVisibility(8);
      Pair localPair = (Pair)getItem(paramInt);
      ((TextView)localViewGroup.findViewById(2131367376)).setText(((QMFolder)localPair.first).getName());
      CheckBox localCheckBox = (CheckBox)localViewGroup.findViewById(2131367365);
      localCheckBox.setVisibility(0);
      localCheckBox.setChecked(((boolean[])localPair.second)[0]);
      if ((getCount() != 1) && (paramInt != 0)) {
        break label162;
      }
      QMUIHelper.setBackgroundResource(localViewGroup, 2130845610);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localViewGroup;
      label162:
      QMUIHelper.setBackgroundResource(localViewGroup, 2130845603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.FolderChoserActivity.1
 * JD-Core Version:    0.7.0.1
 */