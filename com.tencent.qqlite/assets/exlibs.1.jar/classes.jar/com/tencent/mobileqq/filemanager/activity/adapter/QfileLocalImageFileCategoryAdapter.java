package com.tencent.mobileqq.filemanager.activity.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import java.util.ArrayList;
import java.util.List;

public class QfileLocalImageFileCategoryAdapter
  extends GridListView.GridListAdapter
{
  private static final int jdField_a_of_type_Int = 4;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int c = 50;
  
  public QfileLocalImageFileCategoryAdapter(Activity paramActivity, List paramList, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramActivity);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
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
    this.c = paramInt;
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903420, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = new QfileLocalImageFileCategoryAdapter.LocalImageHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296283));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298019));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131296797));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      FileInfo localFileInfo = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130839034);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.c, this.c);
      int i = paramInt / 4;
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362015), new Object[] { Integer.valueOf(i + 1), Integer.valueOf((paramInt & 0x3) + 1) });
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(str);
      if ((localFileInfo.d() != null) && (localFileInfo.d().length() > 0)) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileInfo.d());
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) || (!FMDataCache.a(localFileInfo))) {
        break;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131427353));
      return paramView;
      paramViewGroup = (QfileLocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag();
    }
    paramViewGroup.b.setVisibility(4);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageFileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */