package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import aurf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import jug;
import mqq.os.MqqHandler;

public class AccountDetailBannerViewPager
  extends ViewPager
  implements Handler.Callback
{
  private AccountDetailBannerIndicator a;
  private final int aDy = 2000;
  private final int aDz = 1;
  private boolean abO;
  private MqqHandler g = new aurf(Looper.getMainLooper(), this, true);
  private ViewPager.OnPageChangeListener mOnPageChangeListener = new jug(this);
  private List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
  private int mScrollState = 0;
  
  public AccountDetailBannerViewPager(Context paramContext)
  {
    super(paramContext);
    super.setOnPageChangeListener(this.mOnPageChangeListener);
  }
  
  public AccountDetailBannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnPageChangeListener(this.mOnPageChangeListener);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBannerViewPager", 2, "handleMessage->" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.g.removeMessages(1);
    if (this.mScrollState == 0)
    {
      int i = getCurrentItem() + 1;
      setCurrentItem(i, true);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "setCurrentItem->" + i);
      }
    }
    this.g.sendEmptyMessageDelayed(1, 2000L);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mScrollState == 1) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mScrollState == 1) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.abO)
    {
      if ((paramMotionEvent.getActionMasked() != 0) && (paramMotionEvent.getActionMasked() != 2)) {
        break label68;
      }
      this.g.removeMessages(1);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->stopAutoScroll");
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label68:
      if (paramMotionEvent.getActionMasked() == 1)
      {
        this.g.sendEmptyMessageDelayed(1, 2000L);
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->startAutoScroll");
        }
      }
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    super.setAdapter(paramPagerAdapter);
    if ((getAdapter() != null) && (getAdapter().getCount() > 1))
    {
      this.abO = true;
      this.g.sendEmptyMessageDelayed(1, 2000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "setAdapter->startAutoScroll");
      }
      return;
    }
    this.abO = false;
  }
  
  public void setIndicator(AccountDetailBannerIndicator paramAccountDetailBannerIndicator)
  {
    this.a = paramAccountDetailBannerIndicator;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewPager
 * JD-Core Version:    0.7.0.1
 */