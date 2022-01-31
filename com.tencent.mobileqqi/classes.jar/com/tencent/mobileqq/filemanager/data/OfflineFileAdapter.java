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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.List;

public class OfflineFileAdapter
  extends BaseFileAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CloudFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList;
  
  public OfflineFileAdapter(Context paramContext, List paramList, CloudFileBrowserActivity paramCloudFileBrowserActivity)
  {
    super(paramContext, paramCloudFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity = paramCloudFileBrowserActivity;
  }
  
  private String a(OfflineFileInfo paramOfflineFileInfo)
  {
    if (paramOfflineFileInfo.jdField_a_of_type_Boolean) {}
    for (String str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getString(2131558711);; str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getString(2131558709))
    {
      String str2 = FileManagerUtil.a(paramOfflineFileInfo.jdField_c_of_type_Long, -1, false);
      str2 = str2 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getString(2131558712);
      paramOfflineFileInfo = FileManagerUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getAppRuntime(), String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long), null, 0);
      String str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.getString(2131558715);
      return a(str3, str2) + a(str3, str1) + a("", paramOfflineFileInfo);
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
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
    OfflineFileInfo localOfflineFileInfo = (OfflineFileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localOfflineFileInfo == null) {
      return null;
    }
    if (paramView == null) {}
    for (;;)
    {
      try
      {
        Object localObject = new OfflineFileAdapter.CloudFileItemHolder(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903498, paramViewGroup, false);
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232737));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.c);
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject);
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131232738));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131232739));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232741));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232740));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).b = ((TextView)paramView.findViewById(2131232742));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).c = ((TextView)paramView.findViewById(2131232743));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).d = ((TextView)paramView.findViewById(2131231881));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131232131));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
        ((OfflineFileAdapter.CloudFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131231699));
        paramView.setTag(localObject);
        paramViewGroup = (ViewGroup)localObject;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataOfflineFileInfo = localOfflineFileInfo;
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localOfflineFileInfo.jdField_b_of_type_JavaLangString);
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.g()) {
          break label513;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        if (!FMDataCache.a(localOfflineFileInfo)) {
          break label502;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        localObject = FileManagerUtil.a(localOfflineFileInfo.d, -1, true);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.b.setText(FileUtil.a(localOfflineFileInfo.jdField_b_of_type_Long));
        paramViewGroup.c.setText(a(localOfflineFileInfo));
        paramViewGroup.d.setText((CharSequence)localObject);
        if ((localOfflineFileInfo.jdField_c_of_type_JavaLangString == null) || (localOfflineFileInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
          break label525;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130838612);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localOfflineFileInfo.jdField_c_of_type_JavaLangString);
        if (!a(paramInt, paramView, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, paramViewGroup.jdField_a_of_type_AndroidWidgetButton, localOfflineFileInfo.jdField_a_of_type_JavaLangString)) {
          break label541;
        }
        paramViewGroup.d.setVisibility(4);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudFileBrowserActivity.f()) || (!FMDataCache.a(localOfflineFileInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.d.setVisibility(4);
        return paramView;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return null;
      }
      paramViewGroup = (OfflineFileAdapter.CloudFileItemHolder)paramView.getTag();
      continue;
      label502:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      continue;
      label513:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      continue;
      label525:
      a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localOfflineFileInfo.jdField_b_of_type_JavaLangString, -1);
      continue;
      label541:
      paramViewGroup.d.setVisibility(0);
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OfflineFileAdapter
 * JD-Core Version:    0.7.0.1
 */