package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NameListMainFragment$3
  implements View.OnClickListener
{
  NameListMainFragment$3(NameListMainFragment paramNameListMainFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.3
 * JD-Core Version:    0.7.0.1
 */