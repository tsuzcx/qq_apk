package com.tencent.qqmail.namelist.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import moai.fragment.app.FragmentActivity;

class NameListAddFragment$7
  implements View.OnClickListener
{
  NameListAddFragment$7(NameListAddFragment paramNameListAddFragment) {}
  
  public void onClick(View paramView)
  {
    NameListAddFragment.access$502(this.this$0, true);
    Intent localIntent = ContactsFragmentActivity.createIntentToBlackWhiteNameListChoose(NameListAddFragment.access$600(this.this$0), NameListAddFragment.access$700(this.this$0), NameListAddFragment.access$500(this.this$0));
    this.this$0.startActivityForResult(localIntent, 0);
    this.this$0.getActivity().overridePendingTransition(2130772401, 2130772430);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAddFragment.7
 * JD-Core Version:    0.7.0.1
 */