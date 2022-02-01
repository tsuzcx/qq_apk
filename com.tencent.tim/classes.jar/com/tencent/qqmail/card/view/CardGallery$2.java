package com.tencent.qqmail.card.view;

import android.view.View;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAbsSpinner.RecyclerListener;

class CardGallery$2
  implements EcoGalleryAbsSpinner.RecyclerListener
{
  CardGallery$2(CardGallery paramCardGallery) {}
  
  public void onMovedToScrapHeap(View paramView)
  {
    if ((paramView instanceof Recyclable)) {
      ((Recyclable)paramView).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardGallery.2
 * JD-Core Version:    0.7.0.1
 */