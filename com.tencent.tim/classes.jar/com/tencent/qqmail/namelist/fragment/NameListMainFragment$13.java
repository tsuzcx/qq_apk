package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NameListMainFragment$13
  implements View.OnClickListener
{
  NameListMainFragment$13(NameListMainFragment paramNameListMainFragment) {}
  
  public void onClick(View paramView)
  {
    NameListMainFragment.access$1302(this.this$0, false);
    NameListMainFragment.access$1402(this.this$0, false);
    NameListMainFragment.access$1700(this.this$0, new NameListMainFragment.13.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.13
 * JD-Core Version:    0.7.0.1
 */