package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;
import jll;

public class MetaballView
  extends View
{
  Path L = new Path();
  private final float SCALE_RATE = 0.3F;
  private a jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$a;
  private b jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b;
  float[] cC = new float[2];
  float[] cD = new float[2];
  float[] cE = new float[2];
  float[] cF = new float[2];
  float[] cG = new float[2];
  float[] cH = new float[2];
  float[] cI = new float[2];
  float[] cJ = new float[2];
  float[] cK = new float[2];
  float[] cL = new float[2];
  float[] cM = new float[2];
  float[] cN = new float[2];
  float[] cO = new float[2];
  private final int car = 2;
  private int dmd = 60;
  private float mInterpolatedTime;
  private Paint paint = new Paint();
  private float radius = 10.0F;
  private float xC = 1.0F;
  private float xD;
  private ArrayList<a> yg = new ArrayList();
  
  public MetaballView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet, 0);
    init();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private float a(float[] paramArrayOfFloat)
  {
    return (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1]);
  }
  
  private void a(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = ((float)(Math.cos(paramFloat1) * paramFloat2));
    paramArrayOfFloat[1] = ((float)(Math.sin(paramFloat1) * paramFloat2));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject = (a)this.yg.get(paramInt2);
    a locala = (a)this.yg.get(paramInt1);
    float f4 = getDistance(((a)localObject).cP, locala.cP);
    float f3 = ((a)localObject).radius;
    float f1 = locala.radius;
    if (f4 > paramFloat3)
    {
      paramCanvas.drawCircle(locala.cP[0], locala.cP[1], f1, this.paint);
      if ((f3 != 0.0F) && (f1 != 0.0F)) {
        break label147;
      }
    }
    label147:
    while ((f4 > paramFloat3) || (f4 <= Math.abs(f3 - f1)))
    {
      return;
      f1 *= (1.0F + 0.3F * (1.0F - f4 / paramFloat3));
      paramCanvas.drawCircle(locala.cP[0], locala.cP[1], f1, this.paint);
      break;
    }
    float f2;
    if (f4 < f3 + f1) {
      f2 = (float)Math.acos((f3 * f3 + f4 * f4 - f1 * f1) / (2.0F * f3 * f4));
    }
    for (paramFloat3 = (float)Math.acos((f1 * f1 + f4 * f4 - f3 * f3) / (2.0F * f1 * f4));; paramFloat3 = 0.0F)
    {
      float f7 = (float)Math.atan2(locala.cP[1] - localObject.cP[1], locala.cP[0] - localObject.cP[0]);
      float f8 = (float)Math.acos((f3 - f1) / f4);
      float f5 = f7 + f2 + (f8 - f2) * paramFloat1;
      f2 = f7 - f2 - (f8 - f2) * paramFloat1;
      float f6 = (float)(f7 + 3.141592653589793D - paramFloat3 - (3.141592653589793D - paramFloat3 - f8) * paramFloat1);
      double d1 = f7;
      double d2 = paramFloat3;
      paramFloat3 = (float)((3.141592653589793D - paramFloat3 - f8) * paramFloat1 + (d1 - 3.141592653589793D + d2));
      a(f5, f3, this.cC);
      a(f2, f3, this.cD);
      a(f6, f1, this.cE);
      a(paramFloat3, f1, this.cF);
      this.cG[0] = (this.cC[0] + localObject.cP[0]);
      this.cG[1] = (this.cC[1] + localObject.cP[1]);
      this.cH[0] = (this.cD[0] + localObject.cP[0]);
      float[] arrayOfFloat = this.cH;
      f7 = this.cD[1];
      arrayOfFloat[1] = (localObject.cP[1] + f7);
      this.cI[0] = (this.cE[0] + locala.cP[0]);
      this.cI[1] = (this.cE[1] + locala.cP[1]);
      this.cJ[0] = (this.cF[0] + locala.cP[0]);
      localObject = this.cJ;
      f7 = this.cF[1];
      localObject[1] = (locala.cP[1] + f7);
      this.cK[0] = (this.cG[0] - this.cI[0]);
      this.cK[1] = (this.cG[1] - this.cI[1]);
      paramFloat1 = Math.min(paramFloat1 * paramFloat2, a(this.cK) / (f3 + f1)) * Math.min(1.0F, f4 * 2.0F / (f3 + f1));
      paramFloat2 = f3 * paramFloat1;
      paramFloat1 *= f1;
      a(f5 - 1.570796F, paramFloat2, this.cL);
      a(f6 + 1.570796F, paramFloat1, this.cM);
      a(paramFloat3 - 1.570796F, paramFloat1, this.cN);
      a(f2 + 1.570796F, paramFloat2, this.cO);
      this.L.reset();
      this.L.moveTo(this.cG[0], this.cG[1]);
      this.L.cubicTo(this.cG[0] + this.cL[0], this.cG[1] + this.cL[1], this.cI[0] + this.cM[0], this.cI[1] + this.cM[1], this.cI[0], this.cI[1]);
      this.L.lineTo(this.cJ[0], this.cJ[1]);
      this.L.cubicTo(this.cJ[0] + this.cN[0], this.cJ[1] + this.cN[1], this.cH[0] + this.cO[0], this.cH[1] + this.cO[1], this.cH[0], this.cH[1]);
      this.L.lineTo(this.cG[0], this.cG[1]);
      this.L.close();
      paramCanvas.drawPath(this.L, this.paint);
      return;
      f2 = 0.0F;
    }
  }
  
  private float getDistance(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0] - paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat1[1] - paramArrayOfFloat2[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void init()
  {
    this.radius = getRadius();
    this.dmd = GJ();
    float f = 1.3F * this.radius;
    this.paint.setColor(-16395392);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setAntiAlias(true);
    a locala = new a(null);
    locala.cP = new float[] { this.radius + this.dmd, f };
    locala.radius = (this.radius / 4.0F * 3.0F);
    this.yg.add(locala);
    int i = 1;
    while (i < 2)
    {
      locala = new a(null);
      locala.cP = new float[] { (this.radius * 2.0F + this.dmd) * i, f };
      locala.radius = this.radius;
      this.yg.add(locala);
      i += 1;
    }
    this.xD = ((this.radius * 2.0F + this.dmd) * 2.0F - this.radius * 2.0F);
  }
  
  private void startAnimation()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b = new b(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b.setDuration(1000L);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b.setRepeatMode(2);
    startAnimation(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$b);
  }
  
  private void stopAnimation()
  {
    clearAnimation();
    postInvalidate();
  }
  
  protected int GJ()
  {
    return (int)jll.dp2px(getContext(), 20.0F);
  }
  
  protected void d(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {}
  
  protected int getRadius()
  {
    return (int)jll.dp2px(getContext(), 10.0F);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getVisibility() == 0) {
      startAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (getVisibility() == 0) {
      stopAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 1;
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$a = ((a)this.yg.get(0));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$a.cP[0] = (this.xD * this.mInterpolatedTime + this.radius);
    paramCanvas.drawCircle(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$a.cP[0], this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$a.cP[1], this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$a.radius, this.paint);
    int j = this.yg.size();
    while (i < j)
    {
      a(paramCanvas, i, 0, 0.6F, this.xC, this.radius * 2.0F);
      i += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(resolveSizeAndState((int)((this.radius * 2.0F + this.dmd) * 2.0F), paramInt1, 0), resolveSizeAndState((int)(this.radius * 2.0F * 1.4F), paramInt2, 0));
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (getVisibility() == 0)) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      stopAnimation();
      return;
    }
    startAnimation();
  }
  
  public void setPaintMode(int paramInt)
  {
    Paint localPaint = this.paint;
    if (paramInt == 0) {}
    for (Paint.Style localStyle = Paint.Style.STROKE;; localStyle = Paint.Style.FILL)
    {
      localPaint.setStyle(localStyle);
      invalidate();
      return;
    }
  }
  
  class a
  {
    float[] cP;
    float radius;
    
    private a() {}
  }
  
  class b
    extends Animation
  {
    private b() {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      MetaballView.a(MetaballView.this, paramFloat);
      MetaballView.this.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.MetaballView
 * JD-Core Version:    0.7.0.1
 */