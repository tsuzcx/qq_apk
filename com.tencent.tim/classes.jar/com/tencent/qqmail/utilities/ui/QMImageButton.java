package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class QMImageButton
  extends ImageButton
{
  public static int mOpacityDisabled = 76;
  public static int mOpacityNormal = 255;
  public static int mOpacityPressed = 153;
  private int mBackgroundResouceDisabled = 0;
  private int mBackgroundResouceNormal = 0;
  private int mBackgroundResoucePressed = 0;
  private int mImageDisabled = 0;
  private int mImageNormal = 0;
  private int mImagePressed = 0;
  private View.OnTouchListener onTouchListener = new QMImageButton.1(this);
  
  public QMImageButton(Context paramContext)
  {
    super(paramContext);
    setMinimumHeight(0);
    setMinimumWidth(0);
  }
  
  public QMImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setMinimumHeight(0);
    setMinimumWidth(0);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setEnabled(isEnabled());
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
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mImagePressed != 0)
      {
        setBackgroundResource(this.mBackgroundResouceNormal);
        setImageDrawable(getResources().getDrawable(this.mImageNormal));
      }
    }
    for (;;)
    {
      super.setEnabled(paramBoolean);
      return;
      setAlpha(mOpacityNormal);
      continue;
      if (this.mImagePressed != 0)
      {
        setBackgroundResource(this.mBackgroundResouceDisabled);
        setImageDrawable(getResources().getDrawable(this.mImageDisabled));
      }
      else
      {
        setAlpha(mOpacityDisabled);
      }
    }
  }
  
  public void setImageDrawable(int paramInt1, int paramInt2, int paramInt3)
  {
    setImageDrawable(getResources().getDrawable(paramInt1));
    this.mImageNormal = paramInt1;
    this.mImagePressed = paramInt2;
    this.mImageDisabled = paramInt3;
    if (this.mImagePressed != 0) {
      setOnTouchListener(this.onTouchListener);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    setBackgroundColor(0);
    if (!isEnabled()) {
      setAlpha(mOpacityDisabled);
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if ((Build.VERSION.SDK_INT > 11) && (isEnabled())) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = mOpacityPressed;; i = mOpacityNormal)
    {
      setAlpha(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMImageButton
 * JD-Core Version:    0.7.0.1
 */