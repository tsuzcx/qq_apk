package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class jv
  extends jo
{
  private final WeakReference<Context> a;
  
  public jv(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    this.a = new WeakReference(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.a.get();
    if ((localDrawable != null) && (localContext != null))
    {
      iy.a();
      iy.a(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jv
 * JD-Core Version:    0.7.0.1
 */