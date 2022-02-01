package com.tencent.tim.cloudfile.anima;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import atau.a;
import atjf;
import atjf.b;
import atjm;
import atjn;
import atjp;

public class DynamicButton
  extends TextView
{
  private atjm a;
  private atjm b;
  protected boolean dhV;
  protected int eqj;
  protected int mColor;
  protected float mCornerRadius;
  protected int mHeight;
  protected int mStrokeColor;
  protected int mStrokeWidth;
  protected int mWidth;
  private float textSize;
  
  public DynamicButton(Context paramContext)
  {
    super(paramContext);
    initView(paramContext, null, 0);
  }
  
  public DynamicButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext, paramAttributeSet, 0);
  }
  
  public DynamicButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public DynamicButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initView(paramContext, paramAttributeSet, paramInt1);
  }
  
  private void b(a parama)
  {
    if ((!TextUtils.isEmpty(parama.text)) && (parama.icon != null))
    {
      Log.d("DynamicButton", "text is not null && icon is not null!");
      setCompoundDrawablesWithIntrinsicBounds(parama.icon, null, null, null);
      setText(parama.text);
      setPadding(kH(10), 0, kH(10), 0);
    }
    for (;;)
    {
      this.dhV = false;
      return;
      if (!TextUtils.isEmpty(parama.text))
      {
        setText(parama.text);
      }
      else if (parama.icon != null)
      {
        int i = getWidth() / 2 - parama.icon.getIntrinsicWidth() / 2;
        Log.d("DynamicButton", "setIcon padding:" + i);
        setCompoundDrawablesWithIntrinsicBounds(parama.icon, null, null, null);
        setPadding(i, 0, 0, 0);
      }
    }
  }
  
  private void c(a parama)
  {
    if (a.a(parama) <= 0) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, a.a(parama), 0.0F, a.b(parama));
    localTranslateAnimation.setDuration(a.a(parama));
    localTranslateAnimation.setAnimationListener(new atjn(this, parama));
    new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setDuration(a.a(parama));
    localAnimationSet.setFillAfter(true);
    startAnimation(localAnimationSet);
  }
  
  public atjm a()
  {
    return this.a;
  }
  
  public atjm a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    atjm localatjm = new atjm();
    localatjm.setShape(0);
    localatjm.setStrokeColor(paramInt3);
    localatjm.setStrokeWidth(paramInt2);
    localatjm.setColor(paramInt1);
    localatjm.setRadius(paramFloat);
    return localatjm;
  }
  
  public void a(@NonNull a parama)
  {
    if (!this.dhV)
    {
      this.b.setStrokeColor(parama.mStrokeColor);
      this.b.setStrokeWidth(parama.mStrokeWidth);
      this.b.setColor(parama.eqj);
      this.b.setCornerRadius(parama.mCornerRadius);
      if (parama.duration <= 0L) {
        break label98;
      }
      d(parama);
    }
    for (;;)
    {
      this.mColor = parama.mColor;
      this.mStrokeColor = parama.mStrokeColor;
      this.mStrokeWidth = parama.mStrokeWidth;
      this.mCornerRadius = parama.mCornerRadius;
      return;
      label98:
      e(parama);
    }
  }
  
  public void d(a parama)
  {
    this.dhV = true;
    setText(null);
    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    atjf.b localb = atjf.b.a(this);
    localb.a(this.mHeight, parama.mHeight).b(this.mWidth, parama.mWidth).a(this.mCornerRadius, parama.mCornerRadius).e(this.mColor, parama.mColor).a(parama.duration).a(parama.text).a(new atjp(this, parama)).d(this.mStrokeColor, parama.mStrokeColor).c(this.mStrokeWidth, parama.mStrokeWidth);
    atjf.a(localb);
  }
  
  public void e(a parama)
  {
    this.a.setColor(parama.mColor);
    this.a.setCornerRadius(parama.mCornerRadius);
    this.a.setStrokeWidth(parama.mStrokeWidth);
    this.a.setStrokeColor(parama.mStrokeColor);
    if ((parama.mHeight != 0) && (parama.mWidth != 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.width = parama.mWidth;
      localLayoutParams.height = parama.mHeight;
      setLayoutParams(localLayoutParams);
    }
    b(parama);
  }
  
  public void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qg, paramInt, 0);
    this.mColor = paramContext.getColor(0, -14782465);
    this.eqj = paramContext.getColor(2, -16748133);
    this.mCornerRadius = paramContext.getDimensionPixelOffset(1, kH(2));
    this.mStrokeColor = paramContext.getColor(3, 0);
    this.mStrokeWidth = paramContext.getDimensionPixelOffset(4, kH(0));
    this.a = a(this.mColor, this.mCornerRadius, this.mStrokeWidth, this.mStrokeColor);
    this.b = a(this.eqj, this.mCornerRadius, this.mStrokeWidth, this.mStrokeColor);
    paramAttributeSet = new StateListDrawable();
    atjm localatjm = this.b;
    paramAttributeSet.addState(new int[] { 16842919 }, localatjm);
    localatjm = this.b;
    paramAttributeSet.addState(new int[] { 16842908 }, localatjm);
    localatjm = this.b;
    paramAttributeSet.addState(new int[] { 16842913 }, localatjm);
    localatjm = this.a;
    paramAttributeSet.addState(new int[0], localatjm);
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(paramAttributeSet);
    }
    paramContext.recycle();
  }
  
  public int kH(int paramInt)
  {
    return (int)(getResources().getDisplayMetrics().density * paramInt + 0.5D);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mHeight = getHeight();
    this.mWidth = getWidth();
    this.textSize = getTextSize();
    Log.d("DynamicButton", "onSizeChange:mHeight:" + this.mHeight + " mWidth:" + this.mWidth + " w:" + paramInt1 + " h:" + paramInt2);
  }
  
  public void setBackGroundCompat(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 16)
    {
      setBackgroundDrawable(paramDrawable);
      return;
    }
    setBackground(paramDrawable);
  }
  
  public static class a
  {
    public long duration;
    public int eqj;
    private int eqk;
    private int eql;
    private float gW;
    private float gY;
    public Drawable icon;
    private Activity mActivity;
    public int mColor;
    public float mCornerRadius;
    public int mHeight;
    public int mStrokeColor;
    public int mStrokeWidth;
    public int mWidth;
    public String text;
    
    public static a a()
    {
      return new a();
    }
    
    public a a(float paramFloat)
    {
      this.gW = paramFloat;
      return this;
    }
    
    public a a(int paramInt)
    {
      this.mHeight = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.duration = paramLong;
      return this;
    }
    
    public a a(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      return this;
    }
    
    public a a(String paramString)
    {
      this.text = paramString;
      return this;
    }
    
    public a b(float paramFloat)
    {
      this.gY = paramFloat;
      return this;
    }
    
    public a b(int paramInt)
    {
      this.mWidth = paramInt;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.mCornerRadius = paramInt;
      return this;
    }
    
    public a e(int paramInt)
    {
      this.eqk = paramInt;
      return this;
    }
    
    public a f(int paramInt)
    {
      this.eql = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.DynamicButton
 * JD-Core Version:    0.7.0.1
 */