package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.widget.RelativeLayout;

public class ReadInJoyDisLikeDialogViewForAd
  extends ReadInJoyDisLikeDialogView
{
  public ReadInJoyDisLikeDialogViewForAd(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void cj(Context paramContext)
  {
    super.cj(paramContext);
    this.H = Boolean.valueOf(false);
    if ((this.bU == null) || (this.fm != null)) {
      this.fm.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd
 * JD-Core Version:    0.7.0.1
 */