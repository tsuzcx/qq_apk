package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dkm;
import java.util.LinkedHashMap;

public class QfileLocalFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public QfileLocalFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.b = paramOnClickListener1;
    this.c = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    return FileUtil.a(paramFileInfo.a());
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130838527);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public int a()
  {
    return 2130903119;
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = (dkm)paramView.getTag();
    if (localObject == null)
    {
      localObject = new dkm();
      paramView.findViewById(2131296843).setVisibility(0);
      ((dkm)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296844));
      ((dkm)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296845));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "groupPosition[" + paramInt1 + "],childPosition[" + paramInt2 + "]");
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {}
    for (;;)
    {
      try
      {
        localLocalItemHolder = new QfileLocalFileBaseExpandableListAdapter.LocalItemHolder(this);
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903408, paramViewGroup, false);
        paramView = paramViewGroup;
      }
      catch (Exception paramViewGroup)
      {
        QfileLocalFileBaseExpandableListAdapter.LocalItemHolder localLocalItemHolder;
        continue;
      }
      try
      {
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131297978));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalItemHolder);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131297983));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131297979));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131297981));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297982));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297985));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296950));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297986));
        paramView = paramViewGroup;
        localLocalItemHolder.d = ((TextView)paramViewGroup.findViewById(2131297251));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131296442));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.b);
        paramView = paramViewGroup;
        paramViewGroup.setTag(localLocalItemHolder);
        if (localFileInfo == null)
        {
          return paramViewGroup;
          localLocalItemHolder = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
          paramViewGroup = paramView;
          continue;
        }
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_Int = paramInt1;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_Int = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.a((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_JavaLangObject = localFileInfo;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localLocalItemHolder);
        paramView = paramViewGroup;
        if (FileManagerUtil.a(localFileInfo.e()) == 0)
        {
          paramView = paramViewGroup;
          if (FileUtils.b(localFileInfo.d()))
          {
            paramView = paramViewGroup;
            a(localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.d());
          }
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.e());
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
          paramView = paramViewGroup;
          localLocalItemHolder.d.setText(QfileTimeUtils.b(localFileInfo.b()));
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramView = paramViewGroup;
          localLocalItemHolder.c = 0;
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView = paramViewGroup;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
            continue;
          }
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837757);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
          break label837;
        }
        paramView = paramViewGroup;
        if (FileManagerUtil.a(localFileInfo.e()) == 2)
        {
          paramView = paramViewGroup;
          FileManagerUtil.a(localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, null, 2);
          continue;
        }
        paramView = paramViewGroup;
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        return paramView;
      }
      FileManagerUtil.a(localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.d(), localFileInfo.b());
      continue;
      paramView = paramViewGroup;
      localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      break label837;
    }
    label837:
    return paramViewGroup;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (dkm)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!paramBoolean) {
        break label150;
      }
      paramViewGroup.setContentDescription((String)localObject + "分组已展开，双击此处可收起分组");
    }
    for (;;)
    {
      paramViewGroup.setFocusable(true);
      paramViewGroup.setFocusableInTouchMode(true);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903119, paramViewGroup, false);
      paramView = new dkm();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296844));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296845));
      paramViewGroup.setTag(paramView);
      break;
      label150:
      paramViewGroup.setContentDescription((String)localObject + "分组已折叠，双击此处可展开分组");
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */