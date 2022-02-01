package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory.ListenerAdapter;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieTask;
import com.tencent.qphone.base.util.QLog;

public class LoginAnimBtnView
  extends ImageView
{
  private Path C;
  private LottieComposition.Factory.ListenerAdapter jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter;
  private LottieTask<LottieComposition> jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask;
  private LottieDrawable b;
  private boolean bwn;
  private boolean bwo;
  private int ccy;
  private int ccz;
  private Object ce = new Object();
  private int chO = -1446926;
  private int chP = -16725252;
  private int chQ = 855638016;
  private volatile boolean mIsDestroyed;
  private Paint mMaskPaint;
  private Runnable mUpdateRunnable = new LoginAnimBtnView.1(this);
  
  public LoginAnimBtnView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoginAnimBtnView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoginAnimBtnView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cvu()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "loadLottieAnimation mLottieDrawable:" + this.b);
    }
    if (this.b != null) {
      return;
    }
    ThreadManager.post(new LoginAnimBtnView.2(this), 5, null, true);
  }
  
  private void playAnim()
  {
    if ((this.b != null) && (!this.b.isAnimating())) {
      this.b.playAnimation();
    }
  }
  
  private void stopAnim()
  {
    if ((this.b != null) && (this.b.isAnimating())) {
      this.b.pauseAnimation();
    }
  }
  
  public void cvs()
  {
    if ((this.b != null) && (isEnabled()) && (this.b.isAnimating()) && (this.bwo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "pauseIfAnim");
      }
      this.b.pauseAnimation();
    }
  }
  
  public void cvt()
  {
    if ((this.b != null) && (isEnabled()) && (!this.b.isAnimating()) && (this.bwo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "resumeIfAnim");
      }
      this.b.resumeAnimation();
    }
  }
  
  public void init()
  {
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setColor(-1);
    this.mMaskPaint.setStyle(Paint.Style.FILL);
    this.mMaskPaint.setAntiAlias(true);
    setEnabled(false);
    this.mIsDestroyed = false;
    cvu();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onDestroy " + this.b);
    }
    this.mIsDestroyed = true;
    removeCallbacks(this.mUpdateRunnable);
    if (this.b != null)
    {
      setBackgroundDrawable(null);
      this.b.cancelAnimation();
      this.b.recycleBitmaps();
      this.b.clearComposition();
      this.b.setImageAssetDelegate(null);
      this.b = null;
      this.bwn = false;
    }
    synchronized (this.ce)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter.cancel();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask.removeListener(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask = null;
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter = null;
      }
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.C == null) || (i != this.ccy) || (j != this.ccz))
        {
          int k = Math.min(i, j) / 2;
          this.C = new Path();
          this.C.setFillType(Path.FillType.INVERSE_WINDING);
          this.C.addCircle(i / 2, j / 2, k, Path.Direction.CW);
          this.ccy = i;
          this.ccz = j;
        }
        if ((isEnabled()) && (isPressed())) {
          paramCanvas.drawColor(this.chQ);
        }
        paramCanvas.drawPath(this.C, this.mMaskPaint);
        return;
      }
      catch (Throwable paramCanvas)
      {
        QLog.e("LoginAnimBtnView", 1, "onDraw error2:" + paramCanvas.getMessage());
      }
      localOutOfMemoryError = localOutOfMemoryError;
      QLog.e("LoginAnimBtnView", 1, "onDraw error0:" + localOutOfMemoryError.getMessage());
      if (this.b != null)
      {
        this.b.cancelAnimation();
        this.b.recycleBitmaps();
        this.b.clearComposition();
        this.b.setImageAssetDelegate(null);
      }
      this.b = null;
      this.bwn = false;
      if (isEnabled()) {
        setBackgroundColor(this.chP);
      }
      for (;;)
      {
        try
        {
          super.onDraw(paramCanvas);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("LoginAnimBtnView", 1, "onDraw error1:" + localThrowable.getMessage());
        }
        break;
        setBackgroundColor(this.chO);
      }
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onPause " + this.b);
    }
    if ((this.b != null) && (this.b.isAnimating())) {
      this.b.pauseAnimation();
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onResume " + this.b);
    }
    if ((this.b != null) && (isEnabled())) {
      this.b.resumeAnimation();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool = isEnabled();
    super.setEnabled(paramBoolean);
    if (bool == paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "setEnabled isEnabled:" + isEnabled() + "  mLottieDrawable:" + this.b);
    }
    removeCallbacks(this.mUpdateRunnable);
    post(this.mUpdateRunnable);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView
 * JD-Core Version:    0.7.0.1
 */