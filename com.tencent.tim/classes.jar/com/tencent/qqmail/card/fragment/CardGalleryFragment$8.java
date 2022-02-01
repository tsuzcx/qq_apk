package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.card.view.CardGallery;
import com.tencent.qqmail.protocol.DataCollector;

class CardGalleryFragment$8
  implements View.OnClickListener
{
  CardGalleryFragment$8(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Card_Birthday_Button");
    CardUtil.setBirthdayCakeRedDot(false);
    CardGalleryFragment.access$2100(this.this$0).setVisibility(8);
    CardBirthdayChooseFragment localCardBirthdayChooseFragment = new CardBirthdayChooseFragment(CardGalleryFragment.access$400(this.this$0).getSelectedItem());
    this.this$0.startFragmentForResult(localCardBirthdayChooseFragment, CardGalleryFragment.BIRTHDAY_FRIEND_REQUEST_CODE);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.8
 * JD-Core Version:    0.7.0.1
 */