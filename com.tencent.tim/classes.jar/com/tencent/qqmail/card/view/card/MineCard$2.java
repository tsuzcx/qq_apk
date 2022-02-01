package com.tencent.qqmail.card.view.card;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class MineCard$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  MineCard$2(MineCard paramMineCard, Bitmap paramBitmap) {}
  
  public void onGlobalLayout()
  {
    Log.v("MineCard", "GlobalLayoutListener: " + this.this$0.hashCode());
    if (Build.VERSION.SDK_INT >= 16) {
      this.this$0.mCardCoverView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      if (this.this$0.mCardCoverView.getWidth() >= 0) {
        MineCard.access$000(this.this$0, this.val$bitmap.getWidth(), this.val$bitmap.getHeight());
      }
      return;
      this.this$0.mCardCoverView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.card.MineCard.2
 * JD-Core Version:    0.7.0.1
 */