package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import java.lang.ref.WeakReference;

public class ScrollTextView
  extends TextSwitcher
  implements ViewSwitcher.ViewFactory
{
  private b a;
  private long aaW = 2000L;
  private long aaX = 800L;
  private b b;
  private String[] cN;
  private boolean cip;
  private int dbl;
  private Handler mUIHandler;
  
  public ScrollTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private b a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = new b(paramBoolean1, paramBoolean2);
    localb.setDuration(this.aaX);
    localb.setFillAfter(false);
    localb.setInterpolator(new AccelerateInterpolator());
    return localb;
  }
  
  public Drawable c(int paramInt1, int paramInt2, int paramInt3)
  {
    Resources localResources = getContext().getResources();
    return new BitmapDrawable(localResources, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(localResources, paramInt1), paramInt2, paramInt3, true));
  }
  
  public void init()
  {
    this.mUIHandler = new a(this);
    setFactory(this);
    this.a = a(true, true);
    this.b = a(false, true);
    setInAnimation(this.a);
    setOutAnimation(this.b);
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setTextSize(14.0F);
    localTextView.setSingleLine(true);
    localTextView.setGravity(19);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#FFFF8000"));
    if (this.cip)
    {
      Drawable localDrawable = c(2130840547, 50, 50);
      if (localDrawable != null) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      }
      return localTextView;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    return localTextView;
  }
  
  public void next()
  {
    if (getInAnimation() != this.a) {
      setInAnimation(this.a);
    }
    if (getOutAnimation() != this.b) {
      setOutAnimation(this.b);
    }
  }
  
  public void setAnimationTime(long paramLong)
  {
    this.aaX = paramLong;
  }
  
  public void setInterSwitcTime(long paramLong)
  {
    this.aaW = paramLong;
  }
  
  public void setShowPriority(boolean paramBoolean)
  {
    this.cip = paramBoolean;
  }
  
  public void setTextArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    do
    {
      return;
      this.cN = paramArrayOfString;
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 1))
      {
        this.dbl = 0;
        setText(paramArrayOfString[this.dbl]);
        this.mUIHandler.sendEmptyMessageDelayed(9001, this.aaW);
        return;
      }
    } while (paramArrayOfString.length != 1);
    setText(paramArrayOfString[0]);
    this.mUIHandler.removeMessages(9001);
  }
  
  public static class a
    extends Handler
  {
    private WeakReference<ScrollTextView> ha;
    
    public a(ScrollTextView paramScrollTextView)
    {
      super();
      this.ha = new WeakReference(paramScrollTextView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ScrollTextView localScrollTextView = (ScrollTextView)this.ha.get();
      if (localScrollTextView == null)
      {
        removeCallbacksAndMessages(null);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      if (ScrollTextView.a(localScrollTextView) != null)
      {
        localScrollTextView.next();
        ScrollTextView.a(localScrollTextView);
        if (ScrollTextView.b(localScrollTextView) >= ScrollTextView.a(localScrollTextView).length) {
          ScrollTextView.a(localScrollTextView, 0);
        }
        localScrollTextView.setText(ScrollTextView.a(localScrollTextView)[ScrollTextView.b(localScrollTextView)]);
      }
      removeMessages(9001);
      sendEmptyMessageDelayed(9001, ScrollTextView.a(localScrollTextView));
    }
  }
  
  class b
    extends Animation
  {
    private final boolean ciq;
    private final boolean cir;
    private Camera mCamera;
    private float mCenterX;
    private float mCenterY;
    
    public b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.ciq = paramBoolean1;
      this.cir = paramBoolean2;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f1 = this.mCenterX;
      float f2 = this.mCenterY;
      Camera localCamera = this.mCamera;
      int i;
      if (this.cir)
      {
        i = 1;
        paramTransformation = paramTransformation.getMatrix();
        localCamera.save();
        if (!this.ciq) {
          break label99;
        }
        localCamera.translate(0.0F, i * this.mCenterY * (paramFloat - 1.0F), 0.0F);
      }
      for (;;)
      {
        localCamera.getMatrix(paramTransformation);
        localCamera.restore();
        paramTransformation.preTranslate(-f1, -f2);
        paramTransformation.postTranslate(f1, f2);
        return;
        i = -1;
        break;
        label99:
        localCamera.translate(0.0F, i * this.mCenterY * paramFloat, 0.0F);
      }
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      this.mCamera = new Camera();
      this.mCenterY = ScrollTextView.this.getHeight();
      this.mCenterX = ScrollTextView.this.getWidth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ScrollTextView
 * JD-Core Version:    0.7.0.1
 */