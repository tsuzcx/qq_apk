package com.tencent.qqmail.card.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.compose.ComposeContactsActivity;

class CardPopChooseFragment$3
  implements View.OnClickListener
{
  CardPopChooseFragment$3(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.getActivity(), ComposeContactsActivity.class);
    this.this$0.startActivityForResult(localIntent, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.3
 * JD-Core Version:    0.7.0.1
 */