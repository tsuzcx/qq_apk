package com.tencent.qqmail.card.fragment;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.model.QMCardData;

class CardPreviewFragment$7
  implements View.OnClickListener
{
  CardPreviewFragment$7(CardPreviewFragment paramCardPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    Log.e("cyz", "card " + CardPreviewFragment.access$100(this.this$0).getName() + " " + CardPreviewFragment.access$100(this.this$0).getSeqType() + " " + CardPreviewFragment.access$100(this.this$0).getFriendNum() + " " + CardPreviewFragment.access$100(this.this$0).getFriendType() + " " + CardPreviewFragment.access$100(this.this$0).getPageType());
    if (CardPreviewFragment.access$100(this.this$0).getPageType() == 1) {
      CardPreviewFragment.access$1900(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      CardPreviewFragment.access$2000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */