package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anqr;
import arek;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

public class ADView
  extends LinearLayout
{
  public final String TAG = "ADView";
  private a a;
  protected WorkSpaceView a;
  protected int bwo = 2130837693;
  protected int bwp = this.bwo;
  private boolean cZn;
  protected boolean cZo = true;
  public boolean cZp = true;
  protected float density = getResources().getDisplayMetrics().density;
  protected int eeM = 2;
  protected int eeN;
  protected LinearLayout linearLayout;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$a = new a(this);
    init(paramContext);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$a = new a(this);
    init(paramContext);
  }
  
  public ViewGroup a(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.linearLayout.getChildAt(paramInt);
    if (localRelativeLayout != null) {
      return (WorkSpaceView)localRelativeLayout.getChildAt(0);
    }
    return null;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(14, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.density));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130841319);
    paramLinearLayout.setPadding((int)(4.0F * this.density), 0, (int)(2.0F * this.density), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  protected void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams;
    if (this.eeN > 0)
    {
      localLayoutParams = new LinearLayout.LayoutParams((int)(this.eeN * this.density), (int)(this.eeN * this.density));
      localLayoutParams.setMargins(0, 0, (int)(this.eeM * this.density), 0);
      localImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      try
      {
        localImageView.setImageDrawable(getContext().getResources().getDrawable(this.bwp));
        if (!paramBoolean) {
          continue;
        }
        localImageView.setEnabled(true);
      }
      catch (Exception localException)
      {
        localImageView.setImageResource(this.bwo);
        continue;
        int i = 4;
        continue;
      }
      paramLinearLayout.addView(localImageView);
      if (paramLinearLayout.getChildCount() <= 1) {
        continue;
      }
      i = 0;
      paramLinearLayout.setVisibility(i);
      return;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      break;
      localImageView.setEnabled(false);
    }
  }
  
  public boolean aGp()
  {
    return this.cZp;
  }
  
  public void av(View paramView, int paramInt)
  {
    Object localObject;
    if (this.linearLayout.getChildCount() == 0)
    {
      this.linearLayout.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new LinearLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.cZp);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new arek(this, (LinearLayout)localObject));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      a((LinearLayout)localObject);
      localRelativeLayout.addView((View)localObject);
      this.linearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        a((LinearLayout)localObject, bool);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent.banner", 4, "addViewToWorkspace");
        }
        return;
      }
      catch (Exception paramView) {}
      localObject = (ViewGroup)this.linearLayout.getChildAt(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)localObject).getChildAt(0));
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
    }
  }
  
  public void c(int paramInt1, int paramInt2, View paramView)
  {
    int i = 0;
    try
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.linearLayout.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)localRelativeLayout.getChildAt(0);
      localWorkSpaceView.removeView(paramView);
      paramView = (LinearLayout)localRelativeLayout.getChildAt(1);
      paramView.removeViewAt(paramInt2);
      if (paramView.getChildCount() > 1) {}
      for (paramInt1 = i;; paramInt1 = 4)
      {
        paramView.setVisibility(paramInt1);
        if (paramInt2 > 0) {
          localWorkSpaceView.snapToScreen(paramInt2 - 1);
        }
        return;
      }
      return;
    }
    catch (Exception paramView) {}
  }
  
  public void ehD()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.linearLayout.getChildAt(0);
    if (localRelativeLayout == null) {
      return;
    }
    ((WorkSpaceView)localRelativeLayout.getChildAt(0)).removeAllViews();
    this.linearLayout.removeAllViews();
  }
  
  public void ehE()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$a.removeMessages(0);
    try
    {
      anqr localanqr = (anqr)this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getCurrentScreen()).getTag();
      i = localanqr.ac;
      setContentDescription(localanqr.cgW);
      i *= 1000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 5000;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$a.sendEmptyMessageDelayed(0, i);
  }
  
  public void ehF()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$a.sendEmptyMessage(1);
  }
  
  protected void init(Context paramContext)
  {
    setPadding(0, 0, 0, 0);
    this.linearLayout = new LinearLayout(paramContext);
    addView(this.linearLayout, new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
  }
  
  public void ku(int paramInt1, int paramInt2)
  {
    try
    {
      QZLog.i("removeFromWorkSpace", "@newcard TABINDEX " + paramInt1 + "page" + paramInt2);
      Object localObject = (ViewGroup)this.linearLayout.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)((ViewGroup)localObject).getChildAt(0);
      localWorkSpaceView.removeViewAt(paramInt2);
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
      ((LinearLayout)localObject).removeViewAt(paramInt2);
      if (((LinearLayout)localObject).getChildCount() > 1) {}
      for (paramInt1 = 0;; paramInt1 = 4)
      {
        ((LinearLayout)localObject).setVisibility(paramInt1);
        if (paramInt2 > 0) {
          localWorkSpaceView.snapToScreen(paramInt2 - 1);
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      paramInt1 = 0;
      while (paramInt1 < this.linearLayout.getChildCount() - 1)
      {
        QZLog.i("ADView", "@newcard " + this.linearLayout.getChildAt(paramInt1).getClass());
        paramInt1 += 1;
      }
      QZLog.i("ADView", 2, "@newcard  ", localException);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.cZo)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCircle(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setCircle(paramBoolean);
    }
    this.cZp = paramBoolean;
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.cZn = true;
  }
  
  static class a
    extends Handler
  {
    private ADView b;
    private WeakReference<ADView> weakRef;
    
    public a(ADView paramADView)
    {
      this.weakRef = new WeakReference(paramADView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        do
        {
          return;
          this.b = ((ADView)this.weakRef.get());
        } while ((this.b == null) || (this.b.a == null));
        if ((this.b.a.getChildCount() > 1) && (this.b.a.getWidth() > 0)) {
          this.b.a.snapToScreen(this.b.a.getCurrentScreen() + 1);
        }
        try
        {
          anqr localanqr = (anqr)this.b.a.getChildAt(this.b.a.getCurrentScreen()).getTag();
          i = localanqr.ac;
          this.b.setContentDescription(localanqr.cgW);
          i *= 1000;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = 5000;
          }
        }
        sendEmptyMessageDelayed(0, i);
        this.b = null;
        continue;
        removeMessages(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView
 * JD-Core Version:    0.7.0.1
 */