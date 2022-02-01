package com.tencent.mobileqq.activity.specialcare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import esu;
import esv;
import java.util.List;

public class QvipSpecialSoundActivity$SpecialSoundAdapter
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = null;
  
  public QvipSpecialSoundActivity$SpecialSoundAdapter(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
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
    esv localesv;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.getLayoutInflater().inflate(2130903702, null);
      paramViewGroup = new esu(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233468));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131233469));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131233470));
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity);
      paramView.setTag(paramViewGroup);
      localesv = (esv)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localesv.jdField_a_of_type_JavaLangString);
      paramViewGroup.b.setText(localesv.jdField_a_of_type_JavaLangString);
      paramView.setContentDescription(localesv.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_Int = localesv.jdField_a_of_type_Int;
      paramViewGroup.jdField_a_of_type_JavaLangString = localesv.c;
      if (paramInt != 0) {
        break label236;
      }
      paramView.setBackgroundResource(2130837882);
      label154:
      if (localesv.b != 1) {
        break label245;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity).a(QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity)) != localesv.jdField_a_of_type_Int) {
        break label257;
      }
      paramView.findViewById(2131233471).setVisibility(0);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return paramView;
      paramViewGroup = (esu)paramView.getTag();
      break;
      label236:
      paramView.setBackgroundResource(2130837881);
      break label154;
      label245:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label257:
    paramView.findViewById(2131233471).setVisibility(8);
    paramViewGroup.b.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity.SpecialSoundAdapter
 * JD-Core Version:    0.7.0.1
 */