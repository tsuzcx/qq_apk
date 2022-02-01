package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NameListMainFragment$11
  implements View.OnClickListener
{
  NameListMainFragment$11(NameListMainFragment paramNameListMainFragment) {}
  
  public void onClick(View paramView)
  {
    if (NameListMainFragment.access$400(this.this$0)) {
      NameListMainFragment.access$700(this.this$0, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.11
 * JD-Core Version:    0.7.0.1
 */