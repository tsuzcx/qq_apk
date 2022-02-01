package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FloatingScreenParams
  implements Cloneable
{
  static final int DEFAULT_LENGTH = 500;
  public static final float DEFAULT_SCREEN_RATIO = 0.5625F;
  public static final int SHAPE_HORIZONTAL = 1;
  public static final int SHAPE_SQUARE = 3;
  public static final int SHAPE_VERTICAL = 2;
  private static boolean mShowPadding = true;
  private boolean mCanMove = true;
  private int mFloatingCenterX;
  private int mFloatingCenterY = 200;
  private int mHeight;
  private int mOuterPadding = 2;
  private int mRoundCorner = 12;
  private int mScreenLonger = 500;
  private float mScreenRatio = 0.5625F;
  private int mShapeType = 1;
  private int mSquareLength = 300;
  private int mWidth;
  
  private FloatingScreenParams()
  {
    initParam();
  }
  
  private void setCanMove(boolean paramBoolean)
  {
    this.mCanMove = paramBoolean;
  }
  
  private void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  private void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public FloatingScreenParams clone()
  {
    try
    {
      FloatingScreenParams localFloatingScreenParams = (FloatingScreenParams)super.clone();
      return localFloatingScreenParams;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  boolean getCanMove()
  {
    return this.mCanMove;
  }
  
  int getFloatingCenterX()
  {
    return this.mFloatingCenterX;
  }
  
  int getFloatingCenterY()
  {
    return this.mFloatingCenterY;
  }
  
  int getHeight()
  {
    return this.mHeight;
  }
  
  public int getInnerRoundCorner()
  {
    if (mShowPadding) {
      return this.mRoundCorner - this.mOuterPadding;
    }
    return this.mRoundCorner;
  }
  
  int getOuterHeight()
  {
    if (mShowPadding) {
      return this.mHeight + this.mOuterPadding * 2;
    }
    return this.mHeight;
  }
  
  public int getOuterRoundCorner()
  {
    return this.mRoundCorner;
  }
  
  int getOuterWidth()
  {
    if (mShowPadding) {
      return this.mWidth + this.mOuterPadding * 2;
    }
    return this.mWidth;
  }
  
  int getRoundCorner()
  {
    return this.mRoundCorner;
  }
  
  public float getScreenRatio()
  {
    return this.mScreenRatio;
  }
  
  int getShapeType()
  {
    return this.mShapeType;
  }
  
  int getWidth()
  {
    return this.mWidth;
  }
  
  public void initParam()
  {
    Object localObject = BaseApplicationImpl.sApplication.getResources();
    if (localObject != null)
    {
      this.mScreenLonger = ((Resources)localObject).getDimensionPixelSize(2131298932);
      this.mSquareLength = ((Resources)localObject).getDimensionPixelSize(2131298934);
      this.mRoundCorner = ((Resources)localObject).getDimensionPixelSize(2131298933);
      this.mOuterPadding = ((Resources)localObject).getDimensionPixelSize(2131298935);
    }
    this.mWidth = this.mScreenLonger;
    this.mHeight = ((int)(this.mWidth * this.mScreenRatio));
    if (QLog.isColorLevel()) {
      QLog.d("FSParams", 2, new Object[] { "param corner:", Integer.valueOf(this.mRoundCorner), ", pad:", Integer.valueOf(this.mOuterPadding), ", width:", Integer.valueOf(this.mWidth), ", height:", Integer.valueOf(this.mHeight) });
    }
    localObject = (WindowManager)BaseApplicationImpl.sApplication.getSystemService("window");
    if (localObject != null)
    {
      i = ((WindowManager)localObject).getDefaultDisplay().getHeight();
      if (i / 2 - 214 - this.mHeight / 2 <= 0) {
        break label217;
      }
    }
    label217:
    for (int i = i / 2 - 214 - this.mHeight / 2;; i = 200)
    {
      this.mFloatingCenterY = i;
      return;
    }
  }
  
  public void setFloatingCenterX(int paramInt)
  {
    this.mFloatingCenterX = paramInt;
  }
  
  public void setFloatingCenterY(int paramInt)
  {
    this.mFloatingCenterY = paramInt;
  }
  
  public void setScreenRatio(float paramFloat)
  {
    if (this.mScreenRatio != paramFloat)
    {
      this.mScreenRatio = paramFloat;
      setShapeType(this.mShapeType);
    }
  }
  
  void setShapeType(int paramInt)
  {
    int i;
    if (paramInt >= 1)
    {
      i = paramInt;
      if (paramInt <= 3) {}
    }
    else
    {
      i = 1;
    }
    this.mShapeType = i;
    switch (i)
    {
    default: 
      return;
    case 1: 
      setWidth(this.mScreenLonger);
      setHeight((int)(this.mScreenLonger * this.mScreenRatio));
      return;
    case 2: 
      setWidth((int)(this.mScreenLonger * this.mScreenRatio));
      setHeight(this.mScreenLonger);
      return;
    }
    setWidth(this.mSquareLength);
    setHeight(this.mSquareLength);
  }
  
  void setShowPadding(boolean paramBoolean)
  {
    mShowPadding = paramBoolean;
  }
  
  public static class FloatingBuilder
  {
    private static final int INVALID_FLOATING_XY = -2147483648;
    private boolean canMove = true;
    private int floatingCenterX = -2147483648;
    private int floatingCenterY = -2147483648;
    private float ratio = 0.5625F;
    private int shapeType;
    
    public FloatingScreenParams build()
    {
      FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams(null);
      localFloatingScreenParams.setScreenRatio(this.ratio);
      localFloatingScreenParams.setShapeType(this.shapeType);
      localFloatingScreenParams.setCanMove(this.canMove);
      if (this.floatingCenterX != -2147483648) {
        localFloatingScreenParams.setFloatingCenterX(this.floatingCenterX);
      }
      if (this.floatingCenterY != -2147483648) {
        localFloatingScreenParams.setFloatingCenterY(this.floatingCenterY);
      }
      return localFloatingScreenParams;
    }
    
    public FloatingBuilder setCanMove(boolean paramBoolean)
    {
      this.canMove = paramBoolean;
      return this;
    }
    
    public FloatingBuilder setFloatingCenterX(int paramInt)
    {
      this.floatingCenterX = paramInt;
      return this;
    }
    
    public FloatingBuilder setFloatingCenterY(int paramInt)
    {
      this.floatingCenterY = paramInt;
      return this;
    }
    
    public FloatingBuilder setIsHorizontal(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 2) {
        return setShapeType(i);
      }
    }
    
    public FloatingBuilder setRatio(float paramFloat)
    {
      if (paramFloat > 0.0F)
      {
        this.ratio = paramFloat;
        return this;
      }
      this.ratio = 0.5625F;
      return this;
    }
    
    public FloatingBuilder setShapeType(int paramInt)
    {
      this.shapeType = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams
 * JD-Core Version:    0.7.0.1
 */