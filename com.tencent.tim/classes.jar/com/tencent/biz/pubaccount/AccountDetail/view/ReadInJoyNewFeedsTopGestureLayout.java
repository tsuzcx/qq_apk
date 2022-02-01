package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.view.MotionEvent;
import aqgz;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

public class ReadInJoyNewFeedsTopGestureLayout
  extends AccountDetailTopGestureLayout
{
  public ReadInJoyNewFeedsTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void init(Context paramContext)
  {
    this.c = new a(paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.c);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public class a
    extends TopGestureLayout.TopGestureDetector
  {
    public a(Context paramContext)
    {
      super(paramContext);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((ReadInJoyNewFeedsTopGestureLayout.this.isGestureIdle()) || (ReadInJoyNewFeedsTopGestureLayout.this.isGestureEnd())) {
        return false;
      }
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
      int i;
      if (ReadInJoyNewFeedsTopGestureLayout.this.hasGestureFlag(1)) {
        if (paramMotionEvent1.getX() <= 0.2133333333333334D * aqgz.hK())
        {
          i = 1;
          if ((i != 0) && (paramFloat1 < 0.0F) && (paramFloat2 < 0.5F) && (ReadInJoyNewFeedsTopGestureLayout.this.mOnFlingGesture != null))
          {
            ReadInJoyNewFeedsTopGestureLayout.this.setGestureFlag(-1);
            if (!ReadInJoyNewFeedsTopGestureLayout.a(ReadInJoyNewFeedsTopGestureLayout.this)) {
              ReadInJoyNewFeedsTopGestureLayout.this.mOnFlingGesture.flingLToR();
            }
          }
        }
      }
      for (;;)
      {
        return false;
        i = 0;
        break;
        if ((ReadInJoyNewFeedsTopGestureLayout.this.hasGestureFlag(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F) && (ReadInJoyNewFeedsTopGestureLayout.this.mOnFlingGesture != null))
        {
          ReadInJoyNewFeedsTopGestureLayout.this.setGestureFlag(-1);
          if (!ReadInJoyNewFeedsTopGestureLayout.b(ReadInJoyNewFeedsTopGestureLayout.this)) {
            ReadInJoyNewFeedsTopGestureLayout.this.mOnFlingGesture.flingRToL();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */