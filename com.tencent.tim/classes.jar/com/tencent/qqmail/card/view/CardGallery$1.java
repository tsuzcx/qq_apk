package com.tencent.qqmail.card.view;

import android.util.Log;
import android.view.View;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAdapterView;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAdapterView.OnItemClickListener;

class CardGallery$1
  implements EcoGalleryAdapterView.OnItemClickListener
{
  CardGallery$1(CardGallery paramCardGallery) {}
  
  public void onItemClick(EcoGalleryAdapterView<?> paramEcoGalleryAdapterView, View paramView, int paramInt, long paramLong)
  {
    Log.i("CardGallery", "CardGallery itemClick: " + paramInt + ", id: " + paramLong);
    if ((this.this$0.checkClickTremble()) || (this.this$0.getSelectedItemPosition() != paramInt)) {}
    while (CardGallery.access$000(this.this$0) == null) {
      return;
    }
    CardGallery.access$000(this.this$0).onClickGoPreview(CardGallery.access$100(this.this$0).getItem(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardGallery.1
 * JD-Core Version:    0.7.0.1
 */