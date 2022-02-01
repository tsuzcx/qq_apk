package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;

public class GLScoreBoard
  extends GLFrameImage
{
  public static final int MAX_SCORE = 99999;
  private float heightBoard;
  private boolean mHasComputeWidth = false;
  private int mInterval;
  private float mNumberImageSlope = 0.25F;
  private RectF mNumberRegion = new RectF();
  private float mNumberWidthSize;
  private RectF mParentSize = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private int mScore;
  private RectF mScoreBoardSize = new RectF();
  private int[] number = new int[5];
  private float widthBoard;
  private float xOffsetFromParent = 0.0F;
  private float yOffsetFromParent = 0.0F;
  
  public GLScoreBoard(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    setTemporaryRelease(false);
  }
  
  private void computeNumberWidthSize()
  {
    if (!this.mHasComputeWidth)
    {
      GLImage localGLImage = getImageByIndex(0);
      this.mNumberWidthSize = (1.0F * localGLImage.getWidth() / localGLImage.getHeight() * this.mScoreBoardSize.height());
      this.mHasComputeWidth = true;
    }
  }
  
  private void computeOffsetFromParen()
  {
    this.xOffsetFromParent = (this.mScoreBoardSize.left - this.mParentSize.left);
    this.yOffsetFromParent = (this.mScoreBoardSize.top - this.mParentSize.top);
  }
  
  private void computeScoreNumberAndDraw()
  {
    int i = 1;
    this.mScoreBoardSize.left = (this.mParentSize.left + this.xOffsetFromParent);
    this.mScoreBoardSize.top = (this.mParentSize.top + this.yOffsetFromParent);
    this.mScoreBoardSize.right = (this.mScoreBoardSize.left + this.widthBoard);
    this.mScoreBoardSize.bottom = (this.mScoreBoardSize.top + this.heightBoard);
    this.number[4] = (this.mScore / 10000);
    int j = this.mScore % 10000;
    this.number[3] = (j / 1000);
    j %= 1000;
    this.number[2] = (j / 100);
    j %= 100;
    this.number[1] = (j / 10);
    this.number[0] = (j % 10);
    if (this.number[4] == 0) {
      if (this.number[3] == 0) {
        if (this.number[2] == 0) {
          if (this.number[1] != 0) {}
        }
      }
    }
    for (;;)
    {
      float f1 = i * this.mNumberWidthSize + (i - 1) * this.mInterval;
      float f4;
      float f3;
      float f2;
      if (this.mScoreBoardSize.width() >= f1)
      {
        f4 = this.mNumberWidthSize;
        f3 = this.mScoreBoardSize.top;
        f2 = this.mScoreBoardSize.bottom;
        f1 = (this.mScoreBoardSize.width() - f1) / 2.0F + this.mScoreBoardSize.left - this.mNumberImageSlope * f4;
        j = i;
        label285:
        if (j <= 0) {
          break label515;
        }
        if (j != i) {
          break label506;
        }
      }
      label506:
      for (int k = 0;; k = this.mInterval)
      {
        int m = this.number[(j - 1)];
        f1 = k + f1;
        this.mNumberRegion.set(f1, f3, f1 + f4, f2);
        super.setImageClipDrawRegion(this.mNumberRegion);
        super.setImageRegion(this.mNumberRegion);
        super.setCurrentImage(m);
        super.draw();
        f1 = this.mNumberRegion.right;
        j -= 1;
        break label285;
        f1 = (i - 1) * this.mInterval;
        f4 = (this.mScoreBoardSize.width() - f1) / i;
        GLImage localGLImage = getImageByIndex(0);
        f1 = 1.0F * localGLImage.getHeight() / localGLImage.getWidth() * f4;
        if (f1 >= this.mScoreBoardSize.height()) {
          f1 = this.mScoreBoardSize.top;
        }
        for (f2 = this.mScoreBoardSize.bottom;; f2 = this.mScoreBoardSize.bottom - f2)
        {
          float f5 = this.mScoreBoardSize.left;
          f3 = f1;
          f1 = f5;
          break;
          f2 = (this.mScoreBoardSize.height() - f1) / 2.0F;
          f1 = this.mScoreBoardSize.top + f2;
        }
      }
      label515:
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  public void changeParentSize(RectF paramRectF)
  {
    this.mParentSize.set(paramRectF);
  }
  
  public void draw()
  {
    computeNumberWidthSize();
    computeScoreNumberAndDraw();
  }
  
  public int getScore()
  {
    return this.mScore;
  }
  
  public void setNumberImageSlope(float paramFloat)
  {
    this.mNumberImageSlope = paramFloat;
  }
  
  public void setNumberInterval(int paramInt)
  {
    this.mInterval = paramInt;
  }
  
  public void setScore(int paramInt)
  {
    this.mScore = paramInt;
    if (this.mScore > 99999) {
      this.mScore = 99999;
    }
  }
  
  public void setScoreBoardSize(RectF paramRectF)
  {
    if (!this.mScoreBoardSize.equals(paramRectF))
    {
      this.mScoreBoardSize.set(paramRectF);
      this.widthBoard = this.mScoreBoardSize.width();
      this.heightBoard = this.mScoreBoardSize.height();
    }
    computeOffsetFromParen();
  }
  
  public void setScoreBoardSize(RectF paramRectF1, RectF paramRectF2)
  {
    this.mParentSize.set(paramRectF2);
    setScoreBoardSize(paramRectF1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard
 * JD-Core Version:    0.7.0.1
 */