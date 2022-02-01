package com.tencent.gdtad.views.image;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;
import java.net.URL;
import tkw;
import tmi;
import tmi.a;

public class GdtGifImageView
  extends URLImageView
{
  private boolean aPw;
  tmi.a b;
  tmi.a c;
  private WeakReference<b> dD;
  private String guassianUrl;
  private String imgUrl;
  
  public GdtGifImageView(Context paramContext, String paramString1, String paramString2, WeakReference<b> paramWeakReference)
  {
    super(paramContext);
    this.dD = paramWeakReference;
    this.aPw = false;
    this.imgUrl = paramString1;
    this.guassianUrl = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.b = new a();
      new tmi(paramString2, new WeakReference(this.b)).load();
    }
    this.c = new a();
    paramContext = new tmi(paramString1, new WeakReference(this.c));
    paramContext.load();
    setImageDrawable(paramContext.a());
    URLDrawable.resume();
    AbstractGifImage.resumeAll();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.imgUrl)) && (paramString.equals(this.imgUrl)))
    {
      this.aPw = true;
      setImageDrawable(paramURLDrawable);
    }
    while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.guassianUrl)) || (!paramString.equals(this.guassianUrl)) || (this.aPw)) {
      return;
    }
    setImageDrawable(paramURLDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  class a
    implements tmi.a
  {
    a() {}
    
    public void e(URLDrawable paramURLDrawable)
    {
      if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
      for (String str = paramURLDrawable.getURL().toString();; str = null)
      {
        tkw.i("GdtImageView", String.format("onLoadSuccessful %s", new Object[] { str }));
        GdtGifImageView.a(GdtGifImageView.this, paramURLDrawable, str);
        if ((GdtGifImageView.a(GdtGifImageView.this) != null) && (GdtGifImageView.a(GdtGifImageView.this).get() != null) && (GdtGifImageView.a(GdtGifImageView.this))) {
          ((GdtGifImageView.b)GdtGifImageView.a(GdtGifImageView.this).get()).onStopLoad(true);
        }
        return;
      }
    }
    
    public void f(URLDrawable paramURLDrawable)
    {
      if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
      for (String str = paramURLDrawable.getURL().toString();; str = null)
      {
        tkw.i("GdtImageView", String.format("onLoadFailed %s", new Object[] { str }));
        GdtGifImageView.a(GdtGifImageView.this, paramURLDrawable, str);
        if ((GdtGifImageView.a(GdtGifImageView.this) != null) && (GdtGifImageView.a(GdtGifImageView.this).get() != null)) {
          ((GdtGifImageView.b)GdtGifImageView.a(GdtGifImageView.this).get()).onStopLoad(false);
        }
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onStopLoad(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView
 * JD-Core Version:    0.7.0.1
 */