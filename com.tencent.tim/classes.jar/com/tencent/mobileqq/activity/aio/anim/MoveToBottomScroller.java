package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import aqgz;
import auqs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import wnc;

public class MoveToBottomScroller
  implements Runnable
{
  public static int bPH = 50;
  a a;
  wnc b;
  private int bPG;
  int bPI = 0;
  int bPJ = 0;
  int bPK = 0;
  int baD = 0;
  private boolean beE;
  private boolean beF = true;
  int lastHeight = 0;
  ListView m;
  private float mCurrVelocity;
  float mDensity = 1.0F;
  private int mDistance;
  private int mDuration;
  int mMinimumVelocity;
  private boolean mRunning;
  private long mStartTime;
  private int mStatus;
  private int mTargetPosition;
  private float pM;
  private float pN;
  int screenHeight = 0;
  public int updateTime;
  
  public MoveToBottomScroller(ListView paramListView, wnc paramwnc)
  {
    this.m = paramListView;
    this.b = paramwnc;
    this.mMinimumVelocity = ViewConfiguration.get(this.m.getContext()).getScaledMinimumFlingVelocity();
    if (aqgz.getSystemTotalMemory() / 1048576L > 512L) {}
    for (;;)
    {
      this.beF = bool;
      this.mDensity = this.m.getResources().getDisplayMetrics().density;
      return;
      bool = false;
    }
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller run with mDistance: " + this.mDistance);
    }
    this.updateTime += 1;
    if (this.updateTime >= bPH)
    {
      this.m.setSelectionFromBottom(this.m.getCount() - 1, 0);
      stop();
      return;
    }
    int k = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    int j;
    switch (this.mStatus)
    {
    default: 
      i = 0;
      j = i - this.bPG;
      this.bPG = i;
      if (j >= 0) {
        break;
      }
    }
    for (int i = 0;; i = j)
    {
      if (this.m.getChildCount() - 1 > 0) {
        this.lastHeight = this.m.getChildAt(this.m.getChildCount() - 1).getHeight();
      }
      QLog.d("MoveToBottomScroller", 2, "run  delta=" + i);
      j = i;
      if (this.bPI < 2)
      {
        if (this.lastHeight > this.screenHeight) {
          break label763;
        }
        j = i;
        if (i < this.mDensity * 2.0F) {
          j = (int)(this.mDensity * 2.0F + 0.5D);
        }
      }
      for (;;)
      {
        try
        {
          bool = this.m.trackMotionScroll(-j, -j);
        }
        catch (Exception localException1)
        {
          label763:
          boolean bool = true;
        }
        try
        {
          QLog.d("MoveToBottomScroller", 2, "move delta=" + j);
          if (bool) {
            break label858;
          }
          i = this.m.getChildCount();
          j = this.m.mFirstPosition;
          if ((this.mStatus != 3) && (this.mStatus != 1) && (j + i - 1 >= this.mTargetPosition))
          {
            if (i < 2) {
              break label815;
            }
            this.mDistance = (this.m.getChildAt(i - 1).getBottom() - this.m.getChildAt(i - 2).getBottom());
            QLog.d("MoveToBottomScroller", 2, "at position mDistance=" + this.mDistance);
            this.mDuration = (800 - k);
            if (this.mDuration < 100) {
              this.mDuration = 100;
            }
            if (this.mDuration > 400) {
              this.mDuration = 400;
            }
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.bPG = 0;
            if ((this.mCurrVelocity * 1000.0F <= this.mMinimumVelocity) || (this.beE)) {
              break label840;
            }
            this.mStatus = 1;
            this.mCurrVelocity = (this.mDistance * 2.0F / this.mDuration);
            this.pM = (this.mCurrVelocity / this.mDuration);
            QLog.d("MoveToBottomScroller", 2, "at position mCurrVelocity=" + this.mCurrVelocity + "mCurrVelocity=" + this.mCurrVelocity + "mDuration=" + this.mDuration);
          }
          this.m.removeCallbacks(this);
          if (Build.VERSION.SDK_INT < 16) {
            break label848;
          }
          this.m.postOnAnimation(this);
          return;
        }
        catch (Exception localException2)
        {
          break label800;
        }
        this.mCurrVelocity = (this.pM * k);
        i = (int)(this.mCurrVelocity * k / 2.0F);
        break;
        i = (int)(this.pN * k - this.pN * 800.0F / 8.0F);
        break;
        if (k > this.mDuration)
        {
          i = this.mDistance;
          i = this.bPG;
          this.m.setSelectionFromBottom(this.m.getCount() - 1, 0);
          stop();
          return;
        }
        this.mCurrVelocity -= this.pM * k;
        i = (int)(this.mDistance - this.mCurrVelocity * (this.mDuration - k) / 2.0F);
        break;
        i = (int)(auqs.viscousFluid(k / this.mDuration) * this.mDistance);
        break;
        i = (int)(k / this.mDuration * this.mDistance);
        break;
        j = i;
        if (i > this.mDensity * 10.0F)
        {
          j = (int)(this.mDensity * 10.0F + 0.5D);
          continue;
          label800:
          QLog.d("MoveToBottomScroller", 2, localException1, new Object[0]);
          continue;
          label815:
          if (i == 1)
          {
            this.mDistance = this.m.getChildAt(i - 1).getBottom();
            continue;
            label840:
            this.mStatus = 3;
          }
        }
      }
      label848:
      this.m.post(this);
      return;
      label858:
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, "atEdge");
      }
      stop();
      return;
    }
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller start");
    }
    if (this.mRunning) {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, "start() mRunning, ignore request");
      }
    }
    for (;;)
    {
      return;
      this.mRunning = true;
      this.updateTime = 0;
      this.bPK = 0;
      if (!this.beF)
      {
        this.m.setSelection(this.m.getCount() - 1);
        stop();
        return;
      }
      if (this.m == null)
      {
        this.mRunning = false;
        return;
      }
      this.screenHeight = this.m.getResources().getDisplayMetrics().heightPixels;
      this.bPJ = this.m.mFirstPosition;
      this.baD = (this.bPJ + this.m.getChildCount() - 1);
      this.bPI = (this.m.getCount() - this.baD - 1);
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller start scrollCount: " + this.bPI);
      }
      if (this.bPI == 0)
      {
        if (this.m.getChildCount() < 1)
        {
          this.m.setSelection(this.m.getCount() - 1);
          this.mRunning = false;
          return;
        }
        this.mDistance = this.m.getChildAt(this.m.getChildCount() - 1).getBottom();
        if (this.mDistance == 0)
        {
          stop();
          return;
        }
        this.mDuration = 800;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.bPG = 0;
        this.mStatus = 3;
        this.m.removeCallbacks(this);
        if (Build.VERSION.SDK_INT >= 16) {
          this.m.postOnAnimation(this);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("MoveToBottomScroller", 2, new Object[] { "MoveToBottomScroller start end with mDistance: " + this.mDistance, " scrollCount: " + this.bPI });
        return;
        this.m.post(this);
        continue;
        int i = this.m.getChildCount();
        if (this.m.getChildCount() == 0) {
          i = 1;
        }
        int j;
        if ((this.m.getFooterViewsCount() > 0) && (this.b.bPw >= 0)) {
          if (this.bPI > 1)
          {
            j = this.bPI - 1;
            label453:
            this.bPI = j;
            this.mDistance = this.b.bPw;
            label469:
            j = this.mDistance;
            this.mDistance = (this.bPI * this.m.getHeight() / i + j);
            this.pN = (this.mDistance / 600.0F);
            this.pM = (this.pN / 200.0F);
            this.mCurrVelocity = 0.0F;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStatus = 0;
            this.bPG = 0;
            this.mTargetPosition = (this.m.getCount() - 1);
            if (this.bPI != 1) {
              break label610;
            }
          }
        }
        label610:
        for (boolean bool = true;; bool = false)
        {
          this.beE = bool;
          this.m.removeCallbacks(this);
          if (Build.VERSION.SDK_INT < 16) {
            break label615;
          }
          this.m.postOnAnimation(this);
          break;
          j = 0;
          break label453;
          this.mDistance = 0;
          break label469;
        }
        label615:
        this.m.post(this);
      }
    }
  }
  
  public void stop()
  {
    this.mRunning = false;
    if (this.a != null) {
      this.a.bZR();
    }
    this.m.removeCallbacks(this);
  }
  
  public static abstract interface a
  {
    public abstract void bZR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */