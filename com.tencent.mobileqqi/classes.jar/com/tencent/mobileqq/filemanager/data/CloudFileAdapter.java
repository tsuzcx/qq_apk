package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.List;

public class CloudFileAdapter
  extends BaseFileAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CloudFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList;
  
  public CloudFileAdapter(Context paramContext, List paramList, CloudFileBrowserActivity paramCloudFileBrowserActivity)
  {
    super(paramContext, null);
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
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localFileInfo == null) {
      return null;
    }
    if (paramView == null) {}
    for (;;)
    {
      try
      {
        CloudFileAdapter.CloudFileItemHolder localCloudFileItemHolder1 = new CloudFileAdapter.CloudFileItemHolder(this);
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903500, paramViewGroup, false);
        paramView = paramViewGroup;
        try
        {
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131232740));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.c);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localCloudFileItemHolder1);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131232741));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131232742));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131232744));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131232743));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.b = ((TextView)paramViewGroup.findViewById(2131232745));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.c = ((TextView)paramViewGroup.findViewById(2131232746));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.d = ((TextView)paramViewGroup.findViewById(2131231883));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131230987));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131231701));
          paramView = paramViewGroup;
          paramViewGroup.setTag(localCloudFileItemHolder1);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView = paramViewGroup;
          a(localCloudFileItemHolder1.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), -1);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
          paramView = paramViewGroup;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.g()) {
            continue;
          }
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
          paramView = paramViewGroup;
          CharSequence localCharSequence = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 0, localFileInfo.b());
          paramView = paramViewGroup;
          localCloudFileItemHolder1.d.setVisibility(4);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.b.setText(FileUtil.a(localFileInfo.a()));
          paramView = paramViewGroup;
          localCloudFileItemHolder1.c.setText("test test test" + localCharSequence);
          paramView = paramViewGroup;
          localCloudFileItemHolder1.d.setText(localCharSequence);
          paramView = paramViewGroup;
          a(paramInt, paramViewGroup, localCloudFileItemHolder1.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, localCloudFileItemHolder1.jdField_a_of_type_AndroidWidgetButton, localFileInfo);
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
        CloudFileAdapter.CloudFileItemHolder localCloudFileItemHolder2;
        paramViewGroup = paramView;
        paramView = localException2;
        continue;
      }
      paramView.printStackTrace();
      return paramViewGroup;
      localCloudFileItemHolder2 = (CloudFileAdapter.CloudFileItemHolder)paramView.getTag();
      paramViewGroup = paramView;
      continue;
      paramView = paramViewGroup;
      localCloudFileItemHolder2.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.CloudFileAdapter
 * JD-Core Version:    0.7.0.1
 */