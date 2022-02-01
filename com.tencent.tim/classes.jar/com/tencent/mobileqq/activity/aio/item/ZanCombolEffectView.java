package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.immersion.stickersampleapp.HapticManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZanCombolEffectView
  extends View
{
  private long HN;
  private long Jo;
  private String aUG = "chat_item_for_likeplus";
  private int bWA = 1000;
  private int bWB;
  private boolean bgK;
  private int jD;
  private float jV = 1.0F;
  private float jW = 10.0F;
  private boolean mIsAnimating;
  private boolean mIsPause;
  private long mLastUpdateTime;
  private Matrix mMatrix = new Matrix();
  private int mMaxY;
  private Random mRandom = new Random(System.currentTimeMillis());
  private float qA;
  private float qy;
  private float qz;
  private List<Bitmap> rU = new ArrayList(5);
  private List<a> sh = new ArrayList();
  private List<a> si = new ArrayList();
  
  public ZanCombolEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZanCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ZanCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Dp(int paramInt)
  {
    if (this.rU.size() == 0) {
      return;
    }
    int i = 0;
    label16:
    a locala;
    float f1;
    if (i < paramInt)
    {
      locala = new a(null);
      locala.x = (getWidth() / 2);
      locala.rotate = this.mRandom.nextInt(360);
      f1 = this.mRandom.nextFloat();
      float f2 = this.qz;
      if (this.mRandom.nextFloat() <= 0.5D) {
        break label257;
      }
      j = 1;
      label90:
      locala.qD = (j * (f2 * f1));
      locala.bitmap = ((Bitmap)this.rU.get(this.mRandom.nextInt(this.rU.size())));
      locala.scale = 1.0F;
      locala.qC = (this.mRandom.nextFloat() * this.qA + this.jW);
      f1 = (float)(this.mRandom.nextFloat() * this.qA * 0.2D);
      if (this.mRandom.nextFloat() <= 0.5D) {
        break label263;
      }
    }
    label257:
    label263:
    for (int j = 1;; j = -1)
    {
      locala.qB = (j * f1 + this.jV * this.jV);
      locala.y = ((int)(-this.mMaxY * 0.12D));
      this.sh.add(locala);
      i += 1;
      break label16;
      break;
      j = -1;
      break label90;
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, boolean paramBoolean)
  {
    this.bWA = paramInt1;
    this.qy = paramFloat1;
    this.bWB = paramInt2;
    this.qz = paramFloat2;
    this.jW = paramFloat3;
    this.qA = paramFloat5;
    this.mMaxY = paramInt3;
    this.jV = paramFloat4;
    this.bgK = paramBoolean;
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  public void b(Integer... paramVarArgs)
  {
    post(new ZanCombolEffectView.1(this, paramVarArgs));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    if ((this.mIsPause) || (!this.mIsAnimating)) {}
    int k;
    int i;
    a locala;
    do
    {
      return;
      super.onDraw(paramCanvas);
      long l = System.currentTimeMillis();
      if ((l - this.HN < 800L) && (l - this.Jo > 10L))
      {
        Dp(1);
        this.Jo = l;
      }
      float f = (float)((l - this.mLastUpdateTime) * 1.0D / 1000.0D);
      this.mLastUpdateTime = l;
      k = this.sh.size();
      i = 0;
      if (i < k)
      {
        locala = (a)this.sh.get(i);
        locala.y = ((int)(locala.y + locala.qC * f));
        if (locala.y > this.mMaxY) {
          this.si.add(locala);
        }
        for (;;)
        {
          i += 1;
          break;
          locala.x = ((int)(locala.x + (2.0F * f * locala.qB + locala.qB * 0.02D)));
          locala.rotate += locala.qD * f;
        }
      }
      this.sh.removeAll(this.si);
      this.si.clear();
      k = this.sh.size();
      i = j;
      if (k != 0) {
        break;
      }
      this.mIsAnimating = false;
    } while (!this.bgK);
    HapticManager.a().X(this.jD);
    this.jD = 0;
    return;
    while (i < k)
    {
      locala = (a)this.sh.get(i);
      this.mMatrix.reset();
      this.mMatrix.setTranslate(-locala.bitmap.getWidth() / 2, -locala.bitmap.getHeight() / 2);
      this.mMatrix.postRotate(locala.rotate);
      this.mMatrix.preScale(locala.scale, locala.scale);
      this.mMatrix.postTranslate(locala.x, locala.y);
      paramCanvas.drawBitmap(locala.bitmap, this.mMatrix, null);
      i += 1;
    }
    invalidate();
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause = paramBoolean;
    if (this.mIsPause) {
      this.sh.clear();
    }
    if (this.mIsPause) {
      if (this.bgK) {
        HapticManager.a().V(this.jD);
      }
    }
    while (!this.bgK) {
      return;
    }
    HapticManager.a().W(this.jD);
  }
  
  static class a
  {
    Bitmap bitmap;
    float qB = 0.0F;
    float qC = 0.0F;
    float qD = 0.0F;
    float rotate = 0.0F;
    float scale;
    int x = 0;
    int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView
 * JD-Core Version:    0.7.0.1
 */