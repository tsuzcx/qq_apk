package com.tencent.qqmail.card.fragment;

import android.util.Log;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.view.DragLoadMoreHelper;
import com.tencent.qqmail.card.view.Gallery.EcoGallery.OnScrollListener;
import java.util.HashMap;

class CardGalleryFragment$6
  implements EcoGallery.OnScrollListener
{
  CardGalleryFragment$6(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt1 = CardGalleryFragment.access$200(this.this$0).getCount();
    CardGalleryFragment.access$1800(this.this$0).onScroll(paramInt1, paramInt4, paramInt5);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    CardGalleryFragment.access$1800(this.this$0).onScrollStateChanged(paramInt);
  }
  
  public void onSelectedChanged(int paramInt1, int paramInt2)
  {
    if (CardGalleryFragment.access$1900(this.this$0) == null) {
      return;
    }
    Log.d("CardGalleryFragment", "selected pos: " + paramInt1 + ", type: " + CardGalleryFragment.access$000(this.this$0));
    CardGalleryFragment.access$600(this.this$0).put(Integer.valueOf(CardGalleryFragment.access$000(this.this$0)), Integer.valueOf(paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.6
 * JD-Core Version:    0.7.0.1
 */