package com.tencent.mobileqq.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.view.CircularProgressBar;
import com.tencent.qphone.base.util.QLog;
import ges;
import java.util.List;

public class ProfileCardBrowserActivity$ImageGalleryAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  
  public ProfileCardBrowserActivity$ImageGalleryAdapter(ProfileCardBrowserActivity paramProfileCardBrowserActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = Math.round(paramProfileCardBrowserActivity.A * 1.75F);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "ImageGalleryAdapter getItemId , position " + paramInt);
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (ProfileCardTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new ges(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903683, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.A, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.B));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131233398));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131233395));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131233396));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfileViewCircularProgressBar = ((CircularProgressBar)paramView.findViewById(2131233399));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131233400));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233397));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfileViewCircularProgressBar.setTag(Integer.valueOf(paramInt));
      switch (((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_Int)
      {
      default: 
        label204:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        paramInt = (int)(System.currentTimeMillis() / 1000L);
        if ((paramInt > ((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h) && (paramInt < ((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.i))
        {
          paramViewGroup.c.setVisibility(0);
          switch (((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.g)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.b.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.A, this.jdField_a_of_type_Int);
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839202);
      localObject1 = URLDrawable.getDrawable(((ProfileCardTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d, (Drawable)localObject2, (Drawable)localObject2, false);
      paramViewGroup.b.setImageDrawable((Drawable)localObject1);
      return paramView;
      paramViewGroup = (ges)paramView.getTag();
      break;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(paramViewGroup, 4);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839208);
      break label204;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(paramViewGroup, 2);
      break label204;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(paramViewGroup, 4);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839210);
      break label204;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(paramViewGroup, 1);
      break label204;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(paramViewGroup, 4);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839211);
      break label204;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(paramViewGroup, 4);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839212);
      break label204;
      paramViewGroup.c.setImageResource(2130839197);
      continue;
      paramViewGroup.c.setImageResource(2130839197);
      continue;
      paramViewGroup.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardBrowserActivity.ImageGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */