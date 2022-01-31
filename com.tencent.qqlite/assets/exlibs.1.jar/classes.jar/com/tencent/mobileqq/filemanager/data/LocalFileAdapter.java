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
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
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
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903428, paramViewGroup, false);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramFileInfo.findViewById(2131298051));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131298016));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131298018));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131298052));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131298022));
      localLocalFileItemHolder.b = ((TextView)paramFileInfo.findViewById(2131298054));
      localLocalFileItemHolder.c = ((TextView)paramFileInfo.findViewById(2131298023));
      localLocalFileItemHolder.d = ((TextView)paramFileInfo.findViewById(2131297255));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramFileInfo.findViewById(2131298020));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
    }
    for (;;)
    {
      paramFileInfo.setTag(localLocalFileItemHolder);
      return paramFileInfo;
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903425, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131298042));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131298044));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131298043));
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
      catch (Exception paramViewGroup)
      {
        continue;
      }
      try
      {
        paramViewGroup = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
        if (localFileInfo.a())
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130838536);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.e());
          paramViewGroup.jdField_a_of_type_Int = paramInt;
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.d(), FileManagerUtil.a(localFileInfo.d()));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.e());
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.j())
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
            String str = QfileTimeUtils.b(localFileInfo.b());
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getString(2131361978);
            paramViewGroup.b.setText(FileUtil.a(localFileInfo.a()));
            paramViewGroup.d.setText(str);
            paramViewGroup.jdField_a_of_type_Int = paramInt;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */