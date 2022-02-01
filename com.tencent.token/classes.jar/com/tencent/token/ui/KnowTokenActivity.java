package com.tencent.token.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.token.aap;
import com.tencent.token.zd;
import com.tencent.token.zd.a;

public class KnowTokenActivity
  extends BaseActivity
  implements zd.a
{
  private static final int BTN_HEIGHT = 45;
  private static final int BTN_WIDTH = 200;
  private static final int FLING_MIN_DISTANCE = 0;
  private static final int IMAGE_LEVEL_COUNT = 0;
  private static final int[] mBitmapIds = new int[0];
  private int DOT_OFFSET_X;
  private int DOT_OFFSET_Y;
  private int DOT_SIZE;
  private GestureDetector mDetector = new GestureDetector(new GestureDetector.OnGestureListener()
  {
    public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
    
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      try
      {
        if (paramAnonymousMotionEvent1.getX() - paramAnonymousMotionEvent2.getX() > 0.0F)
        {
          if (KnowTokenActivity.this.mLevel < KnowTokenActivity.IMAGE_LEVEL_COUNT - 1)
          {
            paramAnonymousMotionEvent1 = aap.a(KnowTokenActivity.this, KnowTokenActivity.mBitmapIds[KnowTokenActivity.access$004(KnowTokenActivity.this)], KnowTokenActivity.this.mLowQuality);
            if (paramAnonymousMotionEvent1 == null)
            {
              KnowTokenActivity.this.doOutOfMemory();
              return true;
            }
            KnowTokenActivity.this.mPageCurlView.a(paramAnonymousMotionEvent1);
            if ((KnowTokenActivity.this.mLevel == KnowTokenActivity.IMAGE_LEVEL_COUNT - 1) && (KnowTokenActivity.this.mEndBtn != null))
            {
              KnowTokenActivity.this.mEndBtn.setVisibility(0);
              return true;
            }
          }
          else
          {
            KnowTokenActivity.this.finish();
            return true;
          }
        }
        else if ((paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX() > 0.0F) && (KnowTokenActivity.this.mLevel > 0))
        {
          paramAnonymousMotionEvent1 = aap.a(KnowTokenActivity.this, KnowTokenActivity.mBitmapIds[KnowTokenActivity.access$006(KnowTokenActivity.this)], KnowTokenActivity.this.mLowQuality);
          if (paramAnonymousMotionEvent1 == null)
          {
            KnowTokenActivity.this.doOutOfMemory();
            return true;
          }
          KnowTokenActivity.this.mPageCurlView.b(paramAnonymousMotionEvent1);
          if (KnowTokenActivity.this.mEndBtn != null)
          {
            KnowTokenActivity.this.mEndBtn.setVisibility(8);
            return true;
          }
        }
      }
      catch (Exception paramAnonymousMotionEvent1)
      {
        paramAnonymousMotionEvent1.printStackTrace();
        KnowTokenActivity.this.doOutOfMemory();
        return true;
      }
      catch (OutOfMemoryError paramAnonymousMotionEvent1)
      {
        paramAnonymousMotionEvent1.printStackTrace();
        KnowTokenActivity.this.doOutOfMemory();
      }
      return true;
    }
    
    public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
    
    public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return false;
    }
    
    public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
    
    public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
  });
  private Bitmap mDotEmpty;
  private Bitmap mDotFull;
  private Button mEndBtn;
  private int mHeight;
  private int mLevel = 0;
  private boolean mLowQuality;
  private zd mPageCurlView;
  private int mWidth;
  
  private void doOutOfMemory()
  {
    Object localObject = this.mDotEmpty;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.mDotEmpty = null;
    localObject = this.mDotFull;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.mDotFull = null;
    localObject = this.mPageCurlView;
    if (localObject != null) {
      ((zd)localObject).b();
    }
    this.mPageCurlView = null;
    finish();
  }
  
  private void drawDots(int paramInt, Canvas paramCanvas)
  {
    int j = this.DOT_OFFSET_X;
    int i = 0;
    while (i < IMAGE_LEVEL_COUNT)
    {
      if (i == paramInt) {
        paramCanvas.drawBitmap(this.mDotEmpty, j, this.DOT_OFFSET_Y, null);
      } else {
        paramCanvas.drawBitmap(this.mDotFull, j, this.DOT_OFFSET_Y, null);
      }
      j += this.DOT_SIZE * 2;
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    try
    {
      this.mDotEmpty = BitmapFactory.decodeResource(getResources(), 2131099823);
      this.mDotFull = BitmapFactory.decodeResource(getResources(), 2131099824);
      paramBundle = getWindowManager().getDefaultDisplay();
      this.mWidth = paramBundle.getWidth();
      this.mHeight = paramBundle.getHeight();
      this.DOT_SIZE = this.mDotEmpty.getWidth();
      this.DOT_OFFSET_X = ((this.mWidth - IMAGE_LEVEL_COUNT * 2 * this.DOT_SIZE + this.DOT_SIZE) / 2);
      this.DOT_OFFSET_Y = (this.mHeight * 9 / 10);
      this.mLowQuality = aap.a(this.mWidth, this.mHeight);
      this.mPageCurlView = new zd(this, this, this.mWidth, this.mHeight);
      this.mPageCurlView.setBackgroundColor(getResources().getColor(2130968713));
      paramBundle = new RelativeLayout(this);
      paramBundle.addView(this.mPageCurlView, new ViewGroup.LayoutParams(-1, -1));
      Object localObject1 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      this.mEndBtn = new Button(this);
      this.mEndBtn.setBackgroundResource(2131099855);
      Object localObject2 = new RelativeLayout.LayoutParams((int)(((DisplayMetrics)localObject1).density * 200.0F), (int)(((DisplayMetrics)localObject1).density * 45.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(((DisplayMetrics)localObject1).density * 110.0F));
      this.mEndBtn.setVisibility(8);
      this.mEndBtn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          KnowTokenActivity.this.mEndBtn.setEnabled(false);
          KnowTokenActivity.this.finish();
        }
      });
      this.mEndBtn.setGravity(17);
      paramBundle.addView(this.mEndBtn, (ViewGroup.LayoutParams)localObject2);
      localObject1 = aap.a(this, mBitmapIds[0], this.mLowQuality);
      if ((localObject1 != null) && (this.mDotEmpty != null) && (this.mDotFull != null))
      {
        localObject2 = this.mPageCurlView;
        ((zd)localObject2).a = ((Bitmap)localObject1);
        ((zd)localObject2).b = null;
        this.mPageCurlView.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if ((paramAnonymousView == KnowTokenActivity.this.mPageCurlView) && (paramAnonymousMotionEvent.getAction() == 0))
            {
              paramAnonymousView = KnowTokenActivity.this.mPageCurlView;
              if (!paramAnonymousView.i.isFinished())
              {
                paramAnonymousView.i.abortAnimation();
                if (paramAnonymousView.k != null) {
                  paramAnonymousView.k.onNextPage(paramAnonymousView.j);
                }
                if (paramAnonymousView.a != null) {
                  paramAnonymousView.a.recycle();
                }
                paramAnonymousView.a = paramAnonymousView.b;
                paramAnonymousView.b = null;
                paramAnonymousView.a();
              }
            }
            return false;
          }
        });
        setContentView(paramBundle);
        hideTitle();
        return;
      }
      doOutOfMemory();
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      doOutOfMemory();
      return;
    }
    catch (OutOfMemoryError paramBundle)
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