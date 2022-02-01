package com.tencent.common.galleryactivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import sxm;
import sxu;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  private sxu a;
  sxm b;
  
  private sxu a(int paramInt)
  {
    if ((this.b != null) && (paramInt == this.b.getSelectedIndex())) {
      return this.a;
    }
    return null;
  }
  
  public static void updateRotation(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      paramInt = 0;
      if (paramURLDrawable.isAnim()) {
        break;
      }
    }
    for (;;)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      if (bool) {
        paramView.setTag(2131296389, Integer.valueOf(paramInt));
      }
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      bool = false;
    }
  }
  
  public sxm a()
  {
    return this.b;
  }
  
  public void a(sxm paramsxm)
  {
    this.b = paramsxm;
  }
  
  public void a(sxu paramsxu)
  {
    this.a = paramsxu;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    return this.b.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    sxu localsxu = a(paramInt);
    if (localsxu != null) {
      localsxu.stop();
    }
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2)
  {
    sxu localsxu = a(paramInt1);
    if ((localsxu != null) && (localsxu.isShow())) {
      localsxu.start(paramInt2);
    }
  }
  
  public abstract void onLoadProgressUpdate(View paramView, int paramInt);
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    sxu localsxu = a(paramInt1);
    if (localsxu != null) {
      localsxu.start(paramInt2);
    }
  }
  
  public static class URLImageView2
    extends URLImageView
  {
    public boolean ignoreLayout;
    public URLDrawable mDecoding;
    
    public URLImageView2(Context paramContext)
    {
      super();
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      if (paramURLDrawable == this.mDecoding)
      {
        setImageDrawable(this.mDecoding);
        return;
      }
      super.onLoadFialed(paramURLDrawable, paramThrowable);
    }
    
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      if (paramURLDrawable == this.mDecoding)
      {
        Drawable localDrawable = getDrawable();
        if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
        {
          this.ignoreLayout = true;
          setImageDrawable(this.mDecoding);
          this.ignoreLayout = false;
          return;
        }
        setImageDrawable(this.mDecoding);
        return;
      }
      super.onLoadSuccessed(paramURLDrawable);
    }
    
    public void requestLayout()
    {
      if (!this.ignoreLayout) {
        super.requestLayout();
      }
    }
    
    public void setDecodingDrawble(URLDrawable paramURLDrawable)
    {
      if (this.mDecoding != null) {
        this.mDecoding.setURLDrawableListener(null);
      }
      paramURLDrawable.setURLDrawableListener(this);
      this.mDecoding = paramURLDrawable;
    }
    
    public void setImageDrawable(Drawable paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      if (this.mDecoding != null)
      {
        this.mDecoding.setURLDrawableListener(null);
        this.mDecoding = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageAdapter
 * JD-Core Version:    0.7.0.1
 */