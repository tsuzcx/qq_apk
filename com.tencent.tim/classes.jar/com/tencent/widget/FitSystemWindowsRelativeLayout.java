package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ankt;
import autq;
import autr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;
import wja;
import xks;

public class FitSystemWindowsRelativeLayout
  extends RelativeLayout
  implements Handler.Callback
{
  View.OnTouchListener F = new autq(this);
  GreatMoveCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = null;
  HeartBreakCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = null;
  HeartCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = null;
  ZanCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = null;
  SixCombolEffectView jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = null;
  private a jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a;
  private b jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b;
  public boolean dkq;
  public DiniFlyAnimationView o = null;
  private int[] tw = new int[4];
  View xu = new View(getContext());
  
  public FitSystemWindowsRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(11)
  public FitSystemWindowsRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FitSystemWindowsRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private QQAppInterface getQQAppInterface()
  {
    Object localObject = getContext();
    if ((localObject instanceof BaseActivity)) {
      return ((BaseActivity)localObject).app;
    }
    localObject = BaseActivity.sTopActivity;
    if (localObject != null) {
      return ((BaseActivity)localObject).app;
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      return (QQAppInterface)localObject;
    }
    return null;
  }
  
  public GreatMoveCombolEffectView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = new GreatMoveCombolEffectView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView, localLayoutParams);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView;
  }
  
  public SixCombolEffectView a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = new SixCombolEffectView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = ankt.dip2px(50.0F);
      localLayoutParams.addRule(8, 2131370537);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131364469);
      localViewGroup.removeView(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView);
      localViewGroup.addView(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView, localLayoutParams);
    }
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("placeholder", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "]");
    }
    boolean bool = false;
    if (this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a != null) {
      bool = this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a.dispatchTouchEvent(paramMotionEvent);
    }
    if (bool) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.tw[0] = paramRect.left;
      this.tw[1] = paramRect.top;
      this.tw[2] = paramRect.right;
      paramRect.left = 0;
      paramRect.top = 0;
      paramRect.right = 0;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 8: 
    case 11: 
    case 17: 
    default: 
    case 7: 
    case 9: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 18: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return false;
                                  if (this.o == null)
                                  {
                                    this.o = new DiniFlyAnimationView(getContext());
                                    this.o.setFitFullScreenXY();
                                    this.o.addAnimatorListener(new autr(this));
                                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                    this.o.setLayoutParams(localLayoutParams);
                                    if (1 != paramMessage.arg2) {
                                      break label248;
                                    }
                                    this.o.setScaleX(1.0F);
                                  }
                                  for (;;)
                                  {
                                    if (!this.dkq)
                                    {
                                      this.dkq = true;
                                      addView(this.o);
                                    }
                                    xks.a(getQQAppInterface(), getContext(), this.o, null, paramMessage.arg1, "fullscreen");
                                    return false;
                                    if (!this.o.isAnimating()) {
                                      break;
                                    }
                                    this.o.endAnimation();
                                    break;
                                    this.o.setScaleX(-1.0F);
                                  }
                                } while ((this.o == null) || (!this.dkq));
                                this.dkq = false;
                                removeView(this.o);
                                this.o = null;
                                return false;
                              } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView != null);
                              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = new HeartCombolEffectView(getContext(), xks.z(getQQAppInterface()));
                              paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                              addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView, paramMessage);
                              return false;
                            } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView == null);
                            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView.start(((Boolean)paramMessage.obj).booleanValue());
                            return false;
                          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView == null);
                          removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView);
                          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = null;
                          return false;
                        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView != null);
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = new ZanCombolEffectView(getContext());
                        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.a(getResources().getDisplayMetrics().widthPixels, wja.dp2px(40.0F, getResources()), 0.0F, 150.0F, wja.dp2px(100.0F, getResources()), wja.dp2px(3.0F, getResources()), wja.dp2px(800.0F, getResources()), getResources().getDisplayMetrics().heightPixels, xks.z(getQQAppInterface()));
                        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, paramMessage);
                        return false;
                      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView == null);
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.b(new Integer[] { Integer.valueOf(2130839283), Integer.valueOf(2130839284), Integer.valueOf(2130839285), Integer.valueOf(2130839286), Integer.valueOf(2130839287), Integer.valueOf(2130839288) });
                      return false;
                    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView == null);
                    removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView);
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = null;
                    return false;
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView != null);
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = new GreatMoveCombolEffectView(getContext());
                  paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                  addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView, paramMessage);
                  return false;
                } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView == null);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView.destory();
                removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = null;
                return false;
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView != null);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = new HeartBreakCombolEffectView(getContext());
              paramMessage = new RelativeLayout.LayoutParams(-1, -1);
              addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView, paramMessage);
              return false;
            } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView == null);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.start();
            return false;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView == null);
          removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.end();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = null;
          return false;
        } while (this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView != null);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = new SixCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        paramMessage.addRule(8, 2131370537);
        paramMessage.topMargin = ankt.dip2px(50.0F);
        ((ViewGroup)findViewById(2131364469)).addView(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView, paramMessage);
        return false;
      } while (this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView == null);
      ((ViewGroup)findViewById(2131364469)).removeView(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView.destory();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = null;
      return false;
    case 19: 
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "SHOW_PLACEHOLDER");
      }
      this.xu.setOnTouchListener(this.F);
      removeView(this.xu);
      paramMessage = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.xu, paramMessage);
      return false;
    case 20: 
      label248:
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "HIDE_PLACEHOLDER");
      }
      removeView(this.xu);
      return false;
    }
    clearAnimation();
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b != null) {
      bool = this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b.onInterceptTouchEvent(paramMotionEvent);
    }
    if (bool) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDispatchTouchEventListener(a parama)
  {
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a = parama;
  }
  
  public void setOnInterceptTouchEventListener(b paramb)
  {
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.FitSystemWindowsRelativeLayout
 * JD-Core Version:    0.7.0.1
 */