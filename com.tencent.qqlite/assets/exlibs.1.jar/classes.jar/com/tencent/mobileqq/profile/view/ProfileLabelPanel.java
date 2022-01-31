package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.widget.CirclePageIndicator;
import java.util.List;

public class ProfileLabelPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  protected ViewPager a;
  protected View a;
  protected TextView a;
  protected ProfileLabelPanel.LabelStatusManager a;
  protected ProfileLabelPanelAdapter a;
  protected CirclePageIndicator a;
  protected List a;
  protected TextView b;
  
  public ProfileLabelPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileLabelPanel(Context paramContext, ProfileLabelPanel.LabelStatusManager paramLabelStatusManager, List paramList, ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this(paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130903586, this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = paramLabelStatusManager;
    a(paramContext, paramProfileLabelCallBack);
  }
  
  protected void a(Context paramContext, ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298651));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298650));
    this.b.setText(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(0)).typeInfo);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(0)).typeName);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131298652));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131297066));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter = new ProfileLabelPanelAdapter(paramContext, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.a(paramProfileLabelCallBack);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(this);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ProfileLabelTypeInfo localProfileLabelTypeInfo = (ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.b.setText(localProfileLabelTypeInfo.typeInfo);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localProfileLabelTypeInfo.typeName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanel
 * JD-Core Version:    0.7.0.1
 */