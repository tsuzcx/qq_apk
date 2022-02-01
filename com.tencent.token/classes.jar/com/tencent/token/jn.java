package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public final class jn
  extends Resources
{
  private final WeakReference<Context> a;
  
  public jn(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.a = new WeakReference(paramContext);
  }
  
  public static boolean a()
  {
    return (gi.l()) && (Build.VERSION.SDK_INT <= 20);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)this.a.get();
    if (localContext != null)
    {
      ik localik = ik.a();
      Drawable localDrawable2 = localik.a(localContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = super.getDrawable(paramInt);
      }
      if (localDrawable1 != null) {
        return localik.a(localContext, paramInt, false, localDrawable1);
      }
      return null;
    }
    return super.getDrawable(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jn
 * JD-Core Version:    0.7.0.1
 */