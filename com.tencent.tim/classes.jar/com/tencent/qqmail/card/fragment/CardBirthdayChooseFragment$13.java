package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;

class CardBirthdayChooseFragment$13
  implements View.OnClickListener
{
  CardBirthdayChooseFragment$13(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onClick(View paramView)
  {
    ImageView localImageView = CardBirthdayChooseFragment.access$2300(this.this$0);
    boolean bool;
    if (!CardBirthdayChooseFragment.access$2300(this.this$0).isSelected())
    {
      bool = true;
      localImageView.setSelected(bool);
      if (!CardBirthdayChooseFragment.access$2300(this.this$0).isSelected()) {
        break label67;
      }
      CardBirthdayChooseFragment.access$2100(this.this$0).setTitle(2131691890);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label67:
      CardBirthdayChooseFragment.access$2100(this.this$0).setTitle(2131691317);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.13
 * JD-Core Version:    0.7.0.1
 */