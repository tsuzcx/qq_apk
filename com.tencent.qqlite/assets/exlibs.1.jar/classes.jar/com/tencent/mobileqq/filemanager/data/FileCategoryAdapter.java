package com.tencent.mobileqq.filemanager.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List jdField_a_of_type_JavaUtilList;
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
  
  public int getItemViewType(int paramInt)
  {
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).A == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).A == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).A == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (localFileCategoryEntity == null)
    {
      localView = null;
      return localView;
    }
    if (paramView == null)
    {
      paramView = new FileCategoryAdapter.ItemHolder(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localFileCategoryEntity.B, paramViewGroup, false);
      localView.setTag(paramView);
      if ((localFileCategoryEntity.A == 0) || (localFileCategoryEntity.A == 3))
      {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131297992));
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297993));
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297996));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297994));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297995));
        paramView.c = ((TextView)localView.findViewById(2131297795));
        paramViewGroup = paramView;
        paramView = localView;
      }
    }
    for (;;)
    {
      label178:
      paramViewGroup.jdField_a_of_type_Int = localFileCategoryEntity.E;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFileCategoryEntity.jdField_c_of_type_JavaLangString;
      if (localFileCategoryEntity.A == 0)
      {
        if (localFileCategoryEntity.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label220:
          if (!localFileCategoryEntity.jdField_b_of_type_Boolean) {
            break label455;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localFileCategoryEntity.C);
          label248:
          if (localFileCategoryEntity.jdField_b_of_type_JavaLangString == null) {
            break label467;
          }
          paramViewGroup.c.setVisibility(0);
          paramViewGroup.c.setText(localFileCategoryEntity.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
          if (localFileCategoryEntity.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localFileCategoryEntity.D + ")");
          }
          switch (localFileCategoryEntity.F)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837942);
            return paramView;
            if (localFileCategoryEntity.A != 1) {
              break label567;
            }
            paramView.d = ((TextView)localView.findViewById(2131297967));
            paramView.e = ((TextView)localView.findViewById(2131297968));
            paramViewGroup = paramView;
            paramView = localView;
            break label178;
            paramViewGroup = (FileCategoryAdapter.ItemHolder)paramView.getTag();
            break label178;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label220;
            label455:
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label248;
            label467:
            paramViewGroup.c.setVisibility(8);
          }
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837942);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837945);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837944);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837945);
        return paramView;
      }
      localView = paramView;
      if (localFileCategoryEntity.A != 1) {
        break;
      }
      if (localFileCategoryEntity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
        return paramView;
      }
      paramViewGroup.e.setVisibility(4);
      return paramView;
      label567:
      paramViewGroup = paramView;
      paramView = localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */