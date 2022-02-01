package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import kwz;
import nov;
import now;
import noz;
import oud;

public class NativeReadInjoyImageView
  extends KandianUrlImageView
  implements IView
{
  private static final Drawable cx = new ColorDrawable(0);
  private static Map<String, Drawable> eq = new HashMap();
  private boolean akS;
  private boolean akT;
  private int mBorderBottomLeftRadius;
  private int mBorderBottomRightRadius;
  private int mBorderTopLeftRadius;
  private int mBorderTopRightRadius;
  private String mPath;
  private URL mPathUrl;
  
  public NativeReadInjoyImageView(Context paramContext)
  {
    super(paramContext);
    this.mController.pV(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mController.pV(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mController.pV(false);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    noz localnoz = this.mController.a();
    if ((localnoz == null) || (localnoz.mIsCancel)) {
      setImageSrc(this.mPath);
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.mBorderBottomLeftRadius > 0) || (this.mBorderBottomRightRadius > 0) || (this.mBorderTopLeftRadius > 0) || (this.mBorderTopRightRadius > 0)) {
      VirtualViewUtils.clipCanvas(paramCanvas, getWidth(), getHeight(), 0, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    noz localnoz = this.mController.a();
    if ((localnoz == null) || (localnoz.mIsCancel)) {
      setImageSrc(this.mPath);
    }
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mBorderTopLeftRadius = paramInt1;
    this.mBorderTopRightRadius = paramInt2;
    this.mBorderBottomRightRadius = paramInt4;
    this.mBorderBottomLeftRadius = paramInt3;
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (this.akT)
    {
      eq.put(this.mPath, paramDrawable);
      QLog.d("NativeReadInjoyImageView", 2, "setImageDrawable: path is " + this.mPath);
    }
    if (this.akS) {
      paramBoolean = false;
    }
    super.setImageDrawable(paramDrawable, paramBoolean);
  }
  
  public void setImageSrc(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.akT)
        {
          Drawable localDrawable = (Drawable)eq.get(paramString);
          if (localDrawable != null)
          {
            setImageDrawable(localDrawable);
            return;
          }
        }
        if ((this.mPath == null) || (!this.mPath.equalsIgnoreCase(paramString)) || (this.mPathUrl == null))
        {
          this.mPath = paramString;
          this.mPathUrl = new URL(this.mPath);
          QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path changed ");
          QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | mPathUrl :" + this.mPathUrl);
          if (!kwz.a(getContext(), this.mPathUrl)) {
            break;
          }
          setImageResource(2130842541);
          return;
        }
      }
      catch (MalformedURLException paramString)
      {
        this.mPathUrl = null;
        return;
      }
      QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path unchanged ");
    }
    setImage(this.mPathUrl);
  }
  
  public void setIsCacheIcon(boolean paramBoolean)
  {
    this.akT = paramBoolean;
    if (paramBoolean) {
      setPublicAccountImageDownListener(new a(null));
    }
  }
  
  public void setIsClosedoAlphaAniamation(boolean paramBoolean)
  {
    this.akS = paramBoolean;
    if (paramBoolean) {
      setImagePlaceHolder(cx);
    }
  }
  
  static class a
    implements oud
  {
    public void a(URL paramURL, int paramInt) {}
    
    public void a(URL paramURL, Throwable paramThrowable) {}
    
    public void a(URL paramURL, nov paramnov)
    {
      QLog.d("NativeReadInjoyImageView", 2, "setImageDrawable: url is " + paramURL);
      paramnov.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView
 * JD-Core Version:    0.7.0.1
 */