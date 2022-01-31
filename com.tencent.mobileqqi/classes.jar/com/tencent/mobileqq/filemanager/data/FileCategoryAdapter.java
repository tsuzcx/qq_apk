package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List jdField_a_of_type_JavaUtilList;
  
  public FileCategoryAdapter(Context paramContext, List paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
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
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).C == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).C == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).C == 2) {
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localFileCategoryEntity.D, paramViewGroup, false);
      localView.setTag(paramView);
      if ((localFileCategoryEntity.C == 0) || (localFileCategoryEntity.C == 3))
      {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131232725));
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232720));
        paramView.b = ((TextView)localView.findViewById(2131232721));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232727));
        paramView.c = ((TextView)localView.findViewById(2131232726));
        paramViewGroup = paramView;
        paramView = localView;
      }
    }
    for (;;)
    {
      label164:
      paramViewGroup.jdField_a_of_type_Int = localFileCategoryEntity.G;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFileCategoryEntity.c;
      if (localFileCategoryEntity.C == 0)
      {
        if (localFileCategoryEntity.jdField_b_of_type_Boolean)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localFileCategoryEntity.E);
          label218:
          if (localFileCategoryEntity.jdField_b_of_type_JavaLangString == null) {
            break label423;
          }
          paramViewGroup.c.setVisibility(0);
          paramViewGroup.c.setText(localFileCategoryEntity.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          paramViewGroup.b.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
          if (localFileCategoryEntity.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localFileCategoryEntity.F + ")");
          }
          switch (localFileCategoryEntity.H)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837877);
            return paramView;
            if (localFileCategoryEntity.C != 1) {
              break label523;
            }
            paramView.d = ((TextView)localView.findViewById(2131232723));
            paramView.e = ((TextView)localView.findViewById(2131232724));
            paramViewGroup = paramView;
            paramView = localView;
            break label164;
            paramViewGroup = (FileCategoryAdapter.ItemHolder)paramView.getTag();
            break label164;
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label218;
            label423:
            paramViewGroup.c.setVisibility(8);
          }
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837877);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837882);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837879);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837881);
        return paramView;
      }
      localView = paramView;
      if (localFileCategoryEntity.C != 1) {
        break;
      }
      if (localFileCategoryEntity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
        return paramView;
      }
      paramViewGroup.e.setVisibility(4);
      return paramView;
      label523:
      paramViewGroup = paramView;
      paramView = localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */