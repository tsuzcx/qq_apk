package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import nqv;

class CropImageView$2
  implements Runnable
{
  CropImageView$2(CropImageView paramCropImageView, boolean paramBoolean, nqv paramnqv, String paramString) {}
  
  public void run()
  {
    if (this.val$success)
    {
      this.a.nI(this.val$outPath);
      return;
    }
    this.a.aPQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView.2
 * JD-Core Version:    0.7.0.1
 */