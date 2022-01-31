package com.tencent.mobileqq.filemanager.data;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import java.util.ArrayList;
import java.util.List;

public class ImageFileAdapter
  extends GridListView.GridListAdapter
{
  public final int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CloudFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public final int b = 2;
  
  public ImageFileAdapter(Activity paramActivity, List paramList)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = ((CloudFileBrowserActivity)paramActivity);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.k()) {
      return 2;
    }
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size()) {
      return 2;
    }
    return 1;
  }
  
  public WeiYunFileInfo a(int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.k()) && (paramInt == this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (WeiYunFileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int b(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size()) {
      return 2;
    }
    return 1;
  }
  
  public int getCount()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.k()) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size()) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new ImageFileAdapter.ViewHolder(this);
      switch (getItemViewType(paramInt))
      {
      default: 
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903502, null);
        paramView.setClickable(true);
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.c);
        paramView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.a);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131230758));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232747));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131231331));
        paramView.setTag(paramViewGroup);
        label118:
        if (b(paramInt) != 2) {
          break label309;
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.l())) {
          paramView.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.j()) {
        break label281;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131558763);
      return paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903493, null);
      paramView.setClickable(true);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.b);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232729));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231066));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131231868));
      break;
      paramViewGroup = (ImageFileAdapter.ViewHolder)paramView.getTag();
      break label118;
      paramView.setVisibility(0);
    }
    label281:
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131558707);
    return paramView;
    label309:
    WeiYunFileInfo localWeiYunFileInfo = a(paramInt);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo = localWeiYunFileInfo;
    paramViewGroup.jdField_a_of_type_Int = paramInt;
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130839362);
    int i = paramInt / 4;
    String str = String.format(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getString(2131558755), new Object[] { Integer.valueOf(i + 1), Integer.valueOf((paramInt & 0x3) + 1) });
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(str);
    if ((localWeiYunFileInfo.g != null) && (localWeiYunFileInfo.g.length() > 0)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localWeiYunFileInfo.g);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.g()) && (FMDataCache.a(localWeiYunFileInfo)))
    {
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getResources().getColor(2131361824));
      return paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130839362);
    }
    paramViewGroup.b.setVisibility(4);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.k()) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.ImageFileAdapter
 * JD-Core Version:    0.7.0.1
 */