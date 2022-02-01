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
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.List;

public class LocalFileAdapter
  extends BaseFileAdapter
{
  private final int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList;
  private final int b = 1;
  
  public LocalFileAdapter(Context paramContext, List paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext, paramLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    LocalFileAdapter.LocalFileItemHolder localLocalFileItemHolder = new LocalFileAdapter.LocalFileItemHolder(this);
    if (!paramFileInfo.a())
    {
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903500, paramViewGroup, false);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramFileInfo.findViewById(2131232739));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131232740));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131232741));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131232743));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131232742));
      localLocalFileItemHolder.b = ((TextView)paramFileInfo.findViewById(2131232744));
      localLocalFileItemHolder.c = ((TextView)paramFileInfo.findViewById(2131232745));
      localLocalFileItemHolder.d = ((TextView)paramFileInfo.findViewById(2131231882));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramFileInfo.findViewById(2131230987));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramFileInfo.findViewById(2131231700));
    }
    for (;;)
    {
      paramFileInfo.setTag(localLocalFileItemHolder);
      return paramFileInfo;
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903496, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131232730));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131232732));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131232731));
    }
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
    if (((FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a()) {
      return -1;
    }
    return 1;
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
        paramViewGroup = a(localFileInfo, paramViewGroup);
        paramView = paramViewGroup;
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramViewGroup = paramView;
        paramView = localException2;
        continue;
      }
      try
      {
        paramViewGroup = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
        if (localFileInfo.a())
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130838599);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
          paramViewGroup.jdField_a_of_type_Int = paramInt;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return paramView;
        }
      }
      catch (Exception localException1)
      {
        paramViewGroup = paramView;
        paramView = localException1;
        paramView.printStackTrace();
        return paramViewGroup;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localException1.c(), FileManagerUtil.a(localException1.c()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localException1.d());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.g())
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localException1));
        str1 = FileManagerUtil.a(localException1.b(), -1, true);
        str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getString(2131558715);
        paramViewGroup.d.setVisibility(4);
        paramViewGroup.b.setText(FileUtil.a(localException1.a()));
        paramViewGroup.c.setText(str2 + str1);
        paramViewGroup.d.setText(str1);
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        a(paramInt, paramView, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, paramViewGroup.jdField_a_of_type_AndroidWidgetButton, localException1);
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */