package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import lnp;

public class GalleryProteusItem$1
  implements Runnable
{
  public GalleryProteusItem$1(lnp paramlnp, View paramView, NativeTextImp paramNativeTextImp) {}
  
  public void run()
  {
    int i = this.val$view.getWidth();
    if (i > 0) {
      this.a.setMaxWidth(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.GalleryProteusItem.1
 * JD-Core Version:    0.7.0.1
 */