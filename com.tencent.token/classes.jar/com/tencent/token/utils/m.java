package com.tencent.token.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.token.do;
import java.util.Map;

class m
  extends UserTask
{
  m(k paramk, String paramString1, String paramString2, String paramString3) {}
  
  public Bitmap a(String... paramVarArgs)
  {
    paramVarArgs = null;
    String str1 = do.a().a(this.a, null);
    if ((str1 != null) && (str1.equals(this.b))) {}
    Bitmap localBitmap;
    String str2;
    do
    {
      do
      {
        return paramVarArgs;
        localBitmap = do.a().a(str1);
        paramVarArgs = localBitmap;
      } while (localBitmap == null);
      k.c.b(this.c, localBitmap);
      str2 = k.c.c(this.c);
      paramVarArgs = localBitmap;
    } while (!k.c.a(str2, localBitmap));
    k.c(this.c, str1);
    return localBitmap;
  }
  
  public void a(Bitmap paramBitmap)
  {
    k.e.remove(this.c);
    k localk = (k)k.d.remove(this.a);
    if (localk == null) {}
    while (paramBitmap == null) {
      return;
    }
    paramBitmap = new BitmapDrawable(paramBitmap);
    paramBitmap.setBounds(k.a(localk).getBounds());
    k.a(localk, paramBitmap);
    localk.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.m
 * JD-Core Version:    0.7.0.1
 */