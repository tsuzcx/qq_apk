package com.tencent.qqmail.attachment.view;

import com.tencent.qqmail.attachment.activity.ImagePagerActivity;
import com.tencent.qqmail.view.imageview.GestureImageViewListener;

public class FtnGestureImageViewListener
  implements GestureImageViewListener
{
  private float boundaryLeft = -1.0F;
  private float boundaryRight = -1.0F;
  private float diffX;
  private ImagePagerActivity imagePagerActivity;
  private boolean isOriginalSize = true;
  private boolean isScaleShrink = false;
  private float lastX;
  private float lastY;
  
  public FtnGestureImageViewListener(ImagePagerActivity paramImagePagerActivity)
  {
    this.imagePagerActivity = paramImagePagerActivity;
  }
  
  private boolean isBoundary()
  {
    return this.boundaryLeft == 0.0F;
  }
  
  private boolean isMoveToBorder()
  {
    if ((this.diffX == 0.0F) && ((this.lastX == this.boundaryLeft) || (this.lastX == this.boundaryRight))) {}
    while ((this.diffX == 0.0F) && (this.lastX != this.boundaryLeft) && (this.lastX != this.boundaryRight) && (this.boundaryLeft > 0.0F)) {
      return true;
    }
    return false;
  }
  
  private boolean isOriginalSize()
  {
    return this.isOriginalSize;
  }
  
  private boolean isScaleShrink()
  {
    return this.isScaleShrink;
  }
  
  private void setOriginalSize(boolean paramBoolean)
  {
    this.isOriginalSize = paramBoolean;
  }
  
  private void setScaleShrink(boolean paramBoolean)
  {
    this.isScaleShrink = paramBoolean;
  }
  
  public void onFling()
  {
    if (isMoveToBorder()) {
      this.imagePagerActivity.setPagingEnable(true);
    }
  }
  
  public void onPosition(float paramFloat1, float paramFloat2)
  {
    this.diffX = (paramFloat1 - this.lastX);
    if ((isOriginalSize()) || (isBoundary()))
    {
      this.imagePagerActivity.setPagingEnable(true);
      this.lastX = paramFloat1;
      this.lastY = paramFloat2;
      return;
    }
    if ((isMoveToBorder()) || (isScaleShrink())) {
      this.imagePagerActivity.setPagingEnable(true);
    }
    for (;;)
    {
      this.lastX = paramFloat1;
      this.lastY = paramFloat2;
      return;
      this.imagePagerActivity.setPagingEnable(false);
    }
  }
  
  public void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= 1.0F)
    {
      setScaleShrink(true);
      this.imagePagerActivity.setPagingEnable(true);
      if (paramFloat1 != 1.0F) {
        break label57;
      }
      setOriginalSize(true);
      this.imagePagerActivity.setPagingEnable(true);
    }
    for (;;)
    {
      this.boundaryLeft = paramFloat2;
      this.boundaryRight = paramFloat3;
      return;
      setScaleShrink(false);
      break;
      label57:
      setOriginalSize(false);
    }
  }
  
  public void onTouch(float paramFloat1, float paramFloat2) {}
  
  public void resetStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.view.FtnGestureImageViewListener
 * JD-Core Version:    0.7.0.1
 */