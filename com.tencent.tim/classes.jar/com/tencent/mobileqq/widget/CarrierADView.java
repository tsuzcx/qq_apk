package com.tencent.mobileqq.widget;

import afcp;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import aqgw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class CarrierADView
  extends ADView
  implements Handler.Callback
{
  private afcp a;
  private MqqHandler b;
  private MotionEvent l;
  
  public CarrierADView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CarrierADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void aw(View paramView, int paramInt)
  {
    if (this.linearLayout.getChildCount() == 0)
    {
      this.linearLayout.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.cZp);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      this.linearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        return;
      }
      catch (Exception paramView) {}
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)this.linearLayout.getChildAt(0)).getChildAt(0));
    }
  }
  
  public void ehE()
  {
    if (this.b != null)
    {
      this.b.removeMessages(0);
      this.b.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public void ehF()
  {
    if (this.b != null) {
      this.b.sendEmptyMessage(1);
    }
  }
  
  public int getCurrentScreen()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getCurrentScreen();
    }
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getWidth() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.snapToScreen(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getCurrentScreen() + 1);
      }
      this.b.sendEmptyMessageDelayed(0, 3400);
      return false;
    }
    this.b.removeMessages(0);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_a_of_type_Afcp != null)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label56;
      }
      this.jdField_a_of_type_Afcp.L(false);
      ehF();
      if (this.l != null) {
        this.l.recycle();
      }
      this.l = MotionEvent.obtain(paramMotionEvent);
    }
    label56:
    do
    {
      return false;
      if (i == 2)
      {
        if (this.l != null)
        {
          float f1 = this.l.getX();
          float f2 = paramMotionEvent.getX();
          if (Math.abs((this.l.getY() - paramMotionEvent.getY()) / (f1 - f2)) < 0.5F) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
        }
        this.l = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
    } while ((i != 1) && (i != 3));
    this.jdField_a_of_type_Afcp.L(true);
    ehE();
    getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void setCarrierData(List<AdData> paramList, int paramInt, CarrierHelper paramCarrierHelper)
  {
    if (this.b == null) {
      this.b = new aqgw(Looper.getMainLooper(), this);
    }
    ehD();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CarrierADView", 2, "carrier List is null or empty");
      }
      setVisibility(8);
      return;
    }
    while (paramInt > 0)
    {
      paramList.add(paramList.get(0));
      paramList.remove(0);
      paramInt -= 1;
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt < paramList.size()) {
        try
        {
          View localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561433, null);
          paramCarrierHelper.a(localView, (AdData)paramList.get(paramInt));
          aw(localView, paramInt);
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CarrierADView", 2, localException.toString());
            }
          }
        }
      }
    }
    ehE();
  }
  
  public void setFlingSwitch(afcp paramafcp)
  {
    this.jdField_a_of_type_Afcp = paramafcp;
  }
  
  public void setVisibility(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 4)) {
      ehF();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setVisibility(paramInt);
      }
      super.setVisibility(paramInt);
      return;
      ehE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CarrierADView
 * JD-Core Version:    0.7.0.1
 */