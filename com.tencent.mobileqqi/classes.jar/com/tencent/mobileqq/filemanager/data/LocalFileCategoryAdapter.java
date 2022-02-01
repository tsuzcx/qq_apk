package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.LocalFileCategoryBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.List;

public class LocalFileCategoryAdapter
  extends BaseFileAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileCategoryBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity = null;
  private List jdField_a_of_type_JavaUtilList;
  
  public LocalFileCategoryAdapter(Context paramContext, List paramList)
  {
    super(paramContext, null);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity = ((LocalFileCategoryBrowserActivity)paramContext);
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
    Object localObject1;
    if (paramView == null) {
      localObject1 = paramView;
    }
    try
    {
      Object localObject2 = new LocalFileCategoryAdapter.LocalFileItemHolder(this);
      localObject1 = paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903500, paramViewGroup, false);
      localObject1 = paramView;
      paramView.setTag(localObject2);
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232739));
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.a);
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131232740));
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131232741));
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232742));
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).b = ((TextView)paramView.findViewById(2131232744));
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).c = ((TextView)paramView.findViewById(2131232745));
      localObject1 = paramView;
      ((LocalFileCategoryAdapter.LocalFileItemHolder)localObject2).d = ((TextView)paramView.findViewById(2131231882));
      paramViewGroup = (ViewGroup)localObject2;
      try
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
        a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), localFileInfo.b());
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.g())
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
        }
        for (;;)
        {
          localObject1 = FileManagerUtil.a(localFileInfo.b(), -1, true);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileCategoryBrowserActivity.getString(2131558715);
          paramViewGroup.d.setVisibility(4);
          paramViewGroup.b.setText(FileUtil.a(localFileInfo.a()));
          paramViewGroup.c.setText((String)localObject2 + (String)localObject1);
          paramViewGroup.d.setText((CharSequence)localObject1);
          return paramView;
          localObject1 = paramView;
          paramViewGroup = (LocalFileCategoryAdapter.LocalFileItemHolder)paramView.getTag();
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
        localException.printStackTrace();
      }
      catch (Exception localException)
      {
        paramViewGroup = paramView;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramViewGroup = localException;
        View localView = paramView;
      }
    }
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalFileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */