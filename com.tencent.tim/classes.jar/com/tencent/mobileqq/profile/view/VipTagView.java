package com.tencent.mobileqq.profile.view;

import alhm;
import alhn;
import alhp;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import aqnc;
import aqod.a;
import aqod.b;
import aqod.c;

public final class VipTagView
  extends TextView
  implements aqod.b
{
  private static final int[] mC = { 2131298997, 2131298998, 2131298999, 2131299000, 2131299001 };
  private alhp a;
  private aqnc<Float> b;
  private Paint ch;
  private boolean cwZ;
  private boolean cxa;
  private int dtS;
  private Bitmap fZ;
  private float yF;
  
  public VipTagView(Context paramContext)
  {
    super(paramContext);
    dFV();
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode()) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843087 });
    }
    try
    {
      paramAttributeSet = paramContext.getString(0);
      paramContext.recycle();
      if (paramAttributeSet != null) {
        setLabelText(paramAttributeSet);
      }
      dFV();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void SR(int paramInt)
  {
    setBackgroundResource(2130848283);
    if ((paramInt > 0) && (paramInt <= 5))
    {
      Object localObject = getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        Resources localResources = getResources();
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).mutate();
        paramInt = localResources.getDimensionPixelSize(mC[(paramInt - 1)]);
        ((GradientDrawable)localObject).setSize(paramInt, paramInt);
      }
    }
  }
  
  private void be(Canvas paramCanvas)
  {
    if (this.cxa)
    {
      int i = getHeight();
      int j = this.fZ.getHeight();
      float f1 = this.yF;
      paramCanvas.save();
      float f2 = getWidth() - this.fZ.getWidth();
      float f3 = i;
      float f4 = j;
      paramCanvas.translate(f2, -(i * 0.8F + j) * this.yF + (f3 * 0.8F + f4));
      this.ch.setAlpha((int)(255.0F - this.yF * 200.0F));
      paramCanvas.scale(f1, f1);
      paramCanvas.drawBitmap(this.fZ, 0.0F, 0.0F, this.ch);
      paramCanvas.restore();
    }
  }
  
  private void dFV()
  {
    setClickable(true);
    Resources localResources = getResources();
    setTextSize(0, localResources.getDimensionPixelSize(2131298988));
    int i = localResources.getDimensionPixelSize(2131298993);
    this.ch = new Paint();
    this.ch.setColor(-16777216);
    this.ch.setTextSize(i);
    this.ch.setTextAlign(Paint.Align.LEFT);
    this.fZ = Bitmap.createBitmap((int)this.ch.measureText("+1"), i, Bitmap.Config.ARGB_4444);
    new Canvas(this.fZ).drawText("+1", 0.0F, i, this.ch);
    this.a = new alhp(this);
    this.b = new aqnc(Float.valueOf(0.0F), Float.valueOf(1.0F), new alhm(this));
    this.b.setDuration(800L);
    this.b.setInterpolator(new DecelerateInterpolator());
    this.b.setAnimationListener(new alhn(this));
  }
  
  private void updatePraiseCount()
  {
    if (this.dtS <= 99) {}
    for (String str1 = String.valueOf(this.dtS);; str1 = "99+")
    {
      if ((getText() instanceof String))
      {
        String str2 = (String)getText();
        str2 = str2.substring(0, str2.indexOf('('));
        setText(str2 + "(" + str1 + ")");
      }
      return;
    }
  }
  
  public void a(aqod.a parama, float paramFloat1, float paramFloat2) {}
  
  public void a(aqod.a parama, aqod.c paramc, float paramFloat1, float paramFloat2) {}
  
  public boolean a(aqod.a parama, float paramFloat1, float paramFloat2)
  {
    bringToFront();
    this.a.dFY();
    return true;
  }
  
  public boolean atD()
  {
    return this.a.atD();
  }
  
  public void dFW()
  {
    this.dtS += 1;
    this.cxa = true;
    startAnimation(this.b);
    updatePraiseCount();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    be(paramCanvas);
  }
  
  public void setLabelAndPraise(String paramString, int paramInt)
  {
    setLabelText(paramString);
    this.dtS = paramInt;
    updatePraiseCount();
  }
  
  public void setLabelText(String paramString)
  {
    int i = 0;
    String str = paramString;
    if (paramString.length() > 5) {
      str = paramString.substring(0, 5);
    }
    paramString = str.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < paramString.length)
    {
      localStringBuilder.append(paramString[i]);
      if ((str.length() > 3) && (i == 1)) {
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    localStringBuilder.append("\n(0)");
    setText(localStringBuilder);
    SR(str.length());
  }
  
  public void setShakingState(boolean paramBoolean)
  {
    this.cwZ = paramBoolean;
    if (this.cwZ)
    {
      this.a.dFX();
      return;
    }
    this.a.dFY();
  }
  
  public void setTagColor(int paramInt1, int paramInt2)
  {
    Object localObject = getBackground();
    if ((localObject instanceof GradientDrawable))
    {
      localObject = (GradientDrawable)localObject;
      ((GradientDrawable)localObject).setColor(paramInt2);
      ((GradientDrawable)localObject).setStroke(2, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipTagView
 * JD-Core Version:    0.7.0.1
 */