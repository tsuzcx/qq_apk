package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NameListAccountListFragment$1
  implements View.OnClickListener
{
  NameListAccountListFragment$1(NameListAccountListFragment paramNameListAccountListFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAccountListFragment.1
 * JD-Core Version:    0.7.0.1
 */