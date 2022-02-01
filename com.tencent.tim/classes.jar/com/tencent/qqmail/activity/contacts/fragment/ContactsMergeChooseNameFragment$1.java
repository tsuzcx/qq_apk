package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;

class ContactsMergeChooseNameFragment$1
  implements AdapterView.OnItemClickListener
{
  ContactsMergeChooseNameFragment$1(ContactsMergeChooseNameFragment paramContactsMergeChooseNameFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ContactsMergeChooseNameFragment.access$002(this.this$0, paramInt);
    Arrays.fill(ContactsMergeChooseNameFragment.access$100(this.this$0), false);
    ContactsMergeChooseNameFragment.access$100(this.this$0)[paramInt] = 1;
    ContactsMergeChooseNameFragment.access$200(this.this$0).notifyDataSetChanged();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeChooseNameFragment.1
 * JD-Core Version:    0.7.0.1
 */