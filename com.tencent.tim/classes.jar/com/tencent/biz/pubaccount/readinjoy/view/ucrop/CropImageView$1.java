package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import aoiz;
import aoop;
import java.io.File;
import nqv;
import nqy;
import rop;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, nqy paramnqy, Bitmap.CompressFormat paramCompressFormat, int paramInt, nqv paramnqv) {}
  
  public void run()
  {
    boolean bool = true;
    Bitmap localBitmap = rop.a(this.ck, this.jdField_a_of_type_Nqy.d(), this.jdField_a_of_type_Nqy.e(), this.jdField_a_of_type_Nqy.ao());
    int i;
    String str;
    if (localBitmap != null)
    {
      i = 1;
      str = aoop.aW + File.separator + aoiz.getFileName(new StringBuilder().append("CropImageView").append(System.currentTimeMillis()).toString());
      if ((i == 0) || (!rop.a(localBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat, this.bbh, str))) {
        break label144;
      }
    }
    for (;;)
    {
      CropImageView.a(this.this$0, str, bool, this.jdField_a_of_type_Nqv);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      return;
      i = 0;
      break;
      label144:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */