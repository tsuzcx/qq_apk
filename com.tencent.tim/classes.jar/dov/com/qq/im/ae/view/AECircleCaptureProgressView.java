package dov.com.qq.im.ae.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import axjd;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import wja;

public class AECircleCaptureProgressView
  extends FrameLayout
{
  private ImageView Il;
  private ImageView Im;
  private AnimationQIMCircleProgress c;
  @NonNull
  private final float[] dW = { 0.0F, 1.0F };
  @NonNull
  private float[] dX = { 0.0F, 1.0F };
  private int eFm = wja.dp2px(95.0F, getResources());
  private int eFn = wja.dp2px(86.25F, getResources());
  
  public AECircleCaptureProgressView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECircleCaptureProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECircleCaptureProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i(paramContext, paramAttributeSet);
  }
  
  private float a(float paramFloat, @NonNull float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[0] + (paramArrayOfFloat[1] - paramArrayOfFloat[0]) * paramFloat;
  }
  
  private void i(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131558549, this, true);
    this.Il = ((ImageView)findViewById(2131369759));
    this.Im = ((ImageView)findViewById(2131369809));
    this.c = ((AnimationQIMCircleProgress)findViewById(2131362893));
  }
  
  public void Yp(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.Yp(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull axjd paramaxjd)
  {
    if (this.Il != null) {
      this.Il.setImageResource(paramaxjd.eFo);
    }
    if (this.Im != null) {
      this.Im.setImageResource(paramaxjd.eFp);
    }
    this.dX = paramaxjd.dY;
    if (this.c != null)
    {
      this.c.a(paramBoolean, paramaxjd);
      this.c.setAlpha(this.dX[0]);
    }
  }
  
  public void aea(int paramInt)
  {
    if (this.c != null) {
      this.c.aea(paramInt);
    }
  }
  
  public void ba(float paramFloat)
  {
    if (this.c == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    localLayoutParams.width = ((int)(this.eFn * paramFloat));
    localLayoutParams.height = ((int)(this.eFn * paramFloat));
    this.c.setLayoutParams(localLayoutParams);
    this.c.setAlpha(a(axjd.K(paramFloat), this.dX));
  }
  
  public int getMode()
  {
    if (this.c != null) {
      return this.c.getMode();
    }
    return 0;
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    if (this.Il == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.Il.getLayoutParams();
    localLayoutParams.width = ((int)(this.eFm * paramFloat));
    localLayoutParams.height = ((int)(this.eFm * paramFloat));
    this.Il.setLayoutParams(localLayoutParams);
    localLayoutParams = this.Im.getLayoutParams();
    localLayoutParams.width = ((int)(this.eFm * paramFloat));
    localLayoutParams.height = ((int)(this.eFm * paramFloat));
    this.Im.setLayoutParams(localLayoutParams);
    paramFloat = a(axjd.L(paramFloat), this.dW);
    this.Il.setAlpha(paramFloat);
    this.Im.setAlpha(1.0F - paramFloat);
  }
  
  public void setCenterView()
  {
    if (this.c != null) {
      this.c.setCenterView();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.c != null) {
      this.c.setProgress(paramFloat);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.c != null) {
      this.c.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECircleCaptureProgressView
 * JD-Core Version:    0.7.0.1
 */