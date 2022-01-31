package com.tencent.mobileqq.filemanager.data;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.filemanager.activity.LocalFileCategoryBrowserActivity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import java.util.ArrayList;
import java.util.List;

public class LocalImageFileCategoryAdapter
  extends GridListView.GridListAdapter
{
  private static final int jdField_a_of_type_Int = 4;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileCategoryBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b = 50;
  
  public LocalImageFileCategoryAdapter(Activity paramActivity, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity = ((LocalFileCategoryBrowserActivity)paramActivity);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public FileInfo a(int paramInt)
  {
    return (FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int b(int paramInt)
  {
    return 1;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903502, null);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.a);
      paramViewGroup = new LocalImageFileCategoryAdapter.LocalImageHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131230758));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232747));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131231331));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      FileInfo localFileInfo = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130839362);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.b, this.b);
      int i = paramInt / 4;
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.getString(2131558755), new Object[] { Integer.valueOf(i + 1), Integer.valueOf((paramInt & 0x3) + 1) });
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(str);
      if ((localFileInfo.c() != null) && (localFileInfo.c().length() > 0)) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileInfo.c());
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.g()) || (!FMDataCache.a(localFileInfo))) {
        break;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.getResources().getColor(2131361824));
      return paramView;
      paramViewGroup = (LocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag();
    }
    paramViewGroup.b.setVisibility(4);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalImageFileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */