package com.tencent.mobileqq.filemanager.activity.cloudfile;

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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import diz;
import java.util.LinkedHashMap;

public class QfileCloudFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public QfileCloudFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
  
  private String a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return FileUtil.a(paramWeiYunFileInfo.jdField_a_of_type_Long);
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
    Object localObject = (diz)paramView.getTag();
    if (localObject == null)
    {
      localObject = new diz();
      paramView.findViewById(2131296843).setVisibility(0);
      ((diz)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296844));
      ((diz)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296845));
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
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject2 = new QfileCloudFileBaseExpandableListAdapter.CloudItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903408, paramViewGroup, false);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297978));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131297983));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131297979));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297981));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297982));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297985));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296950));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297986));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).d = ((TextView)paramView.findViewById(2131297251));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131296442));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.b);
        localObject1 = paramView;
        paramView.setTag(localObject2);
        paramViewGroup = (ViewGroup)localObject2;
      }
      catch (Exception paramViewGroup)
      {
        Object localObject2;
        paramView = (View)localObject1;
        continue;
        continue;
      }
      try
      {
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.jdField_b_of_type_JavaLangString);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.jdField_a_of_type_Int = paramInt2;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localWeiYunFileInfo;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362077);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
        paramViewGroup.c = 1;
        if ((FileManagerUtil.a(localWeiYunFileInfo.jdField_b_of_type_JavaLangString) == 0) && (FileUtils.b(localWeiYunFileInfo.g))) {
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.g);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localWeiYunFileInfo.jdField_b_of_type_JavaLangString);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localWeiYunFileInfo));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361946);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361977);
        localObject1 = QfileTimeUtils.b(localWeiYunFileInfo.jdField_b_of_type_Long) + a((String)localObject2, (String)localObject1);
        paramViewGroup.d.setText((CharSequence)localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
        if ((localObject1 == null) || (((FileManagerEntity)localObject1).status != 2)) {
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362075);
        paramViewGroup.c = 2;
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().b(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
          if ((localObject1 != null) && (!FileUtil.b(((FileManagerEntity)localObject1).strFilePath)))
          {
            ((FileManagerEntity)localObject1).cloudType = 2;
            ((FileManagerEntity)localObject1).nOpType = 5;
            if (((FileManagerEntity)localObject1).status == 1) {
              ((FileManagerEntity)localObject1).status = -1;
            }
            ((FileManagerEntity)localObject1).fProgress = 0.0F;
          }
          if (localObject1 != null) {
            switch (((FileManagerEntity)localObject1).status)
            {
            }
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362076);
        paramViewGroup.c = 3;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
        paramViewGroup.c = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362077);
        paramViewGroup.c = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        continue;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837757);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localWeiYunFileInfo));
      return paramView;
      localObject1 = paramView;
      paramViewGroup = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      continue;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
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
      localObject = (diz)paramView.getTag();
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
      paramView = new diz();
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */