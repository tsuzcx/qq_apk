package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import fpd;
import java.util.ArrayList;
import java.util.List;

public class SystemEmoticonPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  protected Context a;
  protected View a;
  public ImageButton a;
  public EmoticonCallback a;
  protected EmoticonPagerAdapter a;
  protected EmoticonPagerRadioGroup a;
  protected EmoticonViewPager a;
  private Runnable a;
  
  public SystemEmoticonPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new fpd(this);
  }
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangRunnable = new fpd(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new fpd(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this(paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130903214, this);
    a(paramContext, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a();
    }
  }
  
  protected void a(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager = ((EmoticonViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131231633));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131231651));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new SystemEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 0));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    a(this.jdField_a_of_type_AndroidContentContext, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */