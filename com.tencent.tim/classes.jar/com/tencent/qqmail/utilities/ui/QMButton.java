package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMButton
  extends Button
{
  private int mBackgroundResouceDisabled = 0;
  private int mBackgroundResouceNormal = 0;
  private int mBackgroundResoucePressed = 0;
  private View.OnTouchListener onTouchListener = new QMButton.1(this);
  
  public QMButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QMButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QMButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      setStateListAnimator(null);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMButton", "setStateListAnimator error " + localException.getMessage());
    }
  }
  
  private void initPressedBagkground()
  {
    if ((isEnabled()) && (this.mBackgroundResoucePressed != 0))
    {
      setOnTouchListener(this.onTouchListener);
      return;
    }
    setOnTouchListener(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      setEnabled(isEnabled());
    }
  }
  
  public void setBackgroundResource(int paramInt1, int paramInt2, int paramInt3)
  {
    setBackgroundResource(paramInt1);
    this.mBackgroundResouceNormal = paramInt1;
    this.mBackgroundResoucePressed = paramInt2;
    this.mBackgroundResouceDisabled = paramInt3;
    if (paramInt2 != 0) {
      initPressedBagkground();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean) {
      if (this.mBackgroundResouceDisabled != 0) {
        setBackgroundResource(this.mBackgroundResouceNormal);
      }
    }
    for (;;)
    {
      initPressedBagkground();
      return;
      if (this.mBackgroundResouceNormal != 0) {
        setBackgroundResource(this.mBackgroundResouceDisabled);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMButton
 * JD-Core Version:    0.7.0.1
 */