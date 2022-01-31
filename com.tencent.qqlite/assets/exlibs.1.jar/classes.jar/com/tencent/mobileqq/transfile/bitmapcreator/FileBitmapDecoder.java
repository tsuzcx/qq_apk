package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.ImageUtil;

public class FileBitmapDecoder
{
  public Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (paramInt3 == 0) {
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
      }
    }
    for (localOptions.inSampleSize = ImageUtil.b(localOptions, paramInt1, paramInt2);; localOptions.inSampleSize = paramInt3)
    {
      localOptions.inJustDecodeBounds = false;
      return BitmapFactory.decodeFile(paramString, localOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.FileBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */