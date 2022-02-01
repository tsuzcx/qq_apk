package com.tencent.qqmail.accountlist.fragment;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FolderChoserActivity$2
  implements AdapterView.OnItemClickListener
{
  FolderChoserActivity$2(FolderChoserActivity paramFolderChoserActivity, ArrayAdapter paramArrayAdapter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367365);
    Pair localPair = (Pair)this.val$adapter.getItem(paramInt);
    boolean[] arrayOfBoolean = (boolean[])localPair.second;
    if (((boolean[])localPair.second)[0] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[0] = i;
      localCheckBox.setChecked(((boolean[])localPair.second)[0]);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.FolderChoserActivity.2
 * JD-Core Version:    0.7.0.1
 */