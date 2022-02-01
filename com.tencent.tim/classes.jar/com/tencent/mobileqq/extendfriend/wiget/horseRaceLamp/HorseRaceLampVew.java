package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import afub;
import afzl;
import afzm;
import afzn;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class HorseRaceLampVew
  extends RelativeLayout
  implements Runnable
{
  private afzn jdField_a_of_type_Afzn;
  private a jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew$a;
  private int cVB = 3;
  private int cVC = 15;
  private final int cVD = 4;
  private final int cVE = 20;
  private boolean cbW;
  public boolean cbX;
  public boolean cbY = true;
  private Handler handler = new Handler(Looper.getMainLooper());
  private float mLastX;
  private float mLastY;
  private ArrayList<afzl> mLines = new ArrayList();
  private float mf;
  private float mg;
  private float wn;
  
  public HorseRaceLampVew(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public HorseRaceLampVew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public HorseRaceLampVew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private boolean K(float paramFloat1, float paramFloat2)
  {
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    return (Math.abs(paramFloat1) > i) || (Math.abs(paramFloat2) > i);
  }
  
  private void clearAll()
  {
    this.cbX = false;
    removeAllViews();
    this.mLines.clear();
  }
  
  private void deg()
  {
    postDelayed(new HorseRaceLampVew.1(this), 50L);
  }
  
  private void deh()
  {
    int i1 = 0;
    int j;
    int k;
    View localView;
    int i;
    Object localObject;
    if (this.mLines.size() > 0)
    {
      if (this.cbX) {
        break label199;
      }
      j = 0;
      k = 0;
      for (int m = 0; j < getChildCount(); m = i)
      {
        localView = getChildAt(j);
        int n = k;
        i = m;
        if (localView != null)
        {
          n = k;
          i = m;
          if (localView.getVisibility() != 8)
          {
            localObject = localView.getTag();
            n = k;
            i = m;
            if ((localObject instanceof afzm))
            {
              m += 1;
              localObject = (afzm)localObject;
              n = k;
              i = m;
              if (localView.getWidth() != 0)
              {
                ((afzm)localObject).setWidth(localView.getMeasuredWidth());
                n = k + 1;
                i = m;
              }
            }
          }
        }
        j += 1;
        k = n;
      }
      if (k == m)
      {
        i = i1;
        while (i < this.mLines.size())
        {
          ((afzl)this.mLines.get(i)).kP();
          i += 1;
        }
        this.cbX = true;
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      label199:
      i = 0;
      while (i < getChildCount())
      {
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          if (localView.getVisibility() == 4) {
            localView.setVisibility(0);
          }
          localObject = localView.getTag();
          if ((localObject instanceof afzm))
          {
            localObject = (afzm)localObject;
            j = ((afzm)localObject).DT();
            k = ((afzm)localObject).DU();
            localView.setX(j);
            localView.setY(k);
          }
        }
        i += 1;
      }
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setFocusableInTouchMode(true);
    paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.cVB = (-wja.dp2px(0.02F * this.cVC, paramContext.getApp().getResources()));
    if (this.cVB == 0)
    {
      QLog.e("HorseRaceLampVew + horserace", 2, "mMovespeed is 0");
      this.cVB = -1;
    }
  }
  
  private void setMove(int paramInt)
  {
    if (this.cbX)
    {
      int i = 0;
      while (i < this.mLines.size())
      {
        ((afzl)this.mLines.get(i)).NH(paramInt);
        i += 1;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mg = 0.0F;
      this.mf = 0.0F;
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      this.cbW = true;
      this.cbY = true;
      getParent().requestDisallowInterceptTouchEvent(true);
      QLog.d("HorseRaceLampVew + horserace", 2, "ON touch ACTION_DOWN downX " + this.mLastX);
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mf += Math.abs(f1 - this.mLastX);
      this.mg += Math.abs(f2 - this.mLastY);
      this.wn = (f1 - this.mLastX);
      this.mLastX = f1;
      this.mLastY = f2;
      if (this.mf <= this.mg) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      for (;;)
      {
        setMove((int)this.wn);
        deh();
        if (!K(this.mf, this.mg)) {
          break;
        }
        this.cbY = false;
        break;
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.cbW = false;
      QLog.d("HorseRaceLampVew + horserace", 2, "ON touch ACTION_UP ");
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public void run()
  {
    if (!this.cbW)
    {
      setMove(this.cVB);
      deh();
    }
    this.handler.postDelayed(this, this.cVC);
  }
  
  public void setAdapter(afzn paramafzn)
  {
    this.jdField_a_of_type_Afzn = paramafzn;
    deg();
  }
  
  public void setTagClickListner(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew$a = parama;
  }
  
  public void startAnimation()
  {
    this.handler.removeCallbacksAndMessages(null);
    this.handler.postDelayed(this, this.cVC);
  }
  
  public void stopAnimation()
  {
    QLog.d("HorseRaceLampVew + horserace", 2, "stopAnimation");
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface a
  {
    public abstract void d(afub paramafub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew
 * JD-Core Version:    0.7.0.1
 */