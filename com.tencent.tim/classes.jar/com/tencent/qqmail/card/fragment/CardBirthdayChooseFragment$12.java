package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CardBirthdayChooseFragment$12
  implements View.OnClickListener
{
  CardBirthdayChooseFragment$12(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    Object localObject;
    if (CardBirthdayChooseFragment.access$2000(this.this$0) != null)
    {
      boolean bool3 = CardBirthdayChooseFragment.access$2000(this.this$0).isExpanded();
      localObject = CardBirthdayChooseFragment.access$2000(this.this$0);
      if (bool3) {
        break label83;
      }
      bool1 = true;
      ((CardBirthdayChooseAdapter)localObject).setIsExpanded(bool1);
      localObject = this.this$0;
      if (bool3) {
        break label88;
      }
    }
    label83:
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((CardBirthdayChooseFragment)localObject).rotateArrow(bool1);
      CardBirthdayChooseFragment.access$2000(this.this$0).notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.12
 * JD-Core Version:    0.7.0.1
 */