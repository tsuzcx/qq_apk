package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import aojn;
import com.tencent.qphone.base.util.QLog;
import wyf;

public class MessageProgressTextView
  extends TextView
{
  private aojn jdField_a_of_type_Aojn;
  RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable;
  private a jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$a;
  public boolean bWO = true;
  private boolean bot = true;
  int cPx = 0;
  public boolean pause;
  int textColor;
  int textSize;
  
  public MessageProgressTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
            QLog.d("ProgressTextView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Aojn.getKey() + " processor " + this.jdField_a_of_type_Aojn);
          }
          setProgress(i);
          if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable != null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = new RefreshProgressRunnable(i, paramInt2);
          postDelayed(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_Aojn = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable.Ml(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Aojn.getKey() + " processor " + this.jdField_a_of_type_Aojn);
      }
    } while (paramInt1 < this.cPx);
    setProgress(paramInt1);
  }
  
  public void adc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateProgress processor:" + this.jdField_a_of_type_Aojn);
    }
    if (this.jdField_a_of_type_Aojn != null) {
      hK(this.jdField_a_of_type_Aojn.getCurrentProgress(), 1);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.bWO = paramBoolean;
    this.textSize = paramInt1;
    this.textColor = paramInt2;
  }
  
  public void setProcessor(aojn paramaojn)
  {
    if (this.jdField_a_of_type_Aojn == paramaojn) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_Aojn = paramaojn;
  }
  
  public void setProgress(int paramInt)
  {
    this.cPx = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$a.Mk(paramInt);
    }
    if ((this.bot) && (this.bWO)) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof wyf)) && (!this.bWO)) {
          ((wyf)localDrawable).fH(this.textSize, this.textColor);
        }
      }
      return;
      setText("");
    }
  }
  
  public void setProgressListener(a parama, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$a = parama;
    this.bot = paramBoolean;
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
      MessageProgressTextView.this.a = null;
      if (!MessageProgressTextView.this.pause)
      {
        this.brX += this.cPy;
        MessageProgressTextView.a(MessageProgressTextView.this, this.brX, this.cPy);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Mk(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */