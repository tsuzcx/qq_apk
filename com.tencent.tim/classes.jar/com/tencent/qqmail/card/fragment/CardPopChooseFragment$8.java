package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CardPopChooseFragment$8
  implements View.OnClickListener
{
  CardPopChooseFragment$8(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    boolean bool;
    if (!CardPopChooseFragment.access$1200(this.this$0))
    {
      bool = true;
      CardPopChooseFragment.access$1202((CardPopChooseFragment)localObject, bool);
      localObject = CardPopChooseFragment.access$1300(this.this$0);
      if (!CardPopChooseFragment.access$1200(this.this$0)) {
        break label87;
      }
    }
    label87:
    for (int i = 2131691271;; i = 2131691273)
    {
      ((TextView)localObject).setText(i);
      this.this$0.rotateArrow(CardPopChooseFragment.access$1200(this.this$0));
      CardPopChooseFragment.access$1400(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.8
 * JD-Core Version:    0.7.0.1
 */