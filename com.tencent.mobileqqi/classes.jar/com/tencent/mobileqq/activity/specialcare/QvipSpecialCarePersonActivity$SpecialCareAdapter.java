package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import esn;
import java.util.List;

public class QvipSpecialCarePersonActivity$SpecialCareAdapter
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = null;
  
  public QvipSpecialCarePersonActivity$SpecialCareAdapter(QvipSpecialCarePersonActivity paramQvipSpecialCarePersonActivity) {}
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity.getLayoutInflater().inflate(2130903698, null);
      paramViewGroup = new esn(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity, null);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_JavaLangString = String.valueOf(getItem(paramInt));
      paramViewGroup.b = QvipSpecialCarePersonActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity, paramViewGroup.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramViewGroup.b)) {
        break label151;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText("");
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(ImageUtil.a(), QvipSpecialCarePersonActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity), QvipSpecialCarePersonActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity));
    }
    for (;;)
    {
      QvipSpecialCarePersonActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity, paramView, paramInt, getCount());
      return paramView;
      paramViewGroup = (esn)paramView.getTag();
      break;
      label151:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramViewGroup.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity.getApplicationContext().getString(2131559025, new Object[] { paramViewGroup.b }));
      paramView.setContentDescription(localStringBuilder);
      QvipSpecialCarePersonActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCarePersonActivity, paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialCarePersonActivity.SpecialCareAdapter
 * JD-Core Version:    0.7.0.1
 */