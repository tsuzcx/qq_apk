package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qqmail.card.view.CardGallery;
import com.tencent.qqmail.card.view.CardTransitionView.TransitionListener;

class CardGalleryFragment$5
  implements CardTransitionView.TransitionListener
{
  CardGalleryFragment$5(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onScroll(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onTransitionComplete(boolean paramBoolean)
  {
    CardGalleryFragment.access$400(this.this$0).setOnTouchListener(null);
    if (!paramBoolean)
    {
      CardGalleryFragment.access$400(this.this$0).setVisibility(0);
      CardGalleryFragment.access$1600(this.this$0).post(new CardGalleryFragment.5.1(this));
    }
    CardGalleryFragment.access$1700(this.this$0, false, false);
  }
  
  public void onViewRemoved(long paramLong)
  {
    CardGalleryFragment.access$1500(this.this$0, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.5
 * JD-Core Version:    0.7.0.1
 */