package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAdapterView;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAdapterView.OnItemLongClickListener;

class CardGalleryFragment$7
  implements EcoGalleryAdapterView.OnItemLongClickListener
{
  CardGalleryFragment$7(CardGalleryFragment paramCardGalleryFragment) {}
  
  public boolean onItemLongClick(EcoGalleryAdapterView<?> paramEcoGalleryAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((CardGalleryFragment.access$1600(this.this$0).getVisibility() == 0) || (CardGalleryFragment.access$000(this.this$0) != 1)) {
      return false;
    }
    paramView = paramEcoGalleryAdapterView.getSelectedView();
    paramLong = paramEcoGalleryAdapterView.getSelectedItemId();
    paramInt = paramEcoGalleryAdapterView.getSelectedItemPosition();
    CardGalleryFragment.access$2000(this.this$0, paramEcoGalleryAdapterView, paramView, paramInt, paramLong, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.7
 * JD-Core Version:    0.7.0.1
 */