package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.protocol.DataCollector;

class NameListMainFragment$4
  implements View.OnClickListener
{
  NameListMainFragment$4(NameListMainFragment paramNameListMainFragment) {}
  
  public void onClick(View paramView)
  {
    NameListAddFragment localNameListAddFragment = new NameListAddFragment(NameListMainFragment.access$000(this.this$0), NameListMainFragment.access$100(this.this$0));
    this.this$0.startFragmentForResult(localNameListAddFragment, 2);
    if (NameListMainFragment.access$100(this.this$0) == NameListContact.NameListContactType.WHITE.ordinal()) {
      DataCollector.logEvent("Event_Click_White_Name_List_Add_Button");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DataCollector.logEvent("Event_Click_Black_Name_List_Add_Button");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.4
 * JD-Core Version:    0.7.0.1
 */