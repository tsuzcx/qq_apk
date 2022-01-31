package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.List;

public class WeiYunFileAdapter
  extends BaseFileAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CloudFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList;
  
  public WeiYunFileAdapter(Context paramContext, List paramList, CloudFileBrowserActivity paramCloudFileBrowserActivity)
  {
    super(paramContext, paramCloudFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = paramCloudFileBrowserActivity;
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
    return super.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localWeiYunFileInfo == null) {
      return null;
    }
    if (paramView == null) {}
    for (;;)
    {
      try
      {
        WeiYunFileAdapter.WeiYunFileItemHolder localWeiYunFileItemHolder1 = new WeiYunFileAdapter.WeiYunFileItemHolder(this);
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903500, paramViewGroup, false);
        paramView = paramViewGroup;
        try
        {
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131232740));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.c);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localWeiYunFileItemHolder1);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131232741));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131232742));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131232744));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131232743));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.b = ((TextView)paramViewGroup.findViewById(2131232745));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.c = ((TextView)paramViewGroup.findViewById(2131232746));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.d = ((TextView)paramViewGroup.findViewById(2131231883));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131232134));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131230987));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131231701));
          paramView = paramViewGroup;
          paramViewGroup.setTag(localWeiYunFileItemHolder1);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo = localWeiYunFileInfo;
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_Int = paramInt;
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetTextView.setText(localWeiYunFileInfo.jdField_b_of_type_JavaLangString);
          paramView = paramViewGroup;
          String str1 = FileManagerUtil.a(localWeiYunFileInfo.jdField_b_of_type_Long, -1, true);
          paramView = paramViewGroup;
          String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getString(2131558715);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.d.setVisibility(4);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.b.setText(FileUtil.a(localWeiYunFileInfo.jdField_a_of_type_Long));
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.c.setText(str2 + str1);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.d.setText(str2 + str1);
          paramView = paramViewGroup;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.g()) {
            continue;
          }
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          if (!FMDataCache.a(localWeiYunFileInfo)) {
            continue;
          }
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          paramView = paramViewGroup;
          if (FileManagerUtil.a(localWeiYunFileInfo.jdField_b_of_type_JavaLangString) != 0) {
            continue;
          }
          paramView = paramViewGroup;
          if (localWeiYunFileInfo.g == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localWeiYunFileInfo.g.length() == 0) {
            continue;
          }
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130838614);
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localWeiYunFileInfo.g);
          paramView = paramViewGroup;
          if (a(paramInt, paramViewGroup, localWeiYunFileItemHolder1.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetButton, localWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {}
          paramView = paramViewGroup;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.f()) {
            continue;
          }
          paramView = paramViewGroup;
          if (!FMDataCache.a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          paramView = paramViewGroup;
          localWeiYunFileItemHolder1.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          return paramViewGroup;
        }
        catch (Exception localException1)
        {
          paramViewGroup = paramView;
          paramView = localException1;
        }
      }
      catch (Exception localException2)
      {
        WeiYunFileAdapter.WeiYunFileItemHolder localWeiYunFileItemHolder2;
        paramViewGroup = paramView;
        paramView = localException2;
        continue;
      }
      paramView.printStackTrace();
      return paramViewGroup;
      localWeiYunFileItemHolder2 = (WeiYunFileAdapter.WeiYunFileItemHolder)paramView.getTag();
      paramViewGroup = paramView;
      continue;
      paramView = paramViewGroup;
      localWeiYunFileItemHolder2.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      continue;
      paramView = paramViewGroup;
      localWeiYunFileItemHolder2.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      continue;
      paramView = paramViewGroup;
      a(localWeiYunFileItemHolder2.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.jdField_b_of_type_JavaLangString, -1);
    }
    paramView = paramViewGroup;
    localWeiYunFileItemHolder2.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.WeiYunFileAdapter
 * JD-Core Version:    0.7.0.1
 */