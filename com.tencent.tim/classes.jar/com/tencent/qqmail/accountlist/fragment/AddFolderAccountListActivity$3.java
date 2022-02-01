package com.tencent.qqmail.accountlist.fragment;

import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class AddFolderAccountListActivity$3
  implements AdapterView.OnItemClickListener
{
  AddFolderAccountListActivity$3(AddFolderAccountListActivity paramAddFolderAccountListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = FolderChoserActivity.createIntent((ArrayList)((Pair)AddFolderAccountListActivity.access$000(this.this$0).get(paramInt)).second);
    this.this$0.startActivityForResult(localIntent, 1);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AddFolderAccountListActivity.3
 * JD-Core Version:    0.7.0.1
 */