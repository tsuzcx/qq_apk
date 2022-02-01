package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import aojk;
import aojn;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class PicProgressView
  extends MessageProgressView
{
  private aojn jdField_a_of_type_Aojn;
  RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable;
  private boolean aOm;
  int cPx = 0;
  public String key;
  public boolean pause;
  
  public PicProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PicProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PicProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void hK(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aojn == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_Aojn.getCurrentProgress() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_Aojn.setCurrentProgress(i);
          paramInt1 = Math.max(this.jdField_a_of_type_Aojn.KK(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_Aojn.KK() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_Aojn.getCurrentProgress() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PicProgressView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Aojn.getKey() + " processor " + this.jdField_a_of_type_Aojn);
          }
          setProgress(i);
          if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable != null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = new RefreshProgressRunnable(i, paramInt2);
          postDelayed(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_Aojn = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable.Ml(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PicProgressView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Aojn.getKey() + " processor " + this.jdField_a_of_type_Aojn);
      }
    } while (paramInt1 < this.cPx);
    setProgress(paramInt1);
  }
  
  public void aQ(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Aojn != null) && ((this.jdField_a_of_type_Aojn instanceof aojk)) && (this.jdField_a_of_type_Aojn.hh() < 1001L)) {
      return;
    }
    super.aQ(paramCanvas);
  }
  
  public void adc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicProgressView", 2, "updateProgress processor:" + this.jdField_a_of_type_Aojn);
    }
    if (this.jdField_a_of_type_Aojn != null) {
      hK(this.jdField_a_of_type_Aojn.getCurrentProgress(), 1);
    }
  }
  
  public int getProgress()
  {
    if (this.jdField_a_of_type_Aojn != null) {
      return this.jdField_a_of_type_Aojn.getCurrentProgress();
    }
    return 0;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
    super.onDetachedFromWindow();
  }
  
  public void setProcessor(aojn paramaojn)
  {
    if (this.jdField_a_of_type_Aojn == paramaojn) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_Aojn = paramaojn;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt == 100) {
      setProcessor(null);
    }
    this.cPx = paramInt;
    setDrawStatus(1);
    setAnimProgress(paramInt, this.key);
  }
  
  public void setProgressKey(String paramString)
  {
    this.key = paramString;
    bind(paramString);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    int i = 1;
    if ((!this.aOm) && (paramBoolean == true)) {}
    for (;;)
    {
      this.aOm = paramBoolean;
      if (i != 0) {
        invalidate();
      }
      return;
      i = 0;
    }
  }
  
  class RefreshProgressRunnable
    implements Runnable
  {
    int brX = 0;
    int cPy = 0;
    
    public RefreshProgressRunnable(int paramInt1, int paramInt2)
    {
      this.brX = paramInt1;
      this.cPy = paramInt2;
    }
    
    public void Ml(int paramInt)
    {
      this.cPy = paramInt;
    }
    
    public void run()
    {
      PicProgressView.this.a = null;
      if (!PicProgressView.this.pause)
      {
        this.brX += this.cPy;
        PicProgressView.a(PicProgressView.this, this.brX, this.cPy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView
 * JD-Core Version:    0.7.0.1
 */