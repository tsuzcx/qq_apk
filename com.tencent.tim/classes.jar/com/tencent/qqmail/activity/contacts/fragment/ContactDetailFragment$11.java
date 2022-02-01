package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;

class ContactDetailFragment$11
  implements View.OnClickListener
{
  ContactDetailFragment$11(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Contact_AddTo_Normal");
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
    localBottomListSheetBuilder.addItem(this.this$0.getString(2131692000));
    localBottomListSheetBuilder.addItem(this.this$0.getString(2131692008));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ContactDetailFragment.11.1(this));
    localBottomListSheetBuilder.build().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.11
 * JD-Core Version:    0.7.0.1
 */