package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class CardBirthdayPreviewFragment$3
  implements View.OnClickListener
{
  CardBirthdayPreviewFragment$3(CardBirthdayPreviewFragment paramCardBirthdayPreviewFragment, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ((ImageView)CardBirthdayPreviewFragment.access$100(this.this$0).get(CardBirthdayPreviewFragment.access$000(this.this$0))).setSelected(false);
    this.val$imageView.setSelected(true);
    CardBirthdayPreviewFragment.access$002(this.this$0, CardBirthdayPreviewFragment.access$100(this.this$0).indexOf(this.val$imageView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */