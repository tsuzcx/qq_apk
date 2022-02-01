package com.tencent.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
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

public class AutoVerticalScrollTextView
  extends TextSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private a a;
  private long aaW = 1000L;
  private long aaX = 800L;
  private a b;
  private String[] cN;
  private int dbl;
  private Context mContext;
  private Handler mUIHandler;
  
  public AutoVerticalScrollTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoVerticalScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = new a(paramBoolean1, paramBoolean2);
    locala.setDuration(this.aaX);
    locala.setFillAfter(false);
    locala.setInterpolator(new AccelerateInterpolator());
    return locala;
  }
  
  private void init()
  {
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    setFactory(this);
    this.a = a(true, true);
    this.b = a(false, true);
    setInAnimation(this.a);
    setOutAnimation(this.b);
  }
  
  public void destroy()
  {
    this.mContext = null;
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeMessages(9001);
      this.mUIHandler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.cN != null)
      {
        next();
        this.dbl += 1;
        if (this.dbl >= this.cN.length) {
          this.dbl = 0;
        }
        setText(this.cN[this.dbl]);
      }
      this.mUIHandler.removeMessages(9001);
      this.mUIHandler.sendEmptyMessageDelayed(9001, this.aaW);
    }
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(this.mContext);
    localTextView.setTextSize(14.0F);
    localTextView.setSingleLine(true);
    localTextView.setGravity(17);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#777777"));
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
  
  public void setTextArray(String[] paramArrayOfString)
  {
    this.cN = paramArrayOfString;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      this.dbl = 0;
      setText(paramArrayOfString[this.dbl]);
      this.mUIHandler.sendEmptyMessageDelayed(9001, this.aaW);
    }
  }
  
  class a
    extends Animation
  {
    private final boolean ciq;
    private final boolean cir;
    private Camera mCamera;
    private float mCenterX;
    private float mCenterY;
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
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
      this.mCenterY = AutoVerticalScrollTextView.this.getHeight();
      this.mCenterX = AutoVerticalScrollTextView.this.getWidth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.AutoVerticalScrollTextView
 * JD-Core Version:    0.7.0.1
 */