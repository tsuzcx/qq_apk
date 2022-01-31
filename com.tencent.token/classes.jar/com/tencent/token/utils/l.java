package com.tencent.token.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.token.do;
import java.util.Map;

class l
  extends UserTask
{
  l(k paramk, String paramString1, String paramString2) {}
  
  public Bitmap a(String... paramVarArgs)
  {
    paramVarArgs = do.a().a(this.a, null);
    Bitmap localBitmap = do.a().a(paramVarArgs);
    if (localBitmap != null)
    {
      k.c.b(this.b, localBitmap);
      String str = k.c.c(this.b);
      if (k.c.a(str, localBitmap)) {
        k.c(this.b, paramVarArgs);
      }
    }
    return localBitmap;
  }
  
  public void a(Bitmap paramBitmap)
  {
    k localk = (k)k.d.remove(this.a);
    if ((paramBitmap == null) || (localk == null)) {
      return;
    }
    paramBitmap = new BitmapDrawable(paramBitmap);
    paramBitmap.setBounds(k.a(localk).getBounds());
    k.a(localk, paramBitmap);
    localk.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.l
 * JD-Core Version:    0.7.0.1
 */