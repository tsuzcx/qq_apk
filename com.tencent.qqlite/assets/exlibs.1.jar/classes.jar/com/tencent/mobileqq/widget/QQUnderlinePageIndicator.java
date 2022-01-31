package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.cur.IDragView.OnChangeModeListener;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity.TabInfo;
import fbj;
import java.util.List;

public class QQUnderlinePageIndicator
  extends UnderlinePageIndicator
{
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private List jdField_a_of_type_JavaUtilList;
  
  public QQUnderlinePageIndicator(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public QQUnderlinePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 2130772073);
  }
  
  public QQUnderlinePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      boolean bool;
      if (((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_AndroidViewView != null)
      {
        localObject = ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_AndroidViewView;
        if (i == paramInt)
        {
          bool = true;
          label67:
          ((View)localObject).setSelected(bool);
        }
      }
      else
      {
        if (i != paramInt) {
          break label111;
        }
        ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqAppFrame.h();
      }
      for (;;)
      {
        i += 1;
        break;
        bool = false;
        break label67;
        label111:
        ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqAppFrame.i();
      }
    }
    DragTextView localDragTextView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
    if (((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString.equals(Conversation.class.getName())) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;; localObject = null)
    {
      localDragTextView.setOnModeChangeListener((IDragView.OnChangeModeListener)localObject);
      return;
    }
  }
  
  public void setContents(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void setDragFrameLayout(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void setDragTextView(DragTextView paramDragTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = paramDragTextView;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == paramViewPager) {
      return;
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    invalidate();
    post(new fbj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQUnderlinePageIndicator
 * JD-Core Version:    0.7.0.1
 */