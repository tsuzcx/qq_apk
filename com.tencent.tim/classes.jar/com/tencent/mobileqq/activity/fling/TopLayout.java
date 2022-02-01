package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TopLayout
  extends RelativeLayout
  implements TopContentLayout.OnOutScreenListener
{
  private TopBehindLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout;
  private OnDraggingListener jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
  private TopContentLayout b;
  
  public TopLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout = new TopBehindLayout(paramContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.b = new TopContentLayout(paramContext);
    this.b.setOnOutScreenListener(this);
    addView(this.b, localLayoutParams);
  }
  
  private void j(View paramView, float paramFloat)
  {
    int i = getWidth();
    int j = getHeight();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = ((int)(i * paramFloat));
    localLayoutParams.height = ((int)(j * paramFloat));
    localLayoutParams.leftMargin = ((i - localLayoutParams.width) / 2);
    localLayoutParams.topMargin = ((j - localLayoutParams.height) / 2);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public OnDraggingListener getOnDraggingListener()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
  }
  
  public void onConfigChanged(Configuration paramConfiguration) {}
  
  public void outing(int paramInt1, int paramInt2, View paramView)
  {
    paramInt2 = getContext().getResources().getDisplayMetrics().widthPixels;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout;
    if (paramView != null)
    {
      float f1 = Math.abs(paramInt1 / paramInt2);
      float f2 = 0.95F + (1.0F - 0.95F) * f1;
      if (f2 < 1.0F) {
        paramView.setForeground(new ColorDrawable((int)((1.0F - f1) * 128.0F) << 24));
      }
      j(paramView, f2);
    }
    if (Math.abs(paramInt1) >= paramInt2) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener.endDrag();
      }
    }
    while ((paramInt1 != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener.cancelDrag();
  }
  
  public void setBehind(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout.setContent(paramView);
  }
  
  public void setContent(ContentWrapView paramContentWrapView)
  {
    this.b.setContent(paramContentWrapView);
  }
  
  public void setOnDraggingListener(OnDraggingListener paramOnDraggingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener = paramOnDraggingListener;
  }
  
  public void startDrag()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener.startDrag();
    }
  }
  
  public static abstract interface OnDraggingListener
  {
    public abstract void cancelDrag();
    
    public abstract void endDrag();
    
    public abstract void startDrag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopLayout
 * JD-Core Version:    0.7.0.1
 */