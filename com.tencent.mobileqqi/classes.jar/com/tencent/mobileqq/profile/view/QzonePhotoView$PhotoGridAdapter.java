package com.tencent.mobileqq.profile.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import java.util.List;

class QzonePhotoView$PhotoGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List jdField_a_of_type_JavaUtilList;
  int b;
  
  QzonePhotoView$PhotoGridAdapter(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new QzonePhotoView.PhotoInfo(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i - 1);
      paramList.j = 102;
      this.jdField_a_of_type_JavaUtilList.set(i - 1, paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramView = new QzonePhotoView.PhotoGridAdapter.ItemHolder(this);
      RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2130903690, null);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      paramView.a = ((URLImageView)localRelativeLayout.findViewById(2131233433));
      paramView.a.setTag(new DataTag(25, null));
      if (paramViewGroup.j == 100) {
        paramView.a.setImageURL(paramViewGroup.a(this.jdField_a_of_type_Int));
      }
      for (;;)
      {
        paramView.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        localRelativeLayout.setTag(paramView);
        return localRelativeLayout;
        if (paramViewGroup.j == 101)
        {
          ProfileCardTemplate.a(paramView.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
        }
        else if (paramViewGroup.j == 102)
        {
          ProfileCardTemplate.a(paramView.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoMore");
          paramView.a.setBackgroundURL(paramViewGroup.a(this.jdField_a_of_type_Int));
        }
      }
    }
    paramViewGroup = (QzonePhotoView.PhotoGridAdapter.ItemHolder)paramView.getTag();
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */