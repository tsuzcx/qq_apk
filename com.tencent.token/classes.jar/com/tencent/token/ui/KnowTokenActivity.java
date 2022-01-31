package com.tencent.token.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.ui.base.cf;
import com.tencent.token.ui.base.cg;
import com.tencent.token.utils.t;

public class KnowTokenActivity
  extends BaseActivity
  implements cg
{
  private static final int BTN_HEIGHT = 45;
  private static final int BTN_WIDTH = 200;
  private static final int FLING_MIN_DISTANCE = 0;
  private static final int IMAGE_LEVEL_COUNT;
  private static final int[] mBitmapIds;
  private int DOT_OFFSET_X;
  private int DOT_OFFSET_Y;
  private int DOT_SIZE;
  private GestureDetector mDetector = new GestureDetector(new nt(this));
  private Bitmap mDotEmpty;
  private Bitmap mDotFull;
  private Button mEndBtn;
  private int mHeight;
  private int mLevel = 0;
  private boolean mLowQuality;
  private cf mPageCurlView;
  private int mWidth;
  
  static
  {
    int[] arrayOfInt = new int[0];
    mBitmapIds = arrayOfInt;
    IMAGE_LEVEL_COUNT = arrayOfInt.length;
  }
  
  private void doOutOfMemory()
  {
    if (this.mDotEmpty != null) {
      this.mDotEmpty.recycle();
    }
    this.mDotEmpty = null;
    if (this.mDotFull != null) {
      this.mDotFull.recycle();
    }
    this.mDotFull = null;
    if (this.mPageCurlView != null) {
      this.mPageCurlView.b();
    }
    this.mPageCurlView = null;
    finish();
  }
  
  private void drawDots(int paramInt, Canvas paramCanvas)
  {
    int j = this.DOT_OFFSET_X;
    int i = 0;
    if (i < IMAGE_LEVEL_COUNT)
    {
      if (i == paramInt) {
        paramCanvas.drawBitmap(this.mDotEmpty, j, this.DOT_OFFSET_Y, null);
      }
      for (;;)
      {
        j += this.DOT_SIZE * 2;
        i += 1;
        break;
        paramCanvas.drawBitmap(this.mDotFull, j, this.DOT_OFFSET_Y, null);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    try
    {
      this.mDotEmpty = BitmapFactory.decodeResource(getResources(), 2130837592);
      this.mDotFull = BitmapFactory.decodeResource(getResources(), 2130837593);
      paramBundle = getWindowManager().getDefaultDisplay();
      this.mWidth = paramBundle.getWidth();
      this.mHeight = paramBundle.getHeight();
      this.DOT_SIZE = this.mDotEmpty.getWidth();
      this.DOT_OFFSET_X = ((this.mWidth - IMAGE_LEVEL_COUNT * 2 * this.DOT_SIZE + this.DOT_SIZE) / 2);
      this.DOT_OFFSET_Y = (this.mHeight * 9 / 10);
      this.mLowQuality = t.a(this.mWidth, this.mHeight);
      this.mPageCurlView = new cf(this, this, this.mWidth, this.mHeight);
      this.mPageCurlView.setBackgroundColor(getResources().getColor(2131165185));
      paramBundle = new RelativeLayout(this);
      paramBundle.addView(this.mPageCurlView, new ViewGroup.LayoutParams(-1, -1));
      Object localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.mEndBtn = new Button(this);
      this.mEndBtn.setBackgroundResource(2130837621);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(200.0F * ((DisplayMetrics)localObject).density), (int)(45.0F * ((DisplayMetrics)localObject).density));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.bottomMargin = ((int)(((DisplayMetrics)localObject).density * 110.0F));
      this.mEndBtn.setVisibility(8);
      this.mEndBtn.setOnClickListener(new nu(this));
      this.mEndBtn.setGravity(17);
      paramBundle.addView(this.mEndBtn, localLayoutParams);
      localObject = t.a(this, mBitmapIds[0], this.mLowQuality);
      if ((localObject == null) || (this.mDotEmpty == null) || (this.mDotFull == null))
      {
        doOutOfMemory();
        return;
      }
      this.mPageCurlView.a((Bitmap)localObject);
      this.mPageCurlView.setOnTouchListener(new nv(this));
      setContentView(paramBundle);
      hideTitle();
      return;
    }
    catch (OutOfMemoryError paramBundle)
    {
      paramBundle.printStackTrace();
      doOutOfMemory();
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      doOutOfMemory();
    }
  }
  
  public void onDrawDots(Canvas paramCanvas, boolean paramBoolean)
  {
    drawDots(this.mLevel, paramCanvas);
  }
  
  public void onDrawDotsBack(Canvas paramCanvas, boolean paramBoolean)
  {
    drawDots(this.mLevel, paramCanvas);
  }
  
  public void onNextPage(boolean paramBoolean) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.KnowTokenActivity
 * JD-Core Version:    0.7.0.1
 */