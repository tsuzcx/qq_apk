package com.tencent.mobileqq.activity.richmedia.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SeekBar;

public class RotationSeekBar
  extends SeekBar
{
  private static final Interpolator i = new AccelerateDecelerateInterpolator();
  private static float sDensity = -1.0F;
  private ValueAnimator am;
  private ValueAnimator animator;
  private boolean bAt;
  private Paint mMarkPainter;
  private float[] mMarkPercent;
  
  public RotationSeekBar(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private int dpToPx(float paramFloat)
  {
    getDensity();
    return Math.round(sDensity * paramFloat);
  }
  
  private float getDensity()
  {
    if (sDensity == -1.0F) {
      sDensity = getContext().getResources().getDisplayMetrics().density;
    }
    return sDensity;
  }
  
  void initUI() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.animator != null) {
      this.animator.cancel();
    }
    if (this.am != null) {
      this.am.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mMarkPercent != null)
    {
      int k = getMeasuredWidth();
      int j = getMeasuredHeight();
      if (this.mMarkPainter == null)
      {
        this.mMarkPainter = new Paint();
        this.mMarkPainter.setStyle(Paint.Style.FILL);
        this.mMarkPainter.setColor(getResources().getColor(2131167654));
      }
      int m = dpToPx(2.0F);
      int n = j / 2;
      float[] arrayOfFloat = this.mMarkPercent;
      int i1 = arrayOfFloat.length;
      j = 0;
      while (j < i1)
      {
        float f = arrayOfFloat[j];
        if ((f > 0.0F) && (f < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f * k, n);
          paramCanvas.drawCircle(0.0F, 0.0F, m, this.mMarkPainter);
          paramCanvas.restore();
        }
        j += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setAnimateEnable(boolean paramBoolean)
  {
    this.bAt = paramBoolean;
  }
  
  /* Error */
  public void setProgress(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:bAt	Z
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: iload_1
    //   11: invokespecial 48	android/widget/SeekBar:setProgress	(I)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   21: ifnull +10 -> 31
    //   24: aload_0
    //   25: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   28: invokevirtual 94	android/animation/ValueAnimator:cancel	()V
    //   31: aload_0
    //   32: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   35: ifnonnull +64 -> 99
    //   38: aload_0
    //   39: iconst_2
    //   40: newarray int
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 160	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   48: iastore
    //   49: dup
    //   50: iconst_1
    //   51: iload_1
    //   52: iastore
    //   53: invokestatic 164	android/animation/ValueAnimator:ofInt	([I)Landroid/animation/ValueAnimator;
    //   56: putfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   59: aload_0
    //   60: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   63: getstatic 29	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:i	Landroid/view/animation/Interpolator;
    //   66: invokevirtual 168	android/animation/ValueAnimator:setInterpolator	(Landroid/animation/TimeInterpolator;)V
    //   69: aload_0
    //   70: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   73: new 170	aavk
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 173	aavk:<init>	(Lcom/tencent/mobileqq/activity/richmedia/view/RotationSeekBar;)V
    //   81: invokevirtual 177	android/animation/ValueAnimator:addUpdateListener	(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   84: aload_0
    //   85: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   88: invokevirtual 180	android/animation/ValueAnimator:start	()V
    //   91: goto -77 -> 14
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: aload_0
    //   100: getfield 89	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:animator	Landroid/animation/ValueAnimator;
    //   103: iconst_2
    //   104: newarray int
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: invokevirtual 160	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   112: iastore
    //   113: dup
    //   114: iconst_1
    //   115: iload_1
    //   116: iastore
    //   117: invokevirtual 184	android/animation/ValueAnimator:setIntValues	([I)V
    //   120: goto -36 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	RotationSeekBar
    //   0	123	1	paramInt	int
    //   94	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	14	94	finally
    //   17	31	94	finally
    //   31	84	94	finally
    //   84	91	94	finally
    //   99	120	94	finally
  }
  
  /* Error */
  public void setSecondaryProgress(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:bAt	Z
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: iload_1
    //   11: invokespecial 52	android/widget/SeekBar:setSecondaryProgress	(I)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   21: ifnull +10 -> 31
    //   24: aload_0
    //   25: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   28: invokevirtual 94	android/animation/ValueAnimator:cancel	()V
    //   31: aload_0
    //   32: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   35: ifnonnull +64 -> 99
    //   38: aload_0
    //   39: iconst_2
    //   40: newarray int
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 160	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   48: iastore
    //   49: dup
    //   50: iconst_1
    //   51: iload_1
    //   52: iastore
    //   53: invokestatic 164	android/animation/ValueAnimator:ofInt	([I)Landroid/animation/ValueAnimator;
    //   56: putfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   59: aload_0
    //   60: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   63: getstatic 29	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:i	Landroid/view/animation/Interpolator;
    //   66: invokevirtual 168	android/animation/ValueAnimator:setInterpolator	(Landroid/animation/TimeInterpolator;)V
    //   69: aload_0
    //   70: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   73: new 186	aavl
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 187	aavl:<init>	(Lcom/tencent/mobileqq/activity/richmedia/view/RotationSeekBar;)V
    //   81: invokevirtual 177	android/animation/ValueAnimator:addUpdateListener	(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   84: aload_0
    //   85: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   88: invokevirtual 180	android/animation/ValueAnimator:start	()V
    //   91: goto -77 -> 14
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: aload_0
    //   100: getfield 96	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:am	Landroid/animation/ValueAnimator;
    //   103: iconst_2
    //   104: newarray int
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: invokevirtual 160	com/tencent/mobileqq/activity/richmedia/view/RotationSeekBar:getProgress	()I
    //   112: iastore
    //   113: dup
    //   114: iconst_1
    //   115: iload_1
    //   116: iastore
    //   117: invokevirtual 184	android/animation/ValueAnimator:setIntValues	([I)V
    //   120: goto -36 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	RotationSeekBar
    //   0	123	1	paramInt	int
    //   94	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	14	94	finally
    //   17	31	94	finally
    //   31	84	94	finally
    //   84	91	94	finally
    //   99	120	94	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */