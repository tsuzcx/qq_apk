package com.tencent.qqmail.qmui.popup;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class QMUIPopup
  extends QMUIBasePopup
{
  public static final int ANIM_AUTO = 5;
  public static final int ANIM_GROW_FROM_CENTER = 3;
  public static final int ANIM_GROW_FROM_LEFT = 1;
  public static final int ANIM_GROW_FROM_RIGHT = 2;
  public static final int ANIM_REFLECT = 4;
  public static final int DIRECTION_BOTTOM = 1;
  public static final int DIRECTION_NONE = 2;
  public static final int DIRECTION_TOP = 0;
  protected int mAnimStyle = 5;
  protected int mArrowCenter;
  protected ImageView mArrowDown;
  protected ImageView mArrowUp;
  protected int mDirection;
  protected LayoutInflater mInflater;
  private int mOffsetX = 0;
  private int mOffsetYWhenBottom = 0;
  private int mOffsetYWhenTop = 0;
  private int mPopupLeftRightMinMargin = 0;
  private int mPopupTopBottomMinMargin = 0;
  private int mPreferedDirection;
  protected int mX = -1;
  protected int mY = -1;
  
  public QMUIPopup(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mInflater = LayoutInflater.from(paramContext);
    this.mPreferedDirection = paramInt;
    this.mDirection = this.mPreferedDirection;
  }
  
  private void calculatePosition(View paramView)
  {
    if (paramView != null)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      this.mArrowCenter = (arrayOfInt[0] + paramView.getWidth() / 2);
      if (this.mArrowCenter < this.mScreenSize.x / 2) {
        if (this.mArrowCenter - this.mWindowWidth / 2 > this.mPopupLeftRightMinMargin)
        {
          this.mX = (this.mArrowCenter - this.mWindowWidth / 2);
          this.mDirection = this.mPreferedDirection;
        }
      }
      switch (this.mPreferedDirection)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          do
          {
            return;
            this.mX = this.mPopupLeftRightMinMargin;
            break;
            if (this.mArrowCenter + this.mWindowWidth / 2 < this.mScreenSize.x - this.mPopupLeftRightMinMargin)
            {
              this.mX = (this.mArrowCenter - this.mWindowWidth / 2);
              break;
            }
            this.mX = (this.mScreenSize.x - this.mPopupLeftRightMinMargin - this.mWindowWidth);
            break;
            this.mY = (arrayOfInt[1] - this.mWindowHeight);
          } while (this.mY >= this.mPopupTopBottomMinMargin);
          this.mY = (arrayOfInt[1] + paramView.getHeight());
          this.mDirection = 1;
          return;
          this.mY = (arrayOfInt[1] + paramView.getHeight());
        } while (this.mY <= this.mScreenSize.y - this.mPopupTopBottomMinMargin);
        this.mY = (arrayOfInt[1] - this.mWindowHeight);
        this.mDirection = 0;
        return;
      }
      this.mY = arrayOfInt[1];
      return;
    }
    this.mX = ((this.mScreenSize.x - this.mWindowWidth) / 2);
    this.mY = ((this.mScreenSize.y - this.mWindowHeight) / 2);
    this.mDirection = 2;
  }
  
  private void setAnimationStyle(int paramInt1, int paramInt2)
  {
    int j = 2131755062;
    int k = 2131755061;
    int m = 2131755059;
    int i = paramInt2;
    if (this.mArrowUp != null) {
      i = paramInt2 - this.mArrowUp.getMeasuredWidth() / 2;
    }
    if (this.mDirection == 0) {}
    for (paramInt2 = 1;; paramInt2 = 0) {
      switch (this.mAnimStyle)
      {
      default: 
        return;
      }
    }
    PopupWindow localPopupWindow = this.mWindow;
    if (paramInt2 != 0) {}
    for (paramInt1 = 2131755062;; paramInt1 = 2131755057)
    {
      localPopupWindow.setAnimationStyle(paramInt1);
      return;
    }
    localPopupWindow = this.mWindow;
    if (paramInt2 != 0) {}
    for (paramInt1 = 2131755064;; paramInt1 = 2131755059)
    {
      localPopupWindow.setAnimationStyle(paramInt1);
      return;
    }
    localPopupWindow = this.mWindow;
    if (paramInt2 != 0) {}
    for (paramInt1 = 2131755061;; paramInt1 = 2131755056)
    {
      localPopupWindow.setAnimationStyle(paramInt1);
      return;
    }
    localPopupWindow = this.mWindow;
    if (paramInt2 != 0) {}
    for (paramInt1 = 2131755063;; paramInt1 = 2131755058)
    {
      localPopupWindow.setAnimationStyle(paramInt1);
      return;
    }
    if (i <= paramInt1 / 4)
    {
      localPopupWindow = this.mWindow;
      if (paramInt2 != 0) {}
      for (paramInt1 = j;; paramInt1 = 2131755057)
      {
        localPopupWindow.setAnimationStyle(paramInt1);
        return;
      }
    }
    if ((i > paramInt1 / 4) && (i < paramInt1 / 4 * 3))
    {
      localPopupWindow = this.mWindow;
      if (paramInt2 != 0) {}
      for (paramInt1 = k;; paramInt1 = 2131755056)
      {
        localPopupWindow.setAnimationStyle(paramInt1);
        return;
      }
    }
    localPopupWindow = this.mWindow;
    paramInt1 = m;
    if (paramInt2 != 0) {
      paramInt1 = 2131755064;
    }
    localPopupWindow.setAnimationStyle(paramInt1);
  }
  
  private void setViewVisibility(View paramView, boolean paramBoolean)
  {
    if (paramView != null) {
      if (!paramBoolean) {
        break label16;
      }
    }
    label16:
    for (int i = 0;; i = 4)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  private void showArrow()
  {
    ImageView localImageView = null;
    switch (this.mDirection)
    {
    }
    for (;;)
    {
      if (localImageView != null)
      {
        int i = this.mArrowUp.getMeasuredWidth();
        ((ViewGroup.MarginLayoutParams)localImageView.getLayoutParams()).leftMargin = (this.mArrowCenter - this.mX - i / 2);
      }
      return;
      setViewVisibility(this.mArrowUp, true);
      setViewVisibility(this.mArrowDown, false);
      localImageView = this.mArrowUp;
      continue;
      setViewVisibility(this.mArrowDown, true);
      setViewVisibility(this.mArrowUp, false);
      localImageView = this.mArrowDown;
      continue;
      setViewVisibility(this.mArrowDown, false);
      setViewVisibility(this.mArrowUp, false);
    }
  }
  
  protected Point onShow(View paramView)
  {
    calculatePosition(paramView);
    showArrow();
    setAnimationStyle(this.mScreenSize.x, this.mArrowCenter);
    int i = 0;
    if (this.mDirection == 0) {
      i = this.mOffsetYWhenTop;
    }
    for (;;)
    {
      return new Point(this.mX + this.mOffsetX, i + this.mY);
      if (this.mDirection == 1) {
        i = this.mOffsetYWhenBottom;
      }
    }
  }
  
  public void setAnimStyle(int paramInt)
  {
    this.mAnimStyle = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(2131561148, null, false);
    this.mArrowDown = ((ImageView)localFrameLayout.findViewById(2131362986));
    this.mArrowUp = ((ImageView)localFrameLayout.findViewById(2131362999));
    ((FrameLayout)localFrameLayout.findViewById(2131363712)).addView(paramView);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.setContentView(localFrameLayout);
  }
  
  public void setPopupLeftRightMinMargin(int paramInt)
  {
    this.mPopupLeftRightMinMargin = paramInt;
  }
  
  public void setPopupTopBottomMinMargin(int paramInt)
  {
    this.mPopupTopBottomMinMargin = paramInt;
  }
  
  public void setPositionOffsetX(int paramInt)
  {
    this.mOffsetX = paramInt;
  }
  
  public void setPositionOffsetYWhenBottom(int paramInt)
  {
    this.mOffsetYWhenBottom = paramInt;
  }
  
  public void setPositionOffsetYWhenTop(int paramInt)
  {
    this.mOffsetYWhenTop = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.popup.QMUIPopup
 * JD-Core Version:    0.7.0.1
 */